package io.github.skshiydv.newsaggregator.article.mapper;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;
import java.util.function.Function;


public class CreateArticleToArticle implements Function<CreateArticle, ArticleEntity> {
   public static final CreateArticleToArticle INSTANCE = new CreateArticleToArticle();
   private CreateArticleToArticle() {}
    @Override
    public ArticleEntity apply(CreateArticle createArticle) {
       ArticleEntity articleEntity = new ArticleEntity();
       articleEntity.setTitle(createArticle.getTitle());
       articleEntity.setContent(createArticle.getContent());
        return articleEntity;

    }
}
