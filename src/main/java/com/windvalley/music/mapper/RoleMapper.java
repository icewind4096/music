package com.windvalley.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.windvalley.music.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRolesByUserName(String userName);
}
