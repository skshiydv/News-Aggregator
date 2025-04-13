package io.github.skshiydv.newsaggregator.user.entity;
import io.github.skshiydv.newsaggregator.article.entity.ArticleEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserEntity {
    @Id
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String username;
    @DBRef
    private List<ArticleEntity> articles = new ArrayList<>();

    private List<String> roles = new ArrayList<>();
}
