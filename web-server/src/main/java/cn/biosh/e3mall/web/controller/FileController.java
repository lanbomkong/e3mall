package cn.biosh.e3mall.web.controller;

import cn.biosh.e3mall.common.dubbo.FileInterface;
import cn.biosh.e3mall.common.serialize.SysMultipartFile;
import com.alibaba.dubbo.config.annotation.Reference;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description
 * @date 2019/4/17
 */
@RestController
@RequestMapping("/file")
public class FileController {

  @Reference(version = "1.0.0")
  private FileInterface fileInterface;

  @PostMapping("/upload")
  public Object uploadFile(MultipartFile uploadFile) {
    SysMultipartFile file = new SysMultipartFile();
    file.setFileName(uploadFile.getOriginalFilename()
        .substring(uploadFile.getOriginalFilename().lastIndexOf(".") + 1));
    file.setSize(uploadFile.getSize());
    try {
      file.setInputStream(uploadFile.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileInterface.uploadFile(file);
  }

}
