package cn.biosh.e3mall.common.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @description
 * @date 2019/4/24
 */
public class EmailUtil {

  private static final String sender = "993784217@qq.com";

  private static final String host = "smtp.qq.com";

  // 邮件授权码
  private static final String authCode = "lkmzvktbxictbegd";

  /**
   *  邮件发送：
   *  param  -- reciver：邮件接收者
   *            title：标题
   *            sendMessage：发送消息
   */
  public static boolean sendEmail(String reciver, String title, String sendMessage) {

    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);
    properties.put("mail.smtp.auth", "true");
    Session session = Session.getDefaultInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(sender, authCode);
      }
    });
    try {
      MimeMessage mimeMessage = new MimeMessage(session);
      mimeMessage.setFrom(new InternetAddress(sender));
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(reciver));
      mimeMessage.setSubject(title);
      mimeMessage.setText(sendMessage, "Utf-8");
      Transport.send(mimeMessage);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

}
