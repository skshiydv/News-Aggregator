package io.github.skshiydv.newsaggregator.likes.services;

import java.util.List;

public interface LikeService {
    public String addLike(String id);

    public List<String> getAllLikesForASingleArticle(String id);
}
