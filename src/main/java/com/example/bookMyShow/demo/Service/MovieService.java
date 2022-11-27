package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.MovieDto;

public interface MovieService {
    //addMovie
    MovieDto addMovie(MovieDto movieDto);

    //getMovie
    MovieDto getMovie(int id);
}
