package com.example.batchprocessing.steps.step1;

import com.example.batchprocessing.models.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ReaderStep1config {

    @Bean
    public FlatFileItemReader<Person> readerStep1CSV() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("readerStep1CSV")
                .resource(new ClassPathResource("csvTest1.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{setTargetType(Person.class);}})
                .build();
    }
}
