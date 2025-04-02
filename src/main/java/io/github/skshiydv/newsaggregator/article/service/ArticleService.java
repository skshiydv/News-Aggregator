package io.github.skshiydv.newsaggregator.article.service;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;
import io.github.skshiydv.newsaggregator.article.model.GetArticle;

import java.util.List;

public interface ArticleService {
    String addArticle(CreateArticle article);
    GetArticle getArticle(String title);
    List<GetArticle> getArticlesByUsername(String username);

}
