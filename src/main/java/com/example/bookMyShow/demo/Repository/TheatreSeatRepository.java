package com.example.bookMyShow.demo.Repository;

import com.example.bookMyShow.demo.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {

}
