package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.TicketConverter;
import com.example.bookMyShow.demo.Model.ShowEntity;
import com.example.bookMyShow.demo.Model.ShowSeatsEntity;
import com.example.bookMyShow.demo.Model.TicketEntity;
import com.example.bookMyShow.demo.Model.UserEntity;
import com.example.bookMyShow.demo.Repository.ShowRepository;
import com.example.bookMyShow.demo.Repository.TicketRepository;
import com.example.bookMyShow.demo.Repository.UserRepository;
import com.example.bookMyShow.demo.Service.TicketService;
import com.example.bookMyShow.demo.dto.BookTicketRequestDto;
//import com.example.bookMyShow.demo.dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TicketResponseDto;
import com.example.bookMyShow.demo.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;


    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
         UserEntity userEntity  = userRepository.
                 findById(bookTicketRequestDto.getId()).get();

        ShowEntity showEntity = showRepository
                .findById(bookTicketRequestDto.getShowId()).get();

        Set<String> requestedSeats = bookTicketRequestDto
                .getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList =
                showEntity.getSeats();

        //Option 1 to get bookedSeats
        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
                .stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())
                && !seat.isBooked()
                && requestedSeats.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());

        // Option 2
//        List<ShowSeatsEntity> bookedSeats1 = new ArrayList<>();
//
//        for (ShowSeatsEntity seat : showSeatsEntityList) {
//            if(!seat.isBooked() && seat.getSeatType().equals(bookTicketRequestDto.getSeatType())
//            && requestedSeats.contains(seat.getSeatNumber() ) ) {
//                bookedSeats1.add(seat);
//            }
//        }

        if(bookedSeats.size() != requestedSeats.size()) {
            throw new Error("All seats are not available");
        }

   // Step 2
        TicketEntity ticketEntity = TicketEntity.builder()
                .user(userEntity)
                .show(showEntity)
                .seats(bookedSeats).build();
    //Step 3 -->
        double amount = 0;
    for(ShowSeatsEntity showSeatsEntity : bookedSeats) {
        showSeatsEntity.setBooked(true);
        showSeatsEntity.setBookedAt(new Date());
        showSeatsEntity.setTicket(ticketEntity);

        amount += showSeatsEntity.getRate();
    }

    ticketEntity.setBookedAt(new Date());
    ticketEntity.setAllotedSeats(String.valueOf(bookedSeats));
    ticketEntity.setAmount(amount);


    //connecting the Show and user..
        // Show.Entity.setTicket
        showEntity.getTickets().add(ticketEntity);

        //UserEntity.setTicket
        userEntity.getTicketEntities().add(ticketEntity);

    ticketEntity = ticketRepository.save(ticketEntity);

    return TicketConverter.convertEntityToDto(ticketEntity);

    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats)
    {
        String str= "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats) {
            str = str + showSeatsEntity.getSeatNumber()+" ";
        }
        return str;
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);

        return ticketResponseDto;
    }


}
