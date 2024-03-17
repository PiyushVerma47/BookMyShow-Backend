package com.example.BookMyShowBackend.Requests;

import lombok.Data;

@Data
public class AddUserRequest {
    private String name;
    private String userEmailId;
}
