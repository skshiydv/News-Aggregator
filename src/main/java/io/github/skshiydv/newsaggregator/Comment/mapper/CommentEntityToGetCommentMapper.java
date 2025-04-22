package io.github.skshiydv.newsaggregator.Comment.mapper;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.Comment.model.GetComment;

import java.util.function.Function;

public class CommentEntityToGetCommentMapper implements Function<Comment, GetComment> {
    public static final CommentEntityToGetCommentMapper INSTANCE = new CommentEntityToGetCommentMapper();

    private CommentEntityToGetCommentMapper() {
    }

    @Override
    public GetComment apply(Comment comment) {
        GetComment getComment = new GetComment();
        getComment.setContent(comment.getContent());
        return getComment;
    }
}
