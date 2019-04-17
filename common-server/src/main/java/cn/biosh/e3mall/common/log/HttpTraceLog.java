package cn.biosh.e3mall.common.log;

public class HttpTraceLog {

  /**
   * 请求地址
   */
  private String url;
  /**
   * 请求方式
   */
  private String httpMethod;
  /**
   * 请求头
   */
  private Object reqHeader;
  /**
   * 请求参数
   */
  private String reqParams;

  /**
   * 请求body
   */
  private String requestBody;
  /**
   * 响应参数
   */
  private Object respParams;
  /**
   * 开始时间
   */
  private long startTime;

  /**
   * 花费时间
   */
  private long spendTime;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
  }

  public String getReqParams() {
    return reqParams;
  }

  public void setReqParams(String reqParams) {
    this.reqParams = reqParams;
  }

  public Object getRespParams() {
    return respParams;
  }

  public void setRespParams(Object respParams) {
    this.respParams = respParams;
  }

  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  public long getSpendTime() {
    return spendTime;
  }

  public String getRequestBody() {
    return requestBody;
  }

  public Object getReqHeader() {
    return reqHeader;
  }

  public void setReqHeader(Object reqHeader) {
    this.reqHeader = reqHeader;
  }

  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  public void setSpendTime(long spendTime) {
    this.spendTime = spendTime;
  }
}
