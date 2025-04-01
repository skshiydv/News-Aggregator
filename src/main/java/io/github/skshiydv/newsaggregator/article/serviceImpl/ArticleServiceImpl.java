package io.github.skshiydv.newsaggregator.article.serviceImpl;

import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import io.github.skshiydv.newsaggregator.article.mapper.CreateArticleToArticle;
import io.github.skshiydv.newsaggregator.article.model.CreateArticle;
import io.github.skshiydv.newsaggregator.article.repository.ArticleRepository;
import io.github.skshiydv.newsaggregator.article.service.ArticleService;
import io.github.skshiydv.newsaggregator.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ArticleEntity addArticle(CreateArticle article) {
        ArticleEntity articleEntity = new ArticleEntity();
        try {
            articleEntity = CreateArticleToArticle.INSTANCE.apply(article);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            articleEntity.setAuthor(userRepository.findByUsername(username).get());
            articleEntity = articleRepository.save(articleEntity);
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }

        return articleEntity;
    }
}
