package io.github.skshiydv.newsaggregator.article.repository;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.type.ArticleType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<ArticleEntity, String> {
    List<ArticleEntity> findAllByType(ArticleType type);
}
