package com.windvalley.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.windvalley.music.convert.RoleConvert;
import com.windvalley.music.dto.RoleDTO;
import com.windvalley.music.entity.Role;
import com.windvalley.music.mapper.RoleMapper;
import com.windvalley.music.service.IRoleService;
import com.windvalley.music.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleConvert roleConvert;

    @Override
    public List<RoleVO> getRolesByUserName(String userName) {
        List<Role> roles = roleMapper.getRolesByUserName(userName);

        List<RoleVO> roleVOs = roleConvert.toDTOList(roles);

        return roleVOs;
    }
}
