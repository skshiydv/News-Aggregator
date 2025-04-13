package io.github.skshiydv.newsaggregator.article.repository;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<ArticleEntity, String> {
}
