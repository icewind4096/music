package com.windvalley.music.controller.front;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.windvalley.music.common.base.result.R;
import com.windvalley.music.convert.UserConvert;
import com.windvalley.music.dto.UserCreateRequest;
import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.dto.UserUpdateRequest;
import com.windvalley.music.entity.User;
import com.windvalley.music.service.IUserService;
import com.windvalley.music.vo.UserQueryVO;
import com.windvalley.music.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
    @PostMapping("list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R list(){
        List<UserVO> userVOS = userService.listAll().stream().map(userConvert::toVO).collect(Collectors.toList());
        return R.ok().data("items", userVOS);
    }

    @ApiOperation("用户分页列表")
    @PostMapping("list/{current}/{size}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R search(@ApiParam(value = "当前页码", required = true) @PathVariable Long current
            , @ApiParam(value = "每页记录数", required = true) @PathVariable Long size
            , @ApiParam("查询条件对象") UserQueryVO userQueryVO) {
        Page<User> pagePara = new Page<>(current, size);

        IPage<User> pageModel = userService.searchFor(pagePara, userQueryVO);

        List<UserVO> users = pageModel.getRecords().stream().map(userConvert::toDTO).collect(Collectors.toList()).stream().map(userConvert::toVO).collect(Collectors.toList());

        Long total = pageModel.getTotal();

        return R.ok().data("total", total).data("rows", users);
    }

    @ApiOperation("根据用户ID获得用户信息")
    @PostMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R infoById(@ApiParam(value="用户ID", required = true) @PathVariable(value = "id", required = true) String id){
        UserDTO userDTO = userService.getInfoById(id);
        return R.ok().data("item", userDTO);
    }

    @ApiOperation("用户注册")
    @PostMapping("register")
    public R register(@Validated @ApiParam(value = "用户注册信息", required = true) @RequestBody UserCreateRequest userCreateRequest){
        UserDTO userDTO = userService.register(userCreateRequest);
        return R.ok().data("user", userDTO).message("用户注册成功");
    }

    @ApiOperation("用户修改")
    @PostMapping("{id}/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R updateInfoById(@ApiParam(value = "修改用户信息", required = true) @PathVariable(value="id", required = true) String id, @RequestBody UserUpdateRequest userUpdateRequest){
        if (userService.updateInfoById(id, userUpdateRequest)){
            return R.ok().message("修改用户数据成功");
        }
        return R.error().message("修改用户数据失败");
    }

    @ApiOperation("用户删除")
    @PostMapping("{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public R deleteInfoById(@ApiParam(value = "删除用户信息", required = true) @PathVariable(value="id", required = true) String id){
        if (userService.removeById(id)){
            return R.ok().message("删除用户数据成功");
        }
        return R.error().message("删除用户数据失败");
    }

    @ApiOperation("当前用户信息")
    @PostMapping("/me")
    public R currentUser(){
        UserVO userVO = userConvert.toVO(userService.getCurrentUser());

        return R.ok().data("item", userVO);
    }
}
