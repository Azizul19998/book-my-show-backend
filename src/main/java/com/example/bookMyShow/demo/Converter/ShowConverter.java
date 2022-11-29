package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.ShowEntity;
import com.example.bookMyShow.demo.dto.ShowDto;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowDto showDto) {
        return ShowEntity.builder()
                .showDate(showDto.getShowDate())
                .showTime(showDto.getShowTime())
                .build(); // it is partially converted to showentit; this entity does not conatin all the ttribute
    }
}
