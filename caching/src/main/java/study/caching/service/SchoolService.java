package study.caching.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.caching.domain.School;
import study.caching.repository.SchoolRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    @Cacheable("schoolCacheStore") // 캐시 데이터 저장 공간의 이름
    public List<School> getSchool() {
        log.info("cacheable 실행");

        return schoolRepository.findAll();
    }

    @Transactional
    @CacheEvict(value = "schoolCacheStore", allEntries = true)
    public void updateSchoolName(Long id, String name) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("엔티티가 없습니다."));
        school.updateName(name);
    }


    @PostConstruct
    private void setData() {
        long count = schoolRepository.count();
        if (count == 0) {
            List<School> schools = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                schools.add(School.from("학교" + i));
            }
            schoolRepository.saveAll(schools);
        }
    }
}
