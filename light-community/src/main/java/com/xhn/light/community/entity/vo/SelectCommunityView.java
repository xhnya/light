package com.xhn.light.community.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/17 10:01
 * @description： 社区的级联选择
 */
@Data
public class SelectCommunityView {

    private Long value;
    private String label;
    private List<SelectCommunityView> children;

}
