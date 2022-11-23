package study.aspect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.aspect.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
