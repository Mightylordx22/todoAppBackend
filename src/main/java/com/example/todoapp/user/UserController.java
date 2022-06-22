package com.example.todoapp.user;


import com.example.todoapp.note.Note;
import com.example.todoapp.note.POSTNote;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/notes")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping(path="/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public Optional<User> getUserData(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @PostMapping(path="/createuser")
    public void createUser(@RequestBody User user) { userService.createUser(user); }

    @PostMapping
    public User createNote(@RequestBody POSTNote note) {
        userService.createNote(note);
        return userService.getUser(note.getEmail());
    };

    @DeleteMapping
    public User deleteNote(@RequestBody POSTNote note) {
        userService.deleteNote(note);
        return userService.getUser(note.getEmail());
    };

    @PutMapping
    public User editNote(@RequestBody POSTNote note) {
        userService.updateNote(note);
        return userService.getUser(note.getEmail());
    }
}
