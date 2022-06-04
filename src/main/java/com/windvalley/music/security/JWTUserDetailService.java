package com.windvalley.music.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.windvalley.music.common.base.exception.WindvalleyException;
import com.windvalley.music.common.base.result.ResultCodeEnum;
import com.windvalley.music.entity.User;
import com.windvalley.music.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JWTUserDetailService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    //使用用户查询
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.windvalley.music.entity.User user = findUserByName(userName);

        if (user == null) {
            throw new WindvalleyException(ResultCodeEnum.USER_NOT_EXISTS_ERROR);
        }

        List<SimpleGrantedAuthority> collect = new ArrayList<SimpleGrantedAuthority>();
        return new JWTUserDetail(user, collect);
    }

    private com.windvalley.music.entity.User findUserByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", userName);

        return userMapper.selectOne(queryWrapper);
    }
}
