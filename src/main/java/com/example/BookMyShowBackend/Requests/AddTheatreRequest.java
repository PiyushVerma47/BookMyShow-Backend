package com.example.BookMyShowBackend.Requests;

import lombok.Data;

@Data
public class AddTheatreRequest {

    private String name;
    private String address;
    private int noOfScreens;
}
