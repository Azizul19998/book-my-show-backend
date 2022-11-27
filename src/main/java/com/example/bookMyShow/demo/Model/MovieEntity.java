package com.example.bookMyShow.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="movies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="release_date", columnDefinition = "DATE", nullable = false)
    private LocalDate releaseDate;

    //Connecting the other table
    //Since this is the parent ( how did we come to know:?
    // Its having mappedBy and cascade
    //to know child table: it will have @JoinColumn annotation
    @OneToMany(mappedBy = "movie", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;
}
