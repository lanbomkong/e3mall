package cn.biosh.e3mall.web.dto.input.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

/**
 * @description
 * @date 2019/4/22
 */
public class RegistForm {

  @NotBlank(message = "username can not null!")
  @Pattern(regexp = "^[a-z]+[0-9]+$")
  private String username;

  @NotBlank(message = "password can not null!")
  @Pattern(regexp = "^[A-Z]+[a-z]*[0-9]+$")
  @Length(min = 6, message = "the length of username can not less than six!")
  private String password;

  @Pattern(regexp = "^null|(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")
  private String phone;

  @NotBlank(message = "email can not null!")
  @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
  private String email;

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return phone;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }
}
