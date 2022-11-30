package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.EntryDto.MovieEntryDto;
//import com.example.bookMyShow.demo.dto.MovieDto;
import com.example.bookMyShow.demo.dto.ResponseDto.MovieResponseDto;

public interface MovieService {
    //addMovie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    //getMovie
    MovieResponseDto getMovie(int id);

    //MovieNameAndIdObject getNameAndId(int id);
}
