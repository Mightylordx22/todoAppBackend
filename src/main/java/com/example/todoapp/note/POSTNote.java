package com.example.todoapp.note;

import lombok.Data;

import java.util.UUID;

@Data
public class POSTNote {
    private String id;
    private String email;
    private String message;
}
