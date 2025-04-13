package io.github.skshiydv.newsaggregator.Comment.repository;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
