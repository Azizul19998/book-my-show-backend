package com.example.bookMyShow.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString
@Table(name="users")
public class UserEntity {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;
    @Column(name="mobile", nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntities;
}
