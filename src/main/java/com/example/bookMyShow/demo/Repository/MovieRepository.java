package com.example.bookMyShow.demo.Repository;

import com.example.bookMyShow.demo.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    //boolean getMovieEntityByName(String name);

}
