package com.example.bookMyShow.demo.Converter;

import com.example.bookMyShow.demo.Model.TicketEntity;
import com.example.bookMyShow.demo.dto.TicketDto;

public class TicketConverter {
    public static TicketDto convertEntityToDto(TicketEntity ticketEntity) {
        return TicketDto.builder()
                .id(ticketEntity.getId())
                .alloted_seats(ticketEntity.getAllotedSeats())
                .amount(ticketEntity.getAmount())
                .build();
    }
}
