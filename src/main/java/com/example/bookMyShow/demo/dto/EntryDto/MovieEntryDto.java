package com.example.bookMyShow.demo.dto.EntryDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MovieEntryDto { // dto are made to avoid heavy api calling bcz they contain only required parameter
    String name;
    LocalDate releaseDate;

}
