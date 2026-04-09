package com.thafonso.user_api.controller;

import com.thafonso.user_api.dto.UserDTO;
import com.thafonso.user_api.entities.User;
import com.thafonso.user_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(Pageable pageable) {
        List<UserDTO> userDTOS = userService.findAll();
        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        UserDTO newUser = userService.insertUser(userDTO);

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").

                buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).build(); // create the user and return the URI of the new user
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updetedUser = userService.fromDTO(userDTO);
        updetedUser.setId(id);
        userService.updateUser(updetedUser);
        return ResponseEntity.noContent().build();
    }

}
