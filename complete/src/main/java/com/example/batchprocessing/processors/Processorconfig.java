package com.example.batchprocessing.processors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processorconfig {

    // tag::readerwriterprocessor[]

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }
}
