package io.github.skshiydv.newsaggregator.Comment.repository;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.Comment.model.GetComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<GetComment> findByUserId(String id);
}
