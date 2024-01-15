package app.impacto_manager;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "app.impacto_manager.repository")
public class JpaConfig {
}