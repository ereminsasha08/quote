package com.kameleoon.quote.controller;

import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.service.user.UserService;
import com.kameleoon.quote.to.user.UserTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(UserController.API_URL)
@RequiredArgsConstructor
public class UserController {
    public final static String API_URL = "api/users";

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody UserTo userTo) {
        User created = userService.save(userTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_URL + "/" + created.id()).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
