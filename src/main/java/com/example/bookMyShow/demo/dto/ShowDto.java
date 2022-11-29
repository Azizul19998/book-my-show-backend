package com.example.bookMyShow.demo.dto;

import lombok.*;
import org.springframework.dao.DataAccessException;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ShowDto {
    int id;

    LocalTime showTime;
    LocalDate showDate;

    MovieDto movieDto;

    TheatreDto theatreDto;



}
