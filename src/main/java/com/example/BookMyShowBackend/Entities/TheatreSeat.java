package com.example.BookMyShowBackend.Entities;

import com.example.BookMyShowBackend.Eums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    private String seatNo;

    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;
}
