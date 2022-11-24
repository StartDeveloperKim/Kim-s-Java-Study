package study.aspect.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.aspect.domain.Article;
import study.aspect.repository.ArticleRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getArticleListPaging(PageRequest request) {
        return articleRepository.findAll(request).getContent();
    }

    // saveAll vs save -> 100개의 데이터
    @Override
    public void saveAllArticleList() {
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            articles.add(Article.of("테스트" + i, "테스트" + i + "입니다."));
        }
        articleRepository.saveAll(articles);
    }

    @Override
    public void saveEachArticleList() {
        for (int i = 0; i < 100; i++) {
            Article article = Article.of("테스트" + i, "테스트" + i + "입니다.");
            articleRepository.save(article);
        }
    }
}
