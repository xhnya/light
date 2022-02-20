package com.xhn.light.community.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xhn
 * @date 2022/2/20 13:00
 * @description:
 */
@Data
public class HistoryViewList {

    private Long id;
    private Date data;
    private String name;
    private List<HistoryViewList> content;
}
