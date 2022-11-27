package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.BookTicketRequestDto;
import com.example.bookMyShow.demo.dto.TicketDto;

public interface TicketService {
    //bookTicket
    TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    //getTicket
    TicketDto  getTicket(int id);
}
