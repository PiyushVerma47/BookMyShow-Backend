package com.example.BookMyShowBackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String seatNosBooked;

    private Integer totalAmountPaid;

    @JoinColumn
    @ManyToOne
    private Show show;

    @JoinColumn
    @ManyToOne
    User user;
}
