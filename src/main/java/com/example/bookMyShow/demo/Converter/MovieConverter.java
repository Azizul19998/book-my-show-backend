package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.MovieEntity;
import com.example.bookMyShow.demo.dto.EntryDto.MovieEntryDto;
//import com.example.bookMyShow.demo.dto.MovieDto;
import com.example.bookMyShow.demo.dto.ResponseDto.MovieResponseDto;

public class MovieConverter {
    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto) {

        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate())
                .build();

    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity) {
        return MovieResponseDto.builder()
                .id(movieEntity.getId())
                .releaseDate(movieEntity.getReleaseDate())
                .name(movieEntity.getName()).build();
    }
}
