package com.example.bookMyShow.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name="tickets")
public class TicketEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "alloted_seats", nullable = false)
    private String allotedSeats;

    @Column(name = "amount", nullable = false)
    private int amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at", nullable = false)
    private  Date bookedAt;

    @ManyToOne
    @JsonIgnore // you will only be passing id,seats,amount . Not the user details in the object, thats why jsonignore .
    @JoinColumn
    private UserEntity user;

    //showEntity
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;


    //List<ShowSeatEntity>
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;


}
