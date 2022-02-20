package com.xhn.light.community.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/2/20 12:17
 * @description:
 */
@Data
public class UserHistoryViewList {

    private Long id;
    private Long pageId;
    private String title;
    private Date watchTime;
    private Date watchDays;
    private String days;

}
