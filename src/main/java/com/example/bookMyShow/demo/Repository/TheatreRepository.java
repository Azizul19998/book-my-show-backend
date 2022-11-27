package com.example.bookMyShow.demo.Repository;

import com.example.bookMyShow.demo.Model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {
}
