package com.prosigliere.challenge.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.prosigliere.challenge.*" })
@EntityScan(basePackages = { "com.prosigliere.challenge.*" })
public class PersistenceConfig {
	
	
}
