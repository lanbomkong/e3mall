package cn.biosh.e3mall.account.mq;

import cn.biosh.e3mall.common.util.EmailUtil;
import cn.biosh.e3mall.common.util.JsonUtil;
import cn.biosh.e3mall.dal.model.TbUser;
import cn.biosh.e3mall.mq.config.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/5/31
 */
@Component
public class AccountRegisterListener extends Consumer {

    Logger logger = LoggerFactory.getLogger(AccountRegisterListener.class);

    private static final String registerTitle = "铁道口皇家男子自建网站会员注册成功！";
    private static final String registerMessage = "牛逼轰轰的%s你好， 恭喜你已成功注册为铁道口皇家男子自建网站会员，你将走向人生巅峰！";

    @Override
    public void dealBody(String message) {
        logger.info("成功消费消息：" + message);
        TbUser tbUser = JsonUtil
            .jsonStringToObject(message, TbUser.class);
        logger.info(
            EmailUtil.sendEmail(tbUser.getEmail(), registerTitle,
                String.format(registerMessage, tbUser.getUsername())) ? "邮件通知成功！"
                : "邮件通知失败！");
    }
}
