package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.UserDto;

public interface UserService {
    void addUser(UserDto userDto);

    UserDto getUser(int id);
}
