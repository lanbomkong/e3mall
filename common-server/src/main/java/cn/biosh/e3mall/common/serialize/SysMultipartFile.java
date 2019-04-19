package cn.biosh.e3mall.common.serialize;

import java.io.Serializable;

/**
 * @description
 * @date 2019/4/18
 */
public class SysMultipartFile implements  Serializable {

  private String inputStream;

  private Long size;

  private String fileName;

  public void setInputStream(String inputStream) {
    this.inputStream = inputStream;
  }

  public String getInputStream() {
    return inputStream;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Long getSize() {
    return size;
  }

  public String getFileName() {
    return fileName;
  }
}
