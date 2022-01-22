package com.xhn.light.cloud.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xhn
 * @data 2021/2/5 - 12:01
 */
public interface VodService {
    String uploadVideoAlyun(MultipartFile file);

    void removeMoreAlyVideo(List videoList);
}
