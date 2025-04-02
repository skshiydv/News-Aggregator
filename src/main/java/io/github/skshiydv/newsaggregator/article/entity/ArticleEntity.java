package io.github.skshiydv.newsaggregator.article.entity;

import io.github.skshiydv.newsaggregator.article.model.Comment;
import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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
    @DBRef
    private UserEntity author;
    private String content;
    private Set<String> likes = new HashSet<>();
    private List<Comment> comments = new ArrayList<>();
}

