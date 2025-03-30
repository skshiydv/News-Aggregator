package io.github.skshiydv.newsaggregator.user.serviceImpl;

import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.mapper.CreateUserDtoToUserEntityMapper;
import io.github.skshiydv.newsaggregator.user.mapper.UserEntityToGetUserDTOMapper;
import io.github.skshiydv.newsaggregator.user.model.CreateUserDto;
import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;
import io.github.skshiydv.newsaggregator.user.repository.UserRepository;
import io.github.skshiydv.newsaggregator.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUserDTO getUserByUsername(String username)  {
        UserEntity user = userRepository.findByUsername(username);
        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO = UserEntityToGetUserDTOMapper.INSTANCE.apply(user);
        return getUserDTO;
    }

    @Override
    public String createUser(CreateUserDto user) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity = CreateUserDtoToUserEntityMapper.INSTANCE.apply(user);
            if (userRepository.findByUsername(user.getUsername()) != null) {
                return "user already exists";
            } else {
                userRepository.save(userEntity);

            }

        } catch (Exception e) {
            return e.getMessage();
        }
        return "user created";
    }

    @Override
    public String deleteUser(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            return "user not found";
        }
        else {
            userRepository.delete(user);
            return "user deleted";
        }
    }

    @Override
    public GetUserDTO editUser(CreateUserDto userDto) {
        UserEntity user = userRepository.findByUsername(userDto.getUsername());
        UserEntity newUser = new UserEntity();
        newUser.setId(user.getId());
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        GetUserDTO updatedUser=UserEntityToGetUserDTOMapper.INSTANCE.apply(newUser);
        return updatedUser;
    }
}
