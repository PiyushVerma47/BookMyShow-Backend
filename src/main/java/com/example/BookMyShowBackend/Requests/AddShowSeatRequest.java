package com.example.BookMyShowBackend.Requests;

import lombok.Data;

@Data
public class AddShowSeatRequest {
    private int priceForPremiumSeats;
    private int priceForClassicSeats;
    private int showId;
}
