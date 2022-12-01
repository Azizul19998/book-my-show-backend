package com.example.bookMyShow.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter @Table(name = "shows")
@NoArgsConstructor @AllArgsConstructor
@Builder
@EntityListeners(value = { AuditingEntityListener.class })
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date", columnDefinition = "DATE", nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time", columnDefinition = "TIME", nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedBy
    @Column(name = "updated_at")
    private Date updatedAt;



    //Must required in DTO
    @ManyToOne
    @JsonIgnore
    private MovieEntity movie;

    //Must reuired ?why
    @ManyToOne
    @JsonIgnore
    private TheatreEntity theatre;



    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;

}
