package io.github.skshiydv.newsaggregator.auth.service;

import io.github.skshiydv.newsaggregator.auth.model.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
