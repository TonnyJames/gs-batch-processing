package com.example.batchprocessing.writerdata;

import com.example.batchprocessing.models.Person;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class WriterSqlconfig {

    @Bean
    public JdbcBatchItemWriter<Person> writer(@Qualifier("postgresDS") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource)
                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
                .build();
    }
    // end::readerwriterprocessor[]
}
