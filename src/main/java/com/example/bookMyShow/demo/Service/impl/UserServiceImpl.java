package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.UserConverter;
import com.example.bookMyShow.demo.Model.UserEntity;
import com.example.bookMyShow.demo.Repository.UserRepository;
import com.example.bookMyShow.demo.Service.UserService;
import com.example.bookMyShow.demo.dto.EntryDto.UserEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {
        // create a method that converts userdto to userentity

            // i need to have userentity object
        UserEntity userEntity= UserConverter.convertDtoToEntity(userEntryDto);

        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        //to avoid writing optional<UserEntity>
//        // we can use .get() function of jpa--> if null then throw exception, or return userentity
//        UserEntity user = new UserEntity(); // By default user
//        UserEntity userEntity =
//                 userRepository.findById(id).get();


        //.orElse() -->
        UserEntity user  = new UserEntity();
        UserEntity userEntity =
                userRepository.findById(id).orElse(user);



         //Since i need to return an userDto
        // I have to convert the entity to Dto
        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);
        return userResponseDto;
    }
}
