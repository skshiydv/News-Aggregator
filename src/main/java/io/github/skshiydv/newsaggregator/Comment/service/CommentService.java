package io.github.skshiydv.newsaggregator.Comment.service;

import io.github.skshiydv.newsaggregator.Comment.model.CreateComment;

public interface CommentService {
    public String saveComment(CreateComment comment, String id);
}

