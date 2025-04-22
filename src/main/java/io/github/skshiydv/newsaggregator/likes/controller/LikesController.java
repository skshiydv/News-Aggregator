package io.github.skshiydv.newsaggregator.likes.controller;

import io.github.skshiydv.newsaggregator.likes.services.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {
    private final LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<String> addLike(@PathVariable String id) {
        String res = likeService.addLike(id);
        if (res.equals("Post Liked")) return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().body(res);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<String>> getAllLikesForASingleArticle(@PathVariable String id) {
        List<String> res = likeService.getAllLikesForASingleArticle(id);
        if (res.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);
    }

}
