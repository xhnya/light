package com.xhn.light.cloud.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xhn.light.cloud.service.SmsSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/15 16:16
 * @description：
 */
@Slf4j
@Service
public class SmsSendServiceImpl implements SmsSendService {
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessSecret}")
    private String accessSecret;

    @Override
    public Boolean send(Map<String, Object> params, String phone) {
        if (StringUtils.isEmpty(phone)) return false;

        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);//自己账号的AccessKey信息
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");//短信服务的服务接入地址
        request.setSysVersion("2017-05-25");//API的版本号
        request.setSysAction("SendSms");//API的名称
        request.putQueryParameter("PhoneNumbers", phone);//接收短信的手机号码
        request.putQueryParameter("SignName", "xhnya");//短信签名名称
        request.putQueryParameter("TemplateCode", "SMS_211491589");//短信模板ID
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(params));//短信模板变量对应的实际值
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
            boolean success = response.getHttpResponse().isSuccess();
            return success;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
