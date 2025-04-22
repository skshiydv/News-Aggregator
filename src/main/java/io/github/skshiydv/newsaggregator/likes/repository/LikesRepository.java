package io.github.skshiydv.newsaggregator.likes.repository;

import io.github.skshiydv.newsaggregator.likes.entity.LikesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikesRepository extends MongoRepository<LikesEntity, String> {
}
