package com.example.bookMyShow.demo.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    int id;

    @NotNull
    String name;

    String mobileNo;
}
