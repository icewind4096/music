package com.windvalley.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.windvalley.music.convert.UserConvert;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.entity.User;
import com.windvalley.music.mapper.UserMapper;
import com.windvalley.music.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserConvert userConvert;

    @Override
    public List<UserDTO> useList() {
        return userMapper.selectList(null).stream().map(userConvert::toDTO).collect(Collectors.toList());
    }
}
