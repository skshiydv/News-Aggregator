package io.github.skshiydv.newsaggregator.article.serviceImpl;

import io.github.skshiydv.newsaggregator.Comment.entity.Comment;
import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.mapper.ArticleEntityToGetArticle;
import io.github.skshiydv.newsaggregator.article.mapper.CreateArticleToArticle;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;
import io.github.skshiydv.newsaggregator.article.model.GetArticle;
import io.github.skshiydv.newsaggregator.article.repository.ArticleRepository;
import io.github.skshiydv.newsaggregator.article.service.ArticleService;
import io.github.skshiydv.newsaggregator.user.entity.UserEntity;
import io.github.skshiydv.newsaggregator.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public String addArticle(CreateArticle article) {
        try {
            ArticleEntity articleEntity = CreateArticleToArticle.INSTANCE.apply(article);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            UserEntity user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
            articleEntity.setAuthor(user);
            articleRepository.save(articleEntity);
            user.getArticles().add(articleEntity);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding article: " + e.getMessage(), e);
        }
        return "Article added successfully";
    }

    @Override
    public GetArticle getArticle(String title) {
        return null;
    }

    @Override
    public List<GetArticle> getArticlesByUsername(String username) {
        List<GetArticle> articles = new ArrayList<>();
        if (userRepository.findByUsername(username).isPresent()) {
            UserEntity userEntity = userRepository.findByUsername(username).get();
            List<ArticleEntity> articleEntities = userEntity.getArticles();
            for (ArticleEntity articleEntity : articleEntities) {
                articles.add(ArticleEntityToGetArticle.INSTANCE.apply(articleEntity));
            }
        }
        return articles;
    }

    @Override
    public ArticleEntity getArticleById(String id) {
        ArticleEntity articleEntity = articleRepository.findById(id).orElse(null);
        assert articleEntity != null;
        return articleEntity;
    }

    @Override
    public String saveComment(Comment comment, String id) {
        try {
            if (articleRepository.findById(id).isPresent()) {
                ArticleEntity articleEntity = articleRepository.findById(id).get();
                if (articleEntity.getComments() == null) {
                    articleEntity.setComments(new ArrayList<>());
                }

                articleEntity.getComments().add(comment);
                articleRepository.save(articleEntity);
            } else {
                return "Article Not Found";
            }

        } catch (Exception e) {
            throw new RuntimeException("Error while saving comment: " + e.getMessage(), e);
        }

        return "Success";
    }
}
