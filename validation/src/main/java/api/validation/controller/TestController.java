package api.validation.controller;

import api.validation.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/article")
public class TestController {

    @PostMapping
    public ResponseEntity<String> saveArticle(final @Valid @RequestBody ArticleDto articleDto) {
        log.info("전달받은 데이터 {}", articleDto.toString());

        return ResponseEntity.ok().body("성공!!");
    }
}
