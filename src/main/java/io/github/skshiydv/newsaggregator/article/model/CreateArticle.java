package io.github.skshiydv.newsaggregator.article.model;

import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateArticle {
    private String title;
    private String content;
}
