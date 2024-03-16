package com.example.BookMyShowBackend.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewTicketResponse {
    private int ticketId;
    private String seatNosBooked;
    private int totalAmountPaid;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theatreName;
}
