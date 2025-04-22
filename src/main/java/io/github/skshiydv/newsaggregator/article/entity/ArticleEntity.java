package io.github.skshiydv.newsaggregator.article.entity;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.article.type.ArticleType;
import io.github.skshiydv.newsaggregator.likes.entity.LikesEntity;
import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    @Indexed
    private ArticleType type;
    @DBRef
    private List<LikesEntity> likes = new ArrayList<>();
    @DBRef
    private List<Comment> comments = new ArrayList<>();
}

