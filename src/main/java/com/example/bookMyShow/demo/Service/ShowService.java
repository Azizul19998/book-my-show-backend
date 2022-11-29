package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.ShowDto;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowService {
    ShowDto addShow(ShowDto showDto);
}
