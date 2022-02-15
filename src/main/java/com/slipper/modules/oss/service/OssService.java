package com.slipper.modules.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * OSS 存储对象
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface OssService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    String upload(MultipartFile file, Boolean watermark);

}

