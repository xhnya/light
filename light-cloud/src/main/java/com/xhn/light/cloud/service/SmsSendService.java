package com.xhn.light.cloud.service;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/15 16:15
 * @description：
 */
public interface SmsSendService {
    Boolean send(Map<String,Object> params, String phone);
}
