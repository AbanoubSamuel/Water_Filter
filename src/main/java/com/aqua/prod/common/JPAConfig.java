package com.aqua.prod.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.aqua.prod.datarest",},
        repositoryBaseClass = GenericRepoImpl.class)
@EntityScan(basePackages = "com.aqua.prod.entity")
public class JPAConfig {
}
