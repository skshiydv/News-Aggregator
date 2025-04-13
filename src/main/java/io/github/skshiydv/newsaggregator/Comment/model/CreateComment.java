package io.github.skshiydv.newsaggregator.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateComment {
    private String userId;
    private String content;
}
