package com.example.bookMyShow.demo.Service;

import com.example.bookMyShow.demo.dto.EntryDto.ShowEntryDto;
import com.example.bookMyShow.demo.dto.ResponseDto.ShowResponseDto;


public interface ShowService {
    ShowResponseDto addShow(ShowEntryDto showEntryDto);
}
