package cn.biosh.e3mall.common.serialize;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @description
 * @date 2019/4/18
 */
public class SysMultipartFile implements  Serializable {

  private InputStream inputStream;

  private Long size;

  private String fileName;

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public InputStream getInputStream() {
    return inputStream;
  }

  public Long getSize() {
    return size;
  }

  public String getFileName() {
    return fileName;
  }
}
