package spring.db.test.context;

import spring.db.test.controller.TestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring.db.test.repository.TestRepository;

import javax.sql.DataSource;

@Configuration
@ComponentScan("spring.db.test")
public class TestContext {
    @Bean
    public DataSource dataSource(Environment environment) {
        DriverManagerDataSource dataSourceConfig = new DriverManagerDataSource();
        dataSourceConfig.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSourceConfig.setUrl(environment.getRequiredProperty("db.url"));
        dataSourceConfig.setUsername(environment.getRequiredProperty("db.username"));
        dataSourceConfig.setPassword(environment.getRequiredProperty("db.password"));
        return dataSourceConfig;
    }

    @Bean
    public TestController testController() {
        return new TestController();
    }
}
