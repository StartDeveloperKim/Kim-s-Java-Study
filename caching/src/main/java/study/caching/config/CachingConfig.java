package study.caching.config;

import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CachingConfig {

    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactoryBean() {
        return new EhCacheManagerFactoryBean();
    }


}
