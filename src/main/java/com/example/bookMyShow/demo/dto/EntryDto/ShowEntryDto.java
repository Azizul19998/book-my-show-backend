package com.example.bookMyShow.demo.dto.EntryDto;

import com.example.bookMyShow.demo.dto.ResponseDto.MovieResponseDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntryDto {
    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

  @NotNull
    MovieResponseDto movieResponseDto;

  @NotNull
    TheatreResponseDto theatreResponseDto;
}
