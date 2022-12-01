package com.example.bookMyShow.demo.Controller;

import com.example.bookMyShow.demo.Service.impl.MovieServiceImpl;
import com.example.bookMyShow.demo.dto.EntryDto.MovieEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.MovieResponseDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@Slf4j
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody() MovieEntryDto movieEntryDto) {

        return new ResponseEntity<>(movieService.addMovie(movieEntryDto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public MovieResponseDto getMovie(@PathVariable Integer id) {
        return movieService.getMovie(id);
    }
}
