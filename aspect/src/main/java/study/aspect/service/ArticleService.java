package study.aspect.service;

import org.springframework.data.domain.PageRequest;
import study.aspect.domain.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getArticleList();

    List<Article> getArticleListPaging(PageRequest request);

    void saveAllArticleList();

    void saveEachArticleList();
}
