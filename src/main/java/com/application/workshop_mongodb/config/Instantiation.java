package com.application.workshop_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.application.workshop_mongodb.domain.Post;
import com.application.workshop_mongodb.domain.User;
import com.application.workshop_mongodb.repository.PostRepository;
import com.application.workshop_mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository PostRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        PostRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post p1 = new Post(null, sdf.parse("21/03/2025"), "Partiu viagem", "Vou viajar para Sao Paulo.", maria);
        Post p2 = new Post(null, sdf.parse("23/03/2025"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        PostRepository.saveAll(Arrays.asList(p1, p2));
    }
}
