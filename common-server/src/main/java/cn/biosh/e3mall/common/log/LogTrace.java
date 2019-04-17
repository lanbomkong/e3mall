package cn.biosh.e3mall.common.log;

/**
 * @author jasfeng
 */
public class LogTrace {

  private static final ThreadLocal<HttpTraceLog> LOGER = new ThreadLocal<HttpTraceLog>();


  public static void set(HttpTraceLog ioLog) {
    LOGER.set(ioLog);
  }


  public static HttpTraceLog get() {
    HttpTraceLog ioLog = LOGER.get();
    if (ioLog == null) {
      HttpTraceLog ioLogitem = new HttpTraceLog();
      LOGER.set(ioLogitem);
    }
    return LOGER.get();
  }

  public static void clearAll() {
    LOGER.remove();
  }


}
