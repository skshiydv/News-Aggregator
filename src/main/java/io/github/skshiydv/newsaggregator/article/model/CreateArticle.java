package io.github.skshiydv.newsaggregator.article.model;

import io.github.skshiydv.newsaggregator.article.type.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateArticle {
    private String title;
    private String content;
    private ArticleType articleType;
}
