package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.BookTicketRequestDto;

import com.example.bookMyShow.demo.dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.demo.dto.TicketDto;

public interface TicketService {
    //bookTicket
    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    //getTicket
    TicketResponseDto getTicket(int id);
}
