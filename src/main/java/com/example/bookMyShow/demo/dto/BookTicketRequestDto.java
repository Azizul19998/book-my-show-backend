package com.example.bookMyShow.demo.dto;

import com.example.bookMyShow.demo.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {

    Set<String> requestedSeats; // User will give

    int id; // user id who is booking the ticket  :-UserEntity

    int showId; // For which show I want to book ticket :-showEntity

    SeatType seatType;// TheatreSeatEntity
}
