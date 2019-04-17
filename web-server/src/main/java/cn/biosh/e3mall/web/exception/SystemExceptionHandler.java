package cn.biosh.e3mall.web.exception;

import cn.biosh.e3mall.common.exception.SysStubInfo;
import cn.biosh.e3mall.common.dubbo.SystemException;
import cn.biosh.e3mall.common.util.ResultView;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @description
 * @date 2019/4/16
 */
@ControllerAdvice
public class SystemExceptionHandler {

  private static final Map EMPTY_DATA = Collections.emptyMap();
  private Logger logger = LoggerFactory.getLogger(
      SystemExceptionHandler.class);
  
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public Object exceptionHadnle(Exception exception) {
    logger.error("exception for handle:" + exception);
    exception.printStackTrace();
    ResultView view;
    if (exception instanceof SystemException) {
      view = new ResultView();
      SystemException systemException = (SystemException)exception;
      view.setCode(systemException.getRetStub().getCode());
      view.setMessage(systemException.getRetStub().getMsg());
      view.setData(EMPTY_DATA);
    }else if (exception instanceof ConstraintViolationException) {
      ConstraintViolationException applicationException = (ConstraintViolationException) exception;
      Set<ConstraintViolation<?>> violations = applicationException.getConstraintViolations();
      StringBuilder stringBuilder = new StringBuilder();
      for (ConstraintViolation<?> item : violations) {
        stringBuilder.append("[" + item.getMessage() + "]");
      }
      String msg = stringBuilder.toString();
      logger.error("ConstraintViolation msg is : " + msg);
      view = new ResultView(SysStubInfo.PARAMETER_TYPE_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException applicationException = (MethodArgumentNotValidException) exception;
      List<ObjectError> allErrors = applicationException.getBindingResult().getAllErrors();
      StringBuilder stringBuilder = new StringBuilder();
      for (ObjectError error : allErrors) {
        stringBuilder.append("[" + error.getDefaultMessage() + "]");
      }
      String msg = stringBuilder.toString();
      logger.error("ArgumentNotValid  msg is : " + msg);
      view = new ResultView(SysStubInfo.PARAMETER_TYPE_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof MissingServletRequestParameterException) {
      MissingServletRequestParameterException applicationException = (MissingServletRequestParameterException) exception;
      String parameterName = applicationException.getParameterName();
      String parameterType = applicationException.getParameterType();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder
          .append("parameter " + parameterName + " is null " + " , expect: " + parameterType);
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.PARAMETER_IS_NULL, msg, EMPTY_DATA);
    } else if (exception instanceof HttpMediaTypeNotSupportedException) {
      HttpMediaTypeNotSupportedException applicationException = (HttpMediaTypeNotSupportedException) exception;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(applicationException.getContentType().getSubtype());
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.CONTENT_TYPE_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof HttpRequestMethodNotSupportedException) {
      HttpRequestMethodNotSupportedException applicationException = (HttpRequestMethodNotSupportedException) exception;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(applicationException.getMethod());
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.METHOD_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof NoHandlerFoundException) {
      NoHandlerFoundException applicationException = (NoHandlerFoundException) exception;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(
          applicationException.getHttpMethod() + " --> " + applicationException.getRequestURL());
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.RESOURCE_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof MethodArgumentTypeMismatchException) {
      MethodArgumentTypeMismatchException applicationException = (MethodArgumentTypeMismatchException) exception;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(
          "parameter " + applicationException.getName() + " is not type of " + applicationException
              .getRequiredType().getSimpleName());
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.PARAMETER_TYPE_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof HttpMessageNotReadableException) {
      HttpMessageNotReadableException applicationException = (HttpMessageNotReadableException) exception;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(applicationException.getMessage());
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.REQUEST_BODY_INVALID, msg, EMPTY_DATA);
    } else if (exception instanceof BindException) {
      BindException applicationException = (BindException) exception;
      BindingResult bindingResult = applicationException
          .getBindingResult();
      FieldError fieldError = bindingResult.getFieldError();
      String field = fieldError.getField();
      // String code = fieldError.getCode();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(field);
      String msg = stringBuilder.toString();
      view = new ResultView(SysStubInfo.PARAMETER_IS_NULL, msg, EMPTY_DATA);
    } else {
      view = new ResultView(SysStubInfo.DEFAULT_FAIL, EMPTY_DATA);
    }
    return view;
  }
}
