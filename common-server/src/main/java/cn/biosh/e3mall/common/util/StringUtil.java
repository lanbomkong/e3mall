package cn.biosh.e3mall.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @description
 * @date 2019/4/15
 */
public class StringUtil {

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
        num += num<0 ? 256 : 0;
        if (num < 16) cencryptionText.append("0");
        cencryptionText.append(Integer.toHexString(num));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return cencryptionText.toString();
  }


}
