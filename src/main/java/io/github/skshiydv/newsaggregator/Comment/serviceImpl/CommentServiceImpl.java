package io.github.skshiydv.newsaggregator.Comment.serviceImpl;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.Comment.mapper.CreateCommentToCommentEntity;
import io.github.skshiydv.newsaggregator.Comment.model.CreateComment;
import io.github.skshiydv.newsaggregator.Comment.repository.CommentRepository;
import io.github.skshiydv.newsaggregator.Comment.service.CommentService;
import io.github.skshiydv.newsaggregator.article.service.ArticleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ArticleService articleService;

    public CommentServiceImpl(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }

    @Override
    public String saveComment(CreateComment comment, String id) {
        Comment commentEntity = CreateCommentToCommentEntity.INSTANCE.apply(comment);
        commentEntity.setTimestamp(LocalDateTime.now());
        commentRepository.save(commentEntity);
        return articleService.saveComment(commentEntity, id);
    }
}
