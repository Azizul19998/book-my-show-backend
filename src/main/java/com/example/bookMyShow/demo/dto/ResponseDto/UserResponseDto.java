package com.example.bookMyShow.demo.dto.ResponseDto;

import com.example.bookMyShow.demo.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {
    int id;
    String name;
    String mobile;

    //optional
    List<TicketDto> tickets;
}
