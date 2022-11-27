package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.UserConverter;
import com.example.bookMyShow.demo.Model.UserEntity;
import com.example.bookMyShow.demo.Repository.UserRepository;
import com.example.bookMyShow.demo.Service.UserService;
import com.example.bookMyShow.demo.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserDto userDto) {
        // create a method that converts userdto to userentity

            // i need to have userentity object
        UserEntity userEntity= UserConverter.convertDtoToEntity(userDto);

        userRepository.save(userEntity);
    }

    @Override
    public UserDto getUser(int id) {
        //to avoid writing optional<UserEntity>
        // we can use .get() function of jpa--> if null then throw exception, or return userentity
        UserEntity userEntity =
                 userRepository.findById(id).get();


        //.orElse() -->
//        UserEntity user  = new UserEntity();
//        UserEntity userEntity =
//                userRepository.findById(id).orElse(user);



         //Since i need to return an userDto
        // I have to convert the entity to Dto
        UserDto userDto = UserConverter.convertEntityToDto(userEntity);
        return userDto;
    }
}
