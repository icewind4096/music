package com.windvalley.music.convert;

import com.windvalley.music.dto.RoleDTO;
import com.windvalley.music.entity.Role;
import com.windvalley.music.vo.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleConvert {
    RoleDTO toDTO(Role role);

    RoleVO toVO(Role role);

    List<RoleVO> toDTOList(List<Role> roles);
}
