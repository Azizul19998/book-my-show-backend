package com.example.bookMyShow.demo.Controller;

import com.example.bookMyShow.demo.Service.impl.TicketServiceImpl;
import com.example.bookMyShow.demo.dto.BookTicketRequestDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TicketResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody()BookTicketRequestDto bookTicketRequestDto)
    {
        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("/get/{id}")
    public TicketResponseDto getTicketById(@PathVariable Integer id) {
        return ticketService.getTicket(id);
    }
}
