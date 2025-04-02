package io.github.skshiydv.newsaggregator.article.controller;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;
import io.github.skshiydv.newsaggregator.article.model.GetArticle;
import io.github.skshiydv.newsaggregator.article.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateArticle articleEntity) {
        String res = articleService.addArticle(articleEntity);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @GetMapping("/get/{username}")
    public ResponseEntity<List<GetArticle>> getArticle(@PathVariable String username) {
        List<GetArticle> articles = articleService.getArticlesByUsername(username);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
}
