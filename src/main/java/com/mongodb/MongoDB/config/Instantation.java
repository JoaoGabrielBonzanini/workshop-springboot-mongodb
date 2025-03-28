package com.mongodb.MongoDB.config;

import com.mongodb.MongoDB.domain.Post;
import com.mongodb.MongoDB.domain.User;
import com.mongodb.MongoDB.dto.AuthorDTO;
import com.mongodb.MongoDB.dto.CommentDTO;
import com.mongodb.MongoDB.repositories.PostRepository;
import com.mongodb.MongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("24/03/2025"), "Partiu viagem!", "Estou indo viajar", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("25/03/2025"), "Um belo dia", "Dia de chuva!", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Faça uma boa viagem", sdf.parse("24/03/2025"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Divirta-se", sdf.parse("24/03/2025"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Sempre bom chuva", sdf.parse("25/03/2025"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
