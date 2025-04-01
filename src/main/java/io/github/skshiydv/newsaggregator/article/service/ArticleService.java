package io.github.skshiydv.newsaggregator.article.service;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;

public interface ArticleService {
    ArticleEntity addArticle(CreateArticle article);
}
