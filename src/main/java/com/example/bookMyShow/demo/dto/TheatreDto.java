package com.example.bookMyShow.demo.dto;

import lombok.*;

import java.util.List;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@ToString
public class TheatreDto {

    int id;

    String name;

    String address;

    String city;

    //seats required??

    //showEntity reuired?? yes
    ShowDto showDto;
}
