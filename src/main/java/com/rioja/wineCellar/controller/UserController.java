package com.rioja.wineCellar.controller;

import com.rioja.wineCellar.model.User;
import com.rioja.wineCellar.service.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/v1")
public class UserController {
    @Autowired
    private UserService userService;
    //esto lo hago siempre, me lo cargo 
    
    @GetMapping("/user")
    public ResponseEntity<Iterable<UserController>> getUser(@RequestParam(required=false) String id) {
        //me va a devolver esto cada vez q llame a este método
        Iterable<UserController> response = userService.getUser(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/user/{id}/")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User response = userService.getUser(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/user/{id}/") //en internet no lo pones entre corchetes
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User newUser = userService.updatePedido(id, user);
        if (newUser == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Pagar> deleteUser @PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}