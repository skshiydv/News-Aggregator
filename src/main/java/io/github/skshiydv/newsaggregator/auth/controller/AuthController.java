package io.github.skshiydv.newsaggregator.auth.controller;

import io.github.skshiydv.newsaggregator.auth.model.AuthResponse;
import io.github.skshiydv.newsaggregator.auth.model.LoginDto;
import io.github.skshiydv.newsaggregator.auth.service.AuthService;
import io.github.skshiydv.newsaggregator.user.model.CreateUserDto;
import io.github.skshiydv.newsaggregator.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }
    @GetMapping("check")
    public String check(){
        return "OK";
    }


    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
    }
    @PostMapping("create-user")
    public ResponseEntity<String> addUser(@RequestBody CreateUserDto user) {
        String res = userService.createUser(user);
        if (res.equals("user created")) return new ResponseEntity<>("User created", HttpStatus.CREATED);
        else return new ResponseEntity<>("Error creating user", HttpStatus.CONFLICT);
    }
}
