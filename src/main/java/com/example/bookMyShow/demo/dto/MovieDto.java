package com.example.bookMyShow.demo.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class MovieDto {

    int id;

    String name;


    LocalDate releaseDate;

    List<ShowDto> movies;
}
