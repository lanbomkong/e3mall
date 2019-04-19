package cn.biosh.e3mall.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description
 * @date 2019/4/15
 */
public class StringUtil {

  private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

  // dubbo数据传递不允许文件流传递，故将inputStream转成string传递
  public static String inputStreamToString(InputStream inputStream) {
    ByteArrayOutputStream input = new ByteArrayOutputStream();

    int n;
    try {
      while ((n = inputStream.read()) != -1) {
          input.write(n);
      }
    } catch (IOException e) {
      logger.error("inputString read error!");
    }
    System.out.println(input.toString());
    return input.toString();
  }

  // 生成用户身份令牌Token
  public static String generatorToken() {
    return encryption(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
        + UUID.randomUUID().toString().replaceAll("-", ""));
  }

  // 明文加密：md5加密后将转换城十六进制
  public static String encryption(String plainText) {
    StringBuilder cencryptionText = new StringBuilder();
    try {
      MessageDigest digest = MessageDigest.getInstance("md5");
      digest.update(plainText.getBytes());
      byte[] msg = digest.digest();

      int num;
      for (int i = 0; i < msg.length; i++) {
        num = msg[i];
        num += num < 0 ? 256 : 0;
        if (num < 16) {
          cencryptionText.append("0");
        }
        cencryptionText.append(Integer.toHexString(num));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return cencryptionText.toString();
  }


}
