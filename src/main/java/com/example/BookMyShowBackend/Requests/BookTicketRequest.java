package com.example.BookMyShowBackend.Requests;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequest {
    public int showId;
    public List<String> seatList;
}
