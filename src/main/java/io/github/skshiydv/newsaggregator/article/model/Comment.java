package io.github.skshiydv.newsaggregator.article.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String userId;
    private String content;
    private LocalDateTime timestamp;
}
