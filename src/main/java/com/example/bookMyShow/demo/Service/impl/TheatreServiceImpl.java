package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.TheatreConverter;
import com.example.bookMyShow.demo.Model.TheatreEntity;
import com.example.bookMyShow.demo.Model.TheatreSeatEntity;
import com.example.bookMyShow.demo.Repository.TheatreRepository;
import com.example.bookMyShow.demo.Repository.TheatreSeatRepository;
import com.example.bookMyShow.demo.Service.TheatreService;
import com.example.bookMyShow.demo.dto.EntryDto.TheatreEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.TheatreResponseDto;
//import com.example.bookMyShow.demo.dto.TheatreDto;
import com.example.bookMyShow.demo.enums.SeatType;
import com.example.bookMyShow.demo.enums.TheatreType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto) {
        //create a theatre entity
        TheatreEntity theatreEntity= TheatreConverter.convertDtoToEntity(theatreEntryDto);

        //create the seats
         List<TheatreSeatEntity> seats=
                createTheatreSeats();

         theatreEntity.setSeats(seats);

         theatreEntity.setShows(null);
         //I need to set the theatreId for all these seats

        for(TheatreSeatEntity theatreSeatEntity:seats) {
            theatreSeatEntity.setTheatre(theatreEntity);
        }
        theatreEntity.setType(TheatreType.SINGLE);

        log.info("the theatre entity is: ", theatreEntity);

        theatreEntity = theatreRepository.save(theatreEntity);

        TheatreResponseDto theatreResponseDto = TheatreConverter
                .convertEntityToDto(theatreEntity);

        return theatreResponseDto;

    }

     List<TheatreSeatEntity> createTheatreSeats() {
        List<TheatreSeatEntity> seats = new ArrayList<>();
        seats.add(getTheatreSeat("1A",100, SeatType.CLASSIC));
        seats.add(getTheatreSeat("1B",100, SeatType.CLASSIC));
        seats.add(getTheatreSeat("1C",100, SeatType.CLASSIC));
        seats.add(getTheatreSeat("1D",100, SeatType.CLASSIC));
        seats.add(getTheatreSeat("1E",100, SeatType.CLASSIC));// add in this TheatreSeatsEntity type


        seats.add(getTheatreSeat("2A",200, SeatType.PREMIUM));
        seats.add(getTheatreSeat("2B",200, SeatType.PREMIUM));
        seats.add(getTheatreSeat("2C",200, SeatType.PREMIUM));
        seats.add(getTheatreSeat("2D",200, SeatType.PREMIUM));
        seats.add(getTheatreSeat("2E",200, SeatType.PREMIUM));

        theatreSeatRepository.saveAll(seats);
        return seats;
    }

     TheatreSeatEntity getTheatreSeat(String seatName, int rate, SeatType seatType )
     {
          return  TheatreSeatEntity.builder()
                  .seatNumber(seatName)
                  .rate(rate)
                  .seatType(seatType).build();

     }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        TheatreEntity theatreEntity = theatreRepository.findById(id).get();

        TheatreResponseDto theatreResponseDto = TheatreConverter.convertEntityToDto(theatreEntity);
        return theatreResponseDto;
    }

    @Override
    public TheatreEntity getTheatreEntity(int id) {
        return theatreRepository.findById(id).get();
    }
}
