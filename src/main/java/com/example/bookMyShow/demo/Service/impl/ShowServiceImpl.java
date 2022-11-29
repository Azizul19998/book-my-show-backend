package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.ShowConverter;
import com.example.bookMyShow.demo.Model.MovieEntity;
import com.example.bookMyShow.demo.Model.ShowEntity;
import com.example.bookMyShow.demo.Model.TheatreEntity;
import com.example.bookMyShow.demo.Repository.MovieRepository;
import com.example.bookMyShow.demo.Repository.TheatreRepository;
import com.example.bookMyShow.demo.Repository.TheatreSeatRepository;
import com.example.bookMyShow.demo.Service.ShowService;
import com.example.bookMyShow.demo.dto.ShowDto;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;

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

        //generateShowEntitySeats()

        return showDto;
    }
}
