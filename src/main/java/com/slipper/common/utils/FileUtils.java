package com.slipper.common.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author gumingchen
 */
@Slf4j
public class FileUtils {
    /**
     * 本地文件存储
     * @param file 文件
     * @param path 文件存储的完整路径
     * @return
     */
    public static Boolean upload (MultipartFile file, String path) {
        // 判断是否存在文件夹 不存在则创建
        folderIsExist(path.substring(0, path.lastIndexOf("/")));
        // 创建文件
        File dest = new File(path);
        // 保存文件
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 七牛云文件上传
     * @param file 文件
     * @param accessKey AccessKey
     * @param secretKey SecretKey
     * @param bucket 空间名
     * @param key 前缀 + / + 文件名
     * @return
     */
    public static Boolean upload(MultipartFile file, String accessKey, String secretKey, String bucket, String key) {
        Boolean result = true;

        Configuration configuration = new Configuration(Region.region0());
        UploadManager uploadManager = new UploadManager(configuration);
        byte[] uploadBytes = new byte[0];

        try {
            uploadBytes = file.getBytes();
        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }

        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(byteInputStream, key,upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            log.info(putRet.key);
            log.info(putRet.hash);
        } catch (QiniuException ex) {
            result = false;
            Response r = ex.response;
            log.error(r.toString());
            try {
                log.error(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }
        return result;
    }

    /**
     * 判断文件是否为图片
     * @param file
     * @return
     */
    public static Boolean isImage(MultipartFile file) {
        return false;
    }

    /**
     * 判断文件夹是否存在 不存在则创建
     * @param path
     */
    private static void folderIsExist (String path) {
        String[] paths = path.split("/");
        String dir = paths[0];
        for (int i = 0; i < paths.length - 1; i++) {
            try {
                dir = dir + "/" + paths[i + 1];
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                    System.out.println("创建目录为：" + dir);
                }
            } catch (Exception err) {
                System.err.println("文件夹创建发生异常");
            }
        }
    }

}
