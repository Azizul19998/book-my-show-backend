package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.UserEntity;
import com.example.bookMyShow.demo.dto.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass

public class UserConverter {
    public static UserEntity convertDtoToEntity(UserDto userDto)
    {
        //i need to create user object
        return UserEntity.builder()
                .name(userDto.getName())
                .mobile(userDto.getMobileNo())
                .build();
    }
    public static UserDto convertEntityToDto(UserEntity userEntity)
    {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobileNo(userEntity.getMobile())
                .build();

    }
}
