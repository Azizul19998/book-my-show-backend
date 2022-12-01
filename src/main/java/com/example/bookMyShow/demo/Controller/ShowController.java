package com.example.bookMyShow.demo.Controller;

import com.example.bookMyShow.demo.Service.impl.ShowServiceImpl;
import com.example.bookMyShow.demo.dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.ShowResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
@Slf4j
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto) {

        log.info("here we are");
        return showService.addShow(showEntryDto);
    }
}
