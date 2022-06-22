package com.example.todoapp;

import com.example.todoapp.note.Note;
import com.example.todoapp.user.User;
import com.example.todoapp.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserRepository userRepository) {
//        return args -> {
//            Note note = new Note("Message1");
//            Note note2 = new Note("Message2");
//            Note note3 = new Note("Message3");
//
//            List<Note> notes = List.of(note, note2, note3);
//
//            User user = new User("adam@mightylordx.uk", notes);
//          userRepository.insert(user);
//        };
//    }

}
