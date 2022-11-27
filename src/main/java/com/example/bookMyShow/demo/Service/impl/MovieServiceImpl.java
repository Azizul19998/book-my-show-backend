package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.MovieConverter;
import com.example.bookMyShow.demo.Model.MovieEntity;
import com.example.bookMyShow.demo.Repository.MovieRepository;
import com.example.bookMyShow.demo.Service.MovieService;
import com.example.bookMyShow.demo.dto.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

//for logs
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieDto addMovie(MovieDto movieDto) {

        //if the movie is already created then we can throw an exception..... movie already exist



//        if(movieDto.getId()<0) {
//            throw  new EntityNotFoundException("Movie cantbe found");
//
//        }

        log.info("Adding the movie", movieDto);

        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieDto);
        movieEntity = movieRepository.save(movieEntity);

        return movieDto;
    }




    @Override
    public MovieDto getMovie(int id) {
        MovieEntity movieEntity =
                movieRepository.findById(id).get();
        MovieDto movieDto=MovieConverter.convertEntityToDto(movieEntity);
        return movieDto;
    }
}
