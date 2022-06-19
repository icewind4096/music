package com.windvalley.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.windvalley.music.entity.Role;
import com.windvalley.music.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
