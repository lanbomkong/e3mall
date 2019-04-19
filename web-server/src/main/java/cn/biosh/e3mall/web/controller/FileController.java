package cn.biosh.e3mall.web.controller;

import cn.biosh.e3mall.web.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  private static final Logger logger = LoggerFactory.getLogger(FileController.class);

  @Autowired
  private FileService fileService;

  @PostMapping("/upload")
  public Object uploadFile(MultipartFile uploadFile) {
    return fileService.uploadFile(uploadFile);
  }

}
