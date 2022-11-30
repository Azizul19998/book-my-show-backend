package com.example.bookMyShow.demo.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {
    int id;
    String name;
    LocalDate releaseDate;

    //optional
    List<ShowResponseDto> showDtoList;
}
