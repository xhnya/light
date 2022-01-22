package com.xhn.light.cloud.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

import com.xhn.light.cloud.service.VodService;
import com.xhn.light.cloud.utils.ConstantVodUtils;
import com.xhn.light.cloud.utils.InitVodClient;
import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xhn
 * @data 2021/2/5 - 12:00
 */
@RestController
@RequestMapping("/cloud/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    /**
     * 上传视频到阿里云当中
     * @param file
     * @return
     */
    @PostMapping("uploadAlyunVideo")
    public Result uploadAlyunVideo(MultipartFile file){
        //放回上传视频的id
        String videoId=vodService.uploadVideoAlyun(file);

        return Result.ok().data("videoId",videoId);
    }

    /**
     * 删除阿里云的视频
     * @param id
     * @return
     */
    @DeleteMapping("removeAlyunVideo/{id}")
    public Result removeAlyunVideo(@PathVariable String id){

        try {
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);

            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(id);
            client.getAcsResponse(request);
            return Result.ok();

        }catch (Exception e){
            e.printStackTrace();
            throw  new LightException(20001,"删除视频失败");
        }
    }

    /**
     * 删除多个阿里云视频
     * 参数是多个id
     * @param videoList
     * @return
     */
    @DeleteMapping("deleteBatch")
    public Result deleteBatch(@RequestParam("videoList") List<String> videoList){
        vodService.removeMoreAlyVideo(videoList);
        return Result.ok();
    }

    @GetMapping("getPlayAuth/{id}")
    public Result getPlayAuth(@PathVariable String id){
        try {
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();

            request.setVideoId(id);
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);

            String playAuth = response.getPlayAuth();
            return Result.ok().data("playAuth",playAuth);

        }catch (Exception e){
            throw new LightException(20001,"获取视频失败");
        }
    }





}
