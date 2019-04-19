package cn.biosh.e3mall.web.service;

import cn.biosh.e3mall.common.constants.FileRetStubDetail;
import cn.biosh.e3mall.common.dubbo.SystemException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description
 * @date 2019/4/19
 */
@Service
public class FileService {

  @Autowired
  private FastFileStorageClient fileStorageClient;

  public String uploadFile(MultipartFile file) {
    try {
      return fileStorageClient.uploadFile(file.getInputStream(),
          file.getSize(),
          file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1),
          null).getFullPath();
    } catch (IOException e) {
      throw new SystemException(FileRetStubDetail.FILE_UPLOAD_FAIL);
    }
  }

}
