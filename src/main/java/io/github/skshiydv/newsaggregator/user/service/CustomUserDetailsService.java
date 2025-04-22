package io.github.skshiydv.newsaggregator.user.service;

import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        Set<GrantedAuthority> grantedAuthorities = userEntity.getRoles().stream().map((role)->new SimpleGrantedAuthority("ROLE_USER")).collect(Collectors.toSet());
        return new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
    }
}
