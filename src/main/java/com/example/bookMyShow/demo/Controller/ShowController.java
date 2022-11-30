package com.example.bookMyShow.demo.Controller;

import com.example.bookMyShow.demo.Service.impl.ShowServiceImpl;
import com.example.bookMyShow.demo.dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("add")
    public ResponseEntity<ShowResponseDto> addShow(@RequestBody ShowEntryDto showEntryDto) {

        return new ResponseEntity<>(showService.addShow(showEntryDto), HttpStatus.CREATED);
    }
}
