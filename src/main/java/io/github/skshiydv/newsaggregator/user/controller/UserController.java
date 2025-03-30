package io.github.skshiydv.newsaggregator.user.controller;

import io.github.skshiydv.newsaggregator.user.model.CreateUserDto;
import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;
import io.github.skshiydv.newsaggregator.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("health-check")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("get-user/{username}")
    public ResponseEntity<GetUserDTO> getUser(@PathVariable String username) {
        GetUserDTO user = userService.getUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("create-user")
    public ResponseEntity<String> addUser(@RequestBody CreateUserDto user) {
        String res = userService.createUser(user);
        if (res.equals("user created")) return new ResponseEntity<>("User created", HttpStatus.CREATED);
        else return new ResponseEntity<>("Error creating user", HttpStatus.CONFLICT);
    }

    @DeleteMapping("delete-user/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PutMapping("update-user")
    public ResponseEntity<GetUserDTO> updateUser(@RequestBody CreateUserDto userDTO) {
        GetUserDTO user = userService.editUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
