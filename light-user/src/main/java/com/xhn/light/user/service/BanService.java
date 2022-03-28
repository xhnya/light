package com.xhn.light.user.service;

import com.xhn.light.user.entity.BanEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.user.entity.vo.BanVo;

/**
* @author xhn
* @description 针对表【ums_ban(封禁用户表)】的数据库操作Service
* @createDate 2022-03-28 16:59:25
*/
public interface BanService extends IService<BanEntity> {


    int relieve(Long id);

    int ban(BanVo ban);
}
