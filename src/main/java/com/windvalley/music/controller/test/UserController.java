package com.windvalley.music.controller.test;

import com.windvalley.music.common.base.result.R;
import com.windvalley.music.convert.UserConvert;
import com.windvalley.music.dto.UserCreateDTO;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.service.IUserService;
import com.windvalley.music.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(description = "用户")
@RequestMapping("/api/users")
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    UserConvert userConvert;

    @ApiOperation("用户列表")
    @GetMapping("list")
    public R list(){
        List<UserVO> userVOS = userService.listAll().stream().map(userConvert::toVO).collect(Collectors.toList());
        return R.ok().data("items", userVOS);
    }

    @ApiOperation("用户注册")
    @PostMapping("register")
    public R register(@ApiParam(value = "用户注册信息", required = true) @RequestBody UserCreateDTO userCreateDTO){
        UserDTO userDTO = userService.register(userCreateDTO);
        return R.ok().data("user", userDTO).message("注册成功");
    }
}
