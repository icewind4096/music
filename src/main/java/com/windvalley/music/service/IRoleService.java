package com.windvalley.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.windvalley.music.entity.Role;
import com.windvalley.music.vo.RoleVO;

import java.util.List;

public interface IRoleService extends IService<Role> {
    List<RoleVO> getRolesByUserName(String userName);
}
