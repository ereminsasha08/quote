package com.kameleoon.quote.controller;

import com.kameleoon.quote.domain.user.User;
import com.kameleoon.quote.service.user.UserService;
import com.kameleoon.quote.to.UserTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {
    public final static String API_URL = "api/users";

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody UserTo userTo) {
        log.info("register {}", userTo);
        User created = userService.save(userTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
