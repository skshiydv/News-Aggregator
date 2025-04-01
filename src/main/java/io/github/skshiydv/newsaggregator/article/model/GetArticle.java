package io.github.skshiydv.newsaggregator.article.model;

import io.github.skshiydv.newsaggregator.user.model.GetUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetArticle {
    private String title;
    private String content;
    private String author;
    private Set<GetUserDTO> likes;
    private List<CommentDto> comments;
}
