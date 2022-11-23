package study.aspect.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.aspect.domain.Article;
import study.aspect.repository.ArticleRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }
}
