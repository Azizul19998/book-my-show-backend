package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.UserEntity;
import com.example.bookMyShow.demo.dto.EntryDto.UserEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.UserResponseDto;
//import com.example.bookMyShow.demo.dto.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass

public class UserConverter {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto)
    {
        //i need to create user object
        return UserEntity.builder()
                .name(userEntryDto.getName())
                .mobile(userEntryDto.getMobile())
                .build();
    }
    public static UserResponseDto convertEntityToDto(UserEntity userEntity)
    {
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobile(userEntity.getMobile())
                .tickets(userEntity.getTicketEntities())
                .build();

    }
}
