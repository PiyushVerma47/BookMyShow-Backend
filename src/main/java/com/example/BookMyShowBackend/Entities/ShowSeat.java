package com.example.BookMyShowBackend.Entities;

import com.example.BookMyShowBackend.Eums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_seats")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private int price;

    private boolean isAvailable;

    private boolean foodAttached;

    private String seatNo; //These values will
    private SeatType seatType; //come from the Theater seats
    //based on mapping or seat structure


    @JoinColumn
    @ManyToOne
    private Show show;
}
