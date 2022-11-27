package com.example.bookMyShow.demo.Model;

import com.example.bookMyShow.demo.enums.SeatType;
import com.example.bookMyShow.demo.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "theatres")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;


    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
   private List<ShowEntity> shows;

    TheatreType type;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheatreSeatEntity> seats= new ArrayList<>();
}
