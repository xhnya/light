package com.xhn.light.cloud.controller;

import com.xhn.light.cloud.service.OssService;
import com.xhn.light.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xhn
 * @date 2021/12/7 22:26
 */
@RestController
@RequestMapping("/cloud/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @PostMapping("upload")
    public Result uploadOssFile(MultipartFile file){
        String url=ossService.uploadFileAvatar(file);
        return Result.ok().data("url",url);
    }
}
