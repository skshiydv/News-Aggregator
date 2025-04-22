package io.github.skshiydv.newsaggregator.Comment.service;

import io.github.skshiydv.newsaggregator.Comment.model.CreateComment;
import io.github.skshiydv.newsaggregator.Comment.model.GetComment;

import java.util.List;

public interface CommentService {
    public String saveComment(CreateComment comment, String id);

    List<GetComment> getComment(String id);
}

