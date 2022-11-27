package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.TheatreDto;

public interface TheatreService {
    TheatreDto addTheatre(TheatreDto theatreDto);

    TheatreDto getTheatre(int id);
}
