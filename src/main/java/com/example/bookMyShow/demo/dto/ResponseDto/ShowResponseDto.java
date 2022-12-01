package com.example.bookMyShow.demo.dto.ResponseDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDto {

    int id;

    LocalDate showDate;

    LocalTime showTime;


    MovieResponseDto movieResponseDto;


    TheatreResponseDto theatreResponseDto;
}
