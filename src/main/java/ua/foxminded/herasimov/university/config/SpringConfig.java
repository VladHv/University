package ua.foxminded.herasimov.university.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.dao.TimetableDao;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ua.foxminded.herasimov.university")
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/university");
        dataSource.setUsername("myuser");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public TimetableDao timetableDao() {
        return new TimetableDao(dataSource());
    }

    @Bean
    public GroupDao groupDao() {
        return new GroupDao(dataSource());
    }
}
