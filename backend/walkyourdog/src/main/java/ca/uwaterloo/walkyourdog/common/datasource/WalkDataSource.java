package ca.uwaterloo.walkyourdog.common.datasource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.SQLException;

import javax.sql.DataSource;

@Configuration

public class WalkDataSource {
    @Bean(name = "dataSourceConfig")
    @ConfigurationProperties(prefix = "data.config")
    public DataSourceConfig demoDataBaseConfig() {
        return new DataSourceConfig();
    }

    @Bean(name = "demoHikariDataSource")
    @Primary
    public javax.sql.DataSource hikariDataSource(@Qualifier("dataSourceConfig") DataSourceConfig dataSourceConfig)
            throws SQLException {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dataSourceConfig.getDriver());
        hikariDataSource.setUsername(dataSourceConfig.getUserName());
        hikariDataSource.setPassword(dataSourceConfig.getPassword());
        hikariDataSource.setJdbcUrl(dataSourceConfig.getUrl());
        hikariDataSource.setMaximumPoolSize(dataSourceConfig.getMaxPoolSize());
        hikariDataSource.setMinimumIdle(1);
        hikariDataSource.setConnectionInitSql("select 1");
        return hikariDataSource;
    }
}
