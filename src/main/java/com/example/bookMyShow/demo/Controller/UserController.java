package com.example.bookMyShow.demo.Controller;

import com.example.bookMyShow.demo.Service.impl.UserServiceImpl;
import com.example.bookMyShow.demo.dto.EntryDto.UserEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.UserResponseDto;
import com.example.bookMyShow.demo.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto) {
        userService.addUser(userEntryDto);
        return new ResponseEntity("Add User Successful", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value="id") int id) {

        UserResponseDto userResponseDto = userService.getUser(id);
        return  new ResponseEntity<>(userResponseDto,HttpStatus.OK);

    }

}
