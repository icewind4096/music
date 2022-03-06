package com.windvalley.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.windvalley.music.entity.Role;
import com.windvalley.music.mapper.RoleMapper;
import com.windvalley.music.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}