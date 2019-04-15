package cn.biosh.e3mall.web.dto.input;


import javax.validation.constraints.NotBlank;

/**
 * @description
 * @date 2019/4/15
 */
public class LoginForm {

  @NotBlank(message = "username can not null!")
  private String username;

  @NotBlank(message = "password can not null!")
  private String password;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
