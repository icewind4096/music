package com.windvalley.music.convert;

import com.windvalley.music.dto.UserDTO;
import com.windvalley.music.entity.User;
import com.windvalley.music.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConvert {
    UserDTO toDTO(User user);

    UserVO toVO(UserDTO userDTO);
}
