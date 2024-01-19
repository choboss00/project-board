package com.fastcampus.fastcampusprojectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        // TO-DO : 스프링 시큐리티로 인증 기능을 추가할 때, 수정할 것
        return () -> Optional.of("cho"); // jpa auditing을 사용하면 자동으로 생성자와 수정자를 채워준다
    }
}
