package cn.biosh.e3mall.fastdfs.service;

import cn.biosh.e3mall.common.dubbo.FileInterface;
import cn.biosh.e3mall.common.serialize.SysMultipartFile;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @description
 * @date 2019/4/17
 */
@Component
@Service(version = "1.0.0", interfaceClass = FileInterface.class)
public class FileService implements FileInterface {

  @Autowired
  private FastFileStorageClient fastFileStorageClient;

  @Override
  public String uploadFile(SysMultipartFile file) {
    if (StringUtils.isEmpty(file)) {
      return "file null";
    }else {
      return fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(),
          file.getFileName(), null).getFullPath();
    }
  }

}
