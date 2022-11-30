package com.example.bookMyShow.demo.Repository;

import com.example.bookMyShow.demo.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Integer> {
}
