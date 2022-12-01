package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.Model.TheatreEntity;
import com.example.bookMyShow.demo.dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TheatreResponseDto;
//import com.example.bookMyShow.demo.dto.TheatreDto;

public interface TheatreService {
    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);

    TheatreResponseDto getTheatre(int id);


    TheatreEntity getTheatreEntity(int id);
}
