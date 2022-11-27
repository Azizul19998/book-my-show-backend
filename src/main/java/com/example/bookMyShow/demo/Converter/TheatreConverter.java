package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.TheatreEntity;
import com.example.bookMyShow.demo.dto.TheatreDto;

public class TheatreConverter {

    public static TheatreEntity convertDtoToEntity(TheatreDto theatreDto) {

        return TheatreEntity.builder()
                .id(theatreDto.getId())
                .address(theatreDto.getAddress())
                .city(theatreDto.getCity())
                .name(theatreDto.getName()).build();

        //should i write theatreDto.showDto  ??? think
    }

    public static TheatreDto convertEntityToDto(TheatreEntity theatreEntity) {
        return  TheatreDto.builder()
                .id(theatreEntity.getId())
                .name(theatreEntity.getName())
                .city(theatreEntity.getCity())
                .address(theatreEntity.getAddress()).build();
    }
}
