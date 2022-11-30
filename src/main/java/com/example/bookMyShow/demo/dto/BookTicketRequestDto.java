package com.example.bookMyShow.demo.dto;

import com.example.bookMyShow.demo.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {

    Set<String> requestedSeats;

    int id;

    int showId;

    SeatType seatType;
}
