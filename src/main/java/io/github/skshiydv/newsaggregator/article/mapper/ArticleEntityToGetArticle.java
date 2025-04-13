package io.github.skshiydv.newsaggregator.article.mapper;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.model.GetArticle;

import java.util.function.Function;

public class ArticleEntityToGetArticle implements Function<ArticleEntity, GetArticle> {
    public static final ArticleEntityToGetArticle INSTANCE = new ArticleEntityToGetArticle();
    private ArticleEntityToGetArticle() {}
    @Override
    public GetArticle apply(ArticleEntity articleEntity) {
        GetArticle getArticle = new GetArticle();
        getArticle.setTitle(articleEntity.getTitle());
        getArticle.setContent(articleEntity.getContent());
        getArticle.setAuthor(articleEntity.getAuthor().getUsername());
        getArticle.setComments(articleEntity.getComments());
        getArticle.setLikes(articleEntity.getLikes());
        getArticle.setArticleType(articleEntity.getType());
        return getArticle;
    }


}
