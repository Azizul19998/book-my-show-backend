package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.TicketEntity;
//import com.example.bookMyShow.demo.dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.demo.dto.TicketDto;

public class TicketConverter {
    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity) {
        return TicketResponseDto.builder()
                .id((int)ticketEntity.getId())
                .alloted_seats(ticketEntity.getAllotedSeats())
                .amount(ticketEntity.getAmount())
                .build();
    }
}
