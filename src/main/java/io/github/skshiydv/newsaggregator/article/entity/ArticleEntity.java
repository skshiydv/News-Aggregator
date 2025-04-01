package io.github.skshiydv.newsaggregator.article.entity;

import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "article")
public class ArticleEntity {
    @Id
    private String id;
    private String title;
    private UserEntity author;
    private String content;
    private Set<UserEntity> likes;
    private List<Comment> comments;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Comment {
    private String userId;
    private String content;
    private LocalDateTime timestamp;
}