package com.example.bookMyShow.demo.Controller;

import com.example.bookMyShow.demo.Model.TheatreEntity;
import com.example.bookMyShow.demo.Service.impl.TheatreServiceImpl;
import com.example.bookMyShow.demo.dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TheatreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("add")
    public ResponseEntity<TheatreResponseDto> addTheatre(@RequestBody()TheatreEntryDto theatreEntryDto) {

        return new ResponseEntity<>(theatreService.addTheatre(theatreEntryDto), HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public TheatreEntity getTheatre(@PathVariable Integer id) {
        return theatreService.getTheatreEntity(id);
    }
}
