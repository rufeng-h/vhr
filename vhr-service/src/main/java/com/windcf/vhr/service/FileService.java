package com.windcf.vhr.service;

import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

/**
 * @author chunf
 * @time 2022-09-24 15:42
 * @package com.windcf.vhr.service
 * @description server file oper service
 */
public interface FileService {
    /**
     * 删除本地文件
     *
     * @param path path
     * @return 本地不存在、删除成功返回true
     */
    boolean remove(String path);

    /**
     * upload avatar
     *
     * @param file the file
     * @return uri
     */
    URI uploadAvatar(MultipartFile file);
}
