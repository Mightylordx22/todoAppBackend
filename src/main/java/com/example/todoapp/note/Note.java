package com.example.todoapp.note;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Note {
    private String id;
    private String message;
}
