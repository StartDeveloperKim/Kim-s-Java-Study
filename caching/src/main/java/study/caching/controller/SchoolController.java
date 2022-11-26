package study.caching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.caching.domain.School;
import study.caching.service.SchoolService;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<School> getSchoolList() {
        log.info("getSchoolList");
        return schoolService.getSchool();
    }

    @PostMapping("/{id}")
    public String updateSchoolList(@PathVariable("id") Long id,
                                   @RequestParam("name") String name) {

        log.info("name {}", name);
        schoolService.updateSchoolName(id, name);
        return "업데이트 성공";
    }
}
