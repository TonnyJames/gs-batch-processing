package com.example.batchprocessing.steps.step2;

import com.example.batchprocessing.models.Person;
import com.example.batchprocessing.processors.Processorconfig;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class Step2config {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    // end::setup[]

    @Autowired
    private ReaderStep2config reader;

    @Autowired
    private Processorconfig processor;

//    @Qualifier("transactionManagerBackup")
//    @Autowired
//    private PlatformTransactionManager transactionManager;

    @Bean
    public Step step2(JdbcBatchItemWriter<Person> writer) {
        return stepBuilderFactory.get("step2")
                .<Person, Person> chunk(10)
                .reader(reader.readerStep2CSV())
                .processor(processor.processor())
                .writer(writer)
//                .transactionManager(transactionManager)
                .build();
    }
    // end::jobstep[]
}
