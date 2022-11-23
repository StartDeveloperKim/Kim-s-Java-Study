package study.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.aspect.domain.Article;
import study.aspect.repository.ArticleRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestData {

    private final ArticleRepository articleRepository;

    @PostConstruct
    void setTestData() {
        long count = articleRepository.count();
        log.info("setTestData {}", count);
        if (count==0) {
            List<Article> articles = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                Article article = Article.of("테스트" + i, "테스트" + i + "입니다.");
                articles.add(article);
            }
            articleRepository.saveAll(articles);
        }
    }
}
