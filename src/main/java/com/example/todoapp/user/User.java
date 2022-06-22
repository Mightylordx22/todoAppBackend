package com.example.todoapp.user;

import com.example.todoapp.note.Note;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Data
@Document
public class User {
    @Id
    private String id;
    private String email;
    private List<Note> notes = Collections.emptyList();

    public void addNote(Note note){
        this.notes.add(note);
    }

    public void removeNote(String id) {
        this.notes.removeIf(x -> Objects.equals(x.getId(), id));
    }

    public void updateNote(String id, String message) {
        Note note = this.notes.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElse(null);
        assert note != null;
        note.setMessage(message);
    }

//    public User(String email, List<Note> notes) {
//        this.email = email;
//        this.notes = notes;
//    }

}
