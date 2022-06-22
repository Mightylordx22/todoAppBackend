package com.example.todoapp.user;


import com.example.todoapp.note.Note;
import com.example.todoapp.note.POSTNote;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void createUser(User user) {
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("Email is use");
        }
        userRepository.save(user);
    }

    @Transactional
    public void createNote(POSTNote note) {
        User user = getUser(note.getEmail());
        Note newNote = new Note(UUID.randomUUID().toString(), note.getMessage());
        user.addNote(newNote);
        userRepository.save(user);

    }

    public void deleteNote(POSTNote note) {
        User user = getUser(note.getEmail());
        user.removeNote(note.getId());
        userRepository.save(user);
    }

    public void updateNote(POSTNote note) {
        User user = getUser(note.getEmail());
        user.updateNote(note.getId(), note.getMessage());
        userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new IllegalStateException("Email not found"));
    }
}
