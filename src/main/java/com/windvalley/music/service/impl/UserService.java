package com.windvalley.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.windvalley.music.common.base.exception.WindvalleyException;
import com.windvalley.music.common.base.result.ResultCodeEnum;
import com.windvalley.music.common.base.util.MD5;
import com.windvalley.music.convert.UserConvert;
import com.windvalley.music.dto.UserCreateDTO;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.entity.User;
import com.windvalley.music.mapper.UserMapper;
import com.windvalley.music.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserConvert userConvert;

//    @Override
//    public User loadUserByUsername(String userName) {
//        User user = findUserByName(userName);
//
//        if (user == null){
//            throw new WindvalleyException(ResultCodeEnum.USER_NOT_EXISTS_ERROR);
//        }
//
//        return user;
//    }

    @Override
    public List<UserDTO> listAll() {
        return userMapper.selectList(null).stream().map(userConvert::toDTO).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserDTO register(UserCreateDTO userCreateDTO) {
        //保存用户 user
        User user = registerUserInfoByDTO(userCreateDTO);

        return userConvert.toDTO(user);
    }

    private User registerUserInfoByDTO(UserCreateDTO userCreateDTO) {
        if (checkUserName(userCreateDTO.getUserName())){
            throw new WindvalleyException(ResultCodeEnum.REGISTER_USER_ALREADY_EXISTS_ERROR);
        }

        userCreateDTO.setPassword(MD5.encrypt(userCreateDTO.getPassword()));

        return registerUser(userCreateDTO);
    }

    private User registerUser(UserCreateDTO userCreateDTO) {
        User user = userConvert.toEntriy(userCreateDTO);

        baseMapper.insert(user);

        return user;
    }

    private Boolean checkUserName(String userName){
        User user = findUserByName(userName);
        return user != null;
    }

    private User findUserByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", userName);

        return baseMapper.selectOne(queryWrapper);
    }
}
