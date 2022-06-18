package com.windvalley.music.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.windvalley.music.dto.UserCreateRequest;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.dto.UserUpdateRequest;
import com.windvalley.music.entity.User;
import com.windvalley.music.vo.UserQueryVO;

import java.util.List;

public interface IUserService extends IService<User> {
    List<UserDTO> listAll();

    IPage<User> searchFor(Page<User> pagePara, UserQueryVO userQueryVO);

    UserDTO register(UserCreateRequest userCreateRequest);

    UserDTO getInfoById(String id);

    Boolean updateInfoById(String id, UserUpdateRequest userUpdateRequest);

    String createToken(String userName, String password);

    UserDTO getCurrentUser();
}
