package io.github.skshiydv.newsaggregator.user.serviceImpl;


import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.mapper.CreateUserDtoToUserEntityMapper;
import io.github.skshiydv.newsaggregator.user.mapper.UserEntityToGetUserDTOMapper;
import io.github.skshiydv.newsaggregator.user.model.CreateUserDto;
import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;
import io.github.skshiydv.newsaggregator.user.repository.UserRepository;
import io.github.skshiydv.newsaggregator.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public GetUserDTO getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserEntityToGetUserDTOMapper.INSTANCE.apply(user);
    }

    @Override
    public String createUser(CreateUserDto user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "User already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = CreateUserDtoToUserEntityMapper.INSTANCE.apply(user);
        userEntity.setRoles(List.of("ROLE_USER"));
        userRepository.save(userEntity);
        return "User created";
    }

    @Override
    public String deleteUser(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            return "User not found";
        }

        user.ifPresent(userRepository::delete);
        return "User deleted";
    }

    @Override
    public GetUserDTO editUser(CreateUserDto userDto) {
        UserEntity user = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        userRepository.save(user);


        return UserEntityToGetUserDTOMapper.INSTANCE.apply(user);
    }
}
