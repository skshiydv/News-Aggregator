package io.github.skshiydv.newsaggregator.Comment.mapper;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.Comment.model.CreateComment;

import java.util.function.Function;

public class CreateCommentToCommentEntity implements Function<CreateComment, Comment> {
    public static final CreateCommentToCommentEntity INSTANCE = new CreateCommentToCommentEntity();

    private CreateCommentToCommentEntity() {
    }

    @Override
    public Comment apply(CreateComment createComment) {
        Comment comment = new Comment();
        comment.setContent(createComment.getContent());
        comment.setUserId(createComment.getUserId());
        return comment;
    }
}
