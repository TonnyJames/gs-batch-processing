package com.example.batchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// tag::setup[]
@Configuration
@EnableBatchProcessing
public class JobConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    // tag::jobstep[]
    @Bean
    public Job importUserJob(
            JobCompletionNotificationListener listener,
            @Qualifier("step1") Step step1,
            @Qualifier("step2")Step step2) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1)
                .next(step2)
//                .end()
                .build();
    }
}
