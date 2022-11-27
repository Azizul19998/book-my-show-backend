package com.example.bookMyShow.demo.dto;

import com.example.bookMyShow.demo.enums.SeatType;

import java.util.Set;

public class BookTicketRequestDto {

    Set<String> requestedSeats;

    int id;

    int showId;

    SeatType seatType;
}
