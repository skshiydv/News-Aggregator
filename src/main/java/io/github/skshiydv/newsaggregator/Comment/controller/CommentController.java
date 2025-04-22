package io.github.skshiydv.newsaggregator.Comment.controller;

import io.github.skshiydv.newsaggregator.Comment.model.CreateComment;
import io.github.skshiydv.newsaggregator.Comment.model.GetComment;
import io.github.skshiydv.newsaggregator.Comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all-comments/{id}")
    public ResponseEntity<List<GetComment>> getAllComments(@PathVariable String id) {
        List<GetComment> articles = commentService.getComment(id);
        if (articles == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
}
