package com.example.BookMyShowBackend.Requests;

import lombok.Data;

@Data
public class AddTheatreSeatsRequest {
    private int noOfPremiumSeats;
    private int noOfClassicSeats;
    private int noOfSeatsInEachRow;
    private int theatreId;
}
