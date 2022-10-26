package com.example.batchprocessing;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


//    @Bean
//    public DataSource springDS() {
//        return DataSourceBuilder.create().build();
//    }

    //O banco primário já possui por padrão seu controlador de transição que respeita o "Chunk"
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource postgresDS() {
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    @ConfigurationProperties(prefix = "backup.datasource")
//    public DataSource backupDS() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    //controlador de transações para banco backup "chunk"
//    @Bean
//    public PlatformTransactionManager transactionManagerBackup(@Qualifier("backupDS") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
