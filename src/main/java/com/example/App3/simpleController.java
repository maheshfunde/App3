package com.example.App3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController
public class simpleController {

    dbUser db= new dbUser();

    @GetMapping("/hi") //simple hello api
    public String sayHi(){

        return("hello from our server");
    }
    @GetMapping("/users")  //api to get list of all users  http://localhost:8080/users

    public List<user> getAllUsers(){
    return db.getAllUsers();
    }

    @GetMapping("/users/{id}")  //api to get a single user(search a user in a list using path parameter)
    public ResponseEntity getAUser(@PathVariable int id){        //http://localhost:8080/users/{id}
        user user1 =db.getAUser(id);
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("server", Collections.singletonList("code of Mahesh"));
        HttpStatus status=HttpStatus.ACCEPTED;
        ResponseEntity<user> response= new ResponseEntity<>(user1,headers,status);
        return response;
    }
    @GetMapping("/user")  //api to get a single user(search a user in a list using query/request parameter)  http://localhost:8080/users/{id}
    public user getAUser(@RequestParam String q){      //http://localhost:8080/user?q=Mahesh
        return db.getAUserByName(q);
    }

    //POST APIs

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)  //changing header
    public user createUser(@RequestBody user user){  //user input will be in the form of json but spring will convert that json to user object
    return db.createUser(user);
    }

    //Delete API
    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable int id){
        return db.deleteUser(id);
    }

}
