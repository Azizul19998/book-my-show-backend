package com.example.bookMyShow.demo.Service.impl;

import com.example.bookMyShow.demo.Converter.MovieConverter;
import com.example.bookMyShow.demo.Model.MovieEntity;
import com.example.bookMyShow.demo.Repository.MovieRepository;
import com.example.bookMyShow.demo.Service.MovieService;
import com.example.bookMyShow.demo.dto.EntryDto.MovieEntryDto;
//import com.example.bookMyShow.demo.dto.MovieDto;
import com.example.bookMyShow.demo.dto.ResponseDto.MovieResponseDto;
import com.example.bookMyShow.demo.exception.DuplicateEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

//for logs
@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        //if the movie is already created then we can throw an exception..... movie already exist
//            if(movieRepository.getMovieEntityByName(movieEntryDto.getName())) {
//                throw new DuplicateEntityException("The movie already exists");
//            }



//        if(movieDto.getId()<0) {
//            throw  new EntityNotFoundException("Movie cantbe found");
//
//        }

        log.info("Adding the movie", movieEntryDto);

        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);
        movieEntity = movieRepository.save(movieEntity);

        MovieResponseDto movieResponseDto = MovieConverter
                .convertEntityToDto(movieEntity);

        return movieResponseDto;
    }


    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movieEntity =
                movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }
}
