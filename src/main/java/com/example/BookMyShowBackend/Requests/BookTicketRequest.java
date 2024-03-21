package com.example.BookMyShowBackend.Requests;

import com.example.BookMyShowBackend.Eums.SeatAvailability;
import com.example.BookMyShowBackend.Eums.SeatType;
import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequest {
    private int showId;
    private List<String> seatList;
    private String userEmailId;
    private String seatAvailability;

}
