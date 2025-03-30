package io.github.skshiydv.newsaggregator.user.mapper;

import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.model.CreateUserDto;

import java.util.function.Function;

public class CreateUserDtoToUserEntityMapper implements Function<CreateUserDto, UserEntity> {
    public static final CreateUserDtoToUserEntityMapper INSTANCE = new CreateUserDtoToUserEntityMapper();
    private CreateUserDtoToUserEntityMapper() {}
    @Override
    public UserEntity apply(CreateUserDto createUserDto) {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUsername(createUserDto.getUsername());
        userEntity1.setPassword(createUserDto.getPassword());
        userEntity1.setEmail(createUserDto.getEmail());
        userEntity1.setFirstName(createUserDto.getFirstName());
        userEntity1.setLastName(createUserDto.getLastName());
        return userEntity1;
    }
}
