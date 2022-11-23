package study.aspect.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createDate;


    private Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

    protected Article() {
    }

    public static Article of(String title, String content) {
        return new Article(title, content);
    }
}
