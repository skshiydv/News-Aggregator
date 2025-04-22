package io.github.skshiydv.newsaggregator.likes.serviceImpl;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.repository.ArticleRepository;
import io.github.skshiydv.newsaggregator.likes.entity.LikesEntity;
import io.github.skshiydv.newsaggregator.likes.repository.LikesRepository;
import io.github.skshiydv.newsaggregator.likes.services.LikeService;
import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikesServiceImpl implements LikeService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public LikesServiceImpl(LikesRepository likesRepository, UserRepository userRepository, ArticleRepository articleRepository) {
        this.likesRepository = likesRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    @Transactional
    public String addLike(String id) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            UserEntity entity = userRepository.findByUsername(username).get();
            LikesEntity likesEntity = new LikesEntity();
            likesEntity.setUserId(entity.getId());
            likesRepository.save(likesEntity);
            ArticleEntity articleEntity = articleRepository.findById(id).get();
            articleEntity.getLikes().add(likesEntity);
            articleRepository.save(articleEntity);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Post Liked";
    }

    @Override
    public List<String> getAllLikesForASingleArticle(String id) {
        List<LikesEntity> likes = articleRepository.findById(id).get().getLikes();
        List<String> likedUsers = new ArrayList<>();
        likes.forEach(likesEntity -> {
            likedUsers.add(likesEntity.getUserId());
        });
        return likedUsers;
    }
}
