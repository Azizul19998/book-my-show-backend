package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.Model.UserEntity;
import com.example.bookMyShow.demo.dto.EntryDto.UserEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.UserResponseDto;


public interface UserService {
    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);




    UserEntity getUserEntity(int id);
}
