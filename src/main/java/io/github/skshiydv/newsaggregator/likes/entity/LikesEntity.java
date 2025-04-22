package io.github.skshiydv.newsaggregator.likes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "likes")
public class LikesEntity {
    @Id
    private String id;
    private String userId;
}
