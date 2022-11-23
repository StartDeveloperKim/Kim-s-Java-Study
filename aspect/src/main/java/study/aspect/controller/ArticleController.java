package study.aspect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
