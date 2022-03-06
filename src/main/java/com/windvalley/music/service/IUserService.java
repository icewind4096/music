package com.windvalley.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService extends IService<User> {
    List<UserDTO> userList();
}
