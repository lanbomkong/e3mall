package cn.biosh.e3mall.common.dubbo;

import cn.biosh.e3mall.common.serialize.SysMultipartFile;

/**
 * @description
 * @date 2019/4/17
 */
public interface FileInterface {

  String uploadFile(SysMultipartFile file);

}
