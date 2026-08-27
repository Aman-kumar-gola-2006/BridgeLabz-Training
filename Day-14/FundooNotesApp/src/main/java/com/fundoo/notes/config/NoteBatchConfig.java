package com.fundoo.notes.config;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;

@Configuration
public class NoteBatchConfig {

    private static final Logger logger = LoggerFactory.getLogger(NoteBatchConfig.class);

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteBatchConfig(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    // 1. ItemReader: Reads input items (e.g. sample note requests for batch processing)
    @Bean
    public ListItemReader<NoteRequest> noteItemReader() {
        List<NoteRequest> sampleRequests = Arrays.asList(
            new NoteRequest("Batch Note 1", "Imported via Spring Batch processing chunk 1"),
            new NoteRequest("Batch Note 2", "Imported via Spring Batch processing chunk 2"),
            new NoteRequest("Batch Note 3", "Imported via Spring Batch processing chunk 3")
        );
        return new ListItemReader<>(sampleRequests);
    }

    // 2. ItemProcessor: Transforms NoteRequest DTO into Note Entity
    @Bean
    public ItemProcessor<NoteRequest, Note> noteItemProcessor() {
        return request -> {
            logger.info("SPRING BATCH - Processing note: title='{}'", request.getTitle());
            User defaultUser = userRepository.findAll().stream().findFirst().orElse(null);
            if (defaultUser == null) {
                logger.warn("SPRING BATCH - No default user found for batch processing");
                return null;
            }
            return new Note(request.getTitle(), request.getDescription(), defaultUser);
        };
    }

    // 3. ItemWriter: Writes processed Note items to database in chunks
    @Bean
    public ItemWriter<Note> noteItemWriter() {
        return notes -> {
            logger.info("SPRING BATCH - Writing batch chunk of {} notes to database", notes.size());
            noteRepository.saveAll(notes);
        };
    }

    // 4. Step: Combines Reader, Processor, and Writer into a chunk-oriented step (chunk size = 2)
    @Bean
    public Step noteBatchStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("noteBatchStep", jobRepository)
                .<NoteRequest, Note>chunk(2, transactionManager)
                .reader(noteItemReader())
                .processor(noteItemProcessor())
                .writer(noteItemWriter())
                .build();
    }

    // 5. Job: Defines the complete batch execution workflow
    @Bean
    public Job importNotesJob(JobRepository jobRepository, Step noteBatchStep) {
        return new JobBuilder("importNotesJob", jobRepository)
                .start(noteBatchStep)
                .build();
    }
}
