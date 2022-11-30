package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.ShowConverter;
import com.example.bookMyShow.demo.Model.*;
import com.example.bookMyShow.demo.Repository.MovieRepository;
import com.example.bookMyShow.demo.Repository.ShowRepository;
import com.example.bookMyShow.demo.Repository.ShowSeatsRepository;
import com.example.bookMyShow.demo.Repository.TheatreRepository;
import com.example.bookMyShow.demo.Service.ShowService;
import com.example.bookMyShow.demo.dto.ShowDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;
    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {
        //we have made the partial Show Entity Object
        // The goal is , we have to set the movie entity and theatre entity in this.. not the dto's
        ShowEntity showEntity = ShowConverter.convertDtoToEntity((showDto));

        // add MovieEntity to showEntity object
        MovieEntity movieEntity = movieRepository.findById(showDto.getMovieDto().getId()).get();


        TheatreEntity theatreEntity =  theatreRepository
                .findById(showDto.getTheatreDto().getId()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        // we need to pass the list of the theatre seata
        generateShowEntitySeats(theatreEntity.getSeats(), showEntity);

        showEntity = showRepository.save(showEntity);

        return showDto;
    }

    private void generateShowEntitySeats(List<TheatreSeatEntity> theatreSeatEntityList, ShowEntity showEntity) {
        List<ShowSeatsEntity> showSeatsEntityList =
                new ArrayList<>();

        //for all the seats in the theatre
        // i have to add it in show entity
        for(TheatreSeatEntity tse: theatreSeatEntityList) {
            // i need to  create showseatsenttty, basically save it
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder()
                    .seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();
            showSeatsEntityList.add(showSeatsEntity);
        }

        // i need to set the show Entity for each of the ShowSeat.....
        for(ShowSeatsEntity showSeatsEntity: showSeatsEntityList) {
            showSeatsEntity.setShow(showEntity);
        }

        showSeatsRepository.saveAll(showSeatsEntityList);










    }
}
