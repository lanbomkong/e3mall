package cn.biosh.e3mall.common.advice;

import cn.biosh.e3mall.common.exception.SysStubInfo;
import cn.biosh.e3mall.common.log.LogTrace;
import cn.biosh.e3mall.common.util.ResultView;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @description
 * @date 2019/4/16
 */
@ControllerAdvice
public class SystemAdvice implements ResponseBodyAdvice {

  private final static Object EMPTY_DATA = Collections.emptyList();
  private Logger logger = LoggerFactory.getLogger(SystemAdvice.class);

  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
      Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    Object result = null;
    try {
      if (o instanceof ResultView || o instanceof String) {
        result = o;
        return result;
      }
      if (o == null) {
        o = EMPTY_DATA;
      }
      result = new ResultView(SysStubInfo.DEFAULT_SUCCESS, o);
      return result;
    } finally {
      try {
        ObjectMapper objectMapper = new ObjectMapper();
        LogTrace.get().setSpendTime(System.currentTimeMillis() - LogTrace.get().getStartTime());
        LogTrace.get().setRespParams(objectMapper.writeValueAsString(result));
        logger.info("Trace log is ====>  " + objectMapper.writeValueAsString(LogTrace.get()));
      } catch (Exception e) {
        logger.error("Trace log error : ", e);
      } finally {
        LogTrace.clearAll();
      }
    }
  }
}
