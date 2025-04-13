package io.github.skshiydv.newsaggregator.article.model;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.article.type.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetArticle {
    private String title;
    private String content;
    private String author;
    private ArticleType articleType;
    private Set<String> likes;
    private List<Comment> comments;
}
