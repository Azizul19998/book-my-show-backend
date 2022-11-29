package com.example.bookMyShow.demo.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    int id;

    @NotNull
    String name;

    String mobileNo;

    List<TicketDto> ticketDtoList;


}
