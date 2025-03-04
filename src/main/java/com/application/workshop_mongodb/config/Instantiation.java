package com.application.workshop_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.application.workshop_mongodb.domain.Post;
import com.application.workshop_mongodb.domain.User;
import com.application.workshop_mongodb.dto.AuthorDto;
import com.application.workshop_mongodb.dto.CommentDto;
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
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/03/2025"), "Partiu viagem", "Vou viajar para Sao Paulo.",
                new AuthorDto(maria));
        Post p2 = new Post(null, sdf.parse("23/03/2025"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2025"), new AuthorDto(alex));
        CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2025"), new AuthorDto(bob));
        CommentDto c3 = new CommentDto("Tenha um otimo dia!", sdf.parse("23/03/2025"), new AuthorDto(alex));
        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        PostRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);
    }
}
