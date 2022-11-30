package com.example.bookMyShow.demo.Repository;

import com.example.bookMyShow.demo.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
}
