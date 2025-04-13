package io.github.skshiydv.newsaggregator.Comment.controller;

import io.github.skshiydv.newsaggregator.Comment.model.CreateComment;
import io.github.skshiydv.newsaggregator.Comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    public final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add-comment/{id}")
    public ResponseEntity<String> addComment(@RequestBody CreateComment comment, @PathVariable String id) {
        String response = commentService.saveComment(comment, id);
        if (response.equals("Success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
