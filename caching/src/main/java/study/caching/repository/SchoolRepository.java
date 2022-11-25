package study.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.caching.domain.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
