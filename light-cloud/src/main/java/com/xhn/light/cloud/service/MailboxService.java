package com.xhn.light.cloud.service;

/**
 * @author ：xhn
 * @date ：2022/2/15 15:49
 * @description：
 */
public interface MailboxService {
    void sendMailBox(String code,String email);
    void sendPush( String email,String message);
}
