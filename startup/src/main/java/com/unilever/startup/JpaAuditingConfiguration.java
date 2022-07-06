package com.unilever.startup;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
public class JpaAuditingConfiguration implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            Object userContext = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (userContext instanceof String &&
                    !((String) userContext).equalsIgnoreCase("anonymousUser")) {
                return Optional.of((String) userContext);
            } else {
                return Optional.of("UNAUTHENTICATED-SPRING");
            }
        } catch(Exception e) {
            return Optional.of("UNAUTHENTICATED-SPRING");
        }
    }



}