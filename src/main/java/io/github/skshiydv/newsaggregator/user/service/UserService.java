package io.github.skshiydv.newsaggregator.user.service;

import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.model.CreateUserDto;
import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    GetUserDTO getUserByUsername(String username);
    String createUser(CreateUserDto user);
    String deleteUser(String username);
    GetUserDTO editUser(CreateUserDto user);

}
