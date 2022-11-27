package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.MovieEntity;
import com.example.bookMyShow.demo.dto.MovieDto;

public class MovieConverter {
    public static MovieEntity convertDtoToEntity(MovieDto movieDto) {
        return MovieEntity.builder()
                .id(movieDto.getId())
                .name(movieDto.getName())
                .releaseDate(movieDto.getReleaseDate())
                .build();

    }

    public static MovieDto convertEntityToDto(MovieEntity movieEntity) {
        return MovieDto.builder()
                .id(movieEntity.getId())
                .releaseDate(movieEntity.getReleaseDate())
                .name(movieEntity.getName()).build();
    }
}
