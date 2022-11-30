package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.ShowEntity;
import com.example.bookMyShow.demo.dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.ShowResponseDto;
//import com.example.bookMyShow.demo.dto.ShowEntryDto;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto) {
        return ShowEntity.builder()
                .showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .build(); // it is partially converted to showentit; this entity does not conatin all the ttribute
    }
    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto) {
        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .build();
    }
}
