package com.windvalley.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.windvalley.music.common.base.enums.Gender;
import com.windvalley.music.common.base.exception.WindvalleyException;
import com.windvalley.music.common.base.result.ResultCodeEnum;
import com.windvalley.music.common.base.util.MD5;
import com.windvalley.music.convert.UserConvert;
import com.windvalley.music.dto.UserCreateRequest;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.dto.UserUpdateRequest;
import com.windvalley.music.entity.User;
import com.windvalley.music.mapper.UserMapper;
import com.windvalley.music.service.IUserService;
import com.windvalley.music.vo.UserQueryVO;
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

    @Override
    public List<UserDTO> listAll() {
        return userMapper.selectList(null).stream().map(userConvert::toDTO).collect(Collectors.toList());
    }

    @Override
    public IPage<User> searchFor(Page<User> pagePara, UserQueryVO userQueryVO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("username");

//        if (userQueryVO == null){
            return baseMapper.selectPage(pagePara, queryWrapper);
//        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserDTO register(UserCreateRequest userCreateRequest) {
        User user = registerUserInfoByDTO(userCreateRequest);

        return userConvert.toDTO(user);
    }

    @Override
    public UserDTO getInfoById(String id) {
        User user = userMapper.selectById(id);

        return userConvert.toDTO(user);
    }

    @Override
    public Boolean updateInfoById(String id, UserUpdateRequest userUpdateRequest) {
        User user = userMapper.selectById(id);

        if (user == null) return false;

        if (userUpdateRequest.getUserName() != null){
            user.setUserName(userUpdateRequest.getUserName());
        }

        if (userUpdateRequest.getNickName() != null){
            user.setNickName(userUpdateRequest.getNickName());
        }

        if (userUpdateRequest.getGender() != null){
            user.setGender( Enum.valueOf(Gender.class, userUpdateRequest.getGender()));
        }

        return userMapper.updateById(user) > 0;
    }

    private User registerUserInfoByDTO(UserCreateRequest userCreateRequest) {
        if (checkUserName(userCreateRequest.getUserName())){
            throw new WindvalleyException(ResultCodeEnum.REGISTER_USER_ALREADY_EXISTS_ERROR);
        }

        userCreateRequest.setPassword(MD5.encrypt(userCreateRequest.getPassword()));

        return registerUser(userCreateRequest);
    }

    private User registerUser(UserCreateRequest userCreateRequest) {
        User user = userConvert.toEntriy(userCreateRequest);

        baseMapper.insert(user);

        return user;
    }

    private Boolean checkUserName(String userName){
        User user = getInfoByName(userName);
        return user != null;
    }

    private User getInfoByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", userName);

        return baseMapper.selectOne(queryWrapper);
    }
}
