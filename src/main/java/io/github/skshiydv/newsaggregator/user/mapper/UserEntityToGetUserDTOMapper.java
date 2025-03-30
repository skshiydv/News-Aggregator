package io.github.skshiydv.newsaggregator.user.mapper;

import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;

import java.util.function.Function;

public class UserEntityToGetUserDTOMapper implements Function<UserEntity, GetUserDTO> {
    public static final UserEntityToGetUserDTOMapper INSTANCE = new UserEntityToGetUserDTOMapper();

    private UserEntityToGetUserDTOMapper() {
    }

    @Override
    public GetUserDTO apply(UserEntity userEntity) {
        GetUserDTO userDTO = new GetUserDTO();
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setPassword(userEntity.getPassword());

        return userDTO;
    }
}
