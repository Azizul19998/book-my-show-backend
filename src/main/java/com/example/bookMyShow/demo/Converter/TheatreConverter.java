package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.TheatreEntity;
import com.example.bookMyShow.demo.dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TheatreResponseDto;
//import com.example.bookMyShow.demo.dto.TheatreDto;

public class TheatreConverter {

    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreDto) {

        return TheatreEntity.builder()
                .address(theatreDto.getAddress())
                .city(theatreDto.getCity())
                .name(theatreDto.getName()).build();

        //should i write theatreDto.showDto  ??? think
    }

    public static TheatreResponseDto convertEntityToDto(TheatreEntity theatreEntity) {
        return  TheatreResponseDto.builder()
                .id(theatreEntity.getId())
                .name(theatreEntity.getName())
                .city(theatreEntity.getCity())
                .address(theatreEntity.getAddress())
                .type(theatreEntity.getType())
                .build();
    }
}
