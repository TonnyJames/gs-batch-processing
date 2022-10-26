package com.example.batchprocessing.steps.step2;

import com.example.batchprocessing.models.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ReaderStep2config {

    @Bean
    public FlatFileItemReader<Person> readerStep2CSV() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("readerStep2CSV")
                .resource(new ClassPathResource("csvTest2.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
    }
}
