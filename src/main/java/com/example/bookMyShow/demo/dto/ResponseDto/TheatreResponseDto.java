package com.example.bookMyShow.demo.dto.ResponseDto;

import com.example.bookMyShow.demo.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {
    int id;
    String name;
    String address;
    String city;
    TheatreType type;

    //show entity
}
