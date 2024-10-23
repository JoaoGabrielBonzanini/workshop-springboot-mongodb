package com.mongodb.MongoDB.resources;

import com.mongodb.MongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET) //@GetMapping também pode ser usado
    public ResponseEntity<List<User>> findAll(){
       User maria = new User("1", "Maria Brwon", "maria@gmail.com");
       User alex = new User("2", "Alex Green", "alex@gmail.com");
       List<User> list = new ArrayList<>();
       list.addAll(Arrays.asList(maria, alex));
       return ResponseEntity.ok().body(list);
    }
}
