package study.aspect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import study.aspect.service.ArticleService;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public String getArticleList() {
        log.info("getArticleList");
        articleService.getArticleList();
        return "성공";
    }

    @GetMapping("/{page}")
    public String getArticleListPaging(@PathVariable("page") int page) {
        log.info("getArticleListPaging");
        articleService.getArticleListPaging(PageRequest.of(page - 1, 10));
        return "성공";
    }

    @PostMapping("/all")
    public String saveAllArticle() {
        log.info("saveAllArticle");
        articleService.saveAllArticleList();
        return "성공";
    }

    @PostMapping("/each")
    public String saveEachArticle() {
        log.info("savedEachArticle");
        articleService.saveEachArticleList();
        return "성공";
    }
}
