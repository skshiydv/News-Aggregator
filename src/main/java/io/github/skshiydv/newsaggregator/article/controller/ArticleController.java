package io.github.skshiydv.newsaggregator.article.controller;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;
import io.github.skshiydv.newsaggregator.article.model.GetArticle;
import io.github.skshiydv.newsaggregator.article.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/create")
    public ResponseEntity<ArticleEntity> create(@RequestBody CreateArticle articleEntity) {
        ArticleEntity article = articleService.addArticle(articleEntity);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }
}
