package com.windvalley.music.controller.test;

import com.windvalley.music.convert.UserConvert;
import com.windvalley.music.service.IUserService;
import com.windvalley.music.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    UserConvert userConvert;

    @ApiOperation("用户列表")
    @GetMapping("list")
    public List<UserVO> list(){
        return userService.useList().stream().map(userConvert::toVO).collect(Collectors.toList());
    }
}
