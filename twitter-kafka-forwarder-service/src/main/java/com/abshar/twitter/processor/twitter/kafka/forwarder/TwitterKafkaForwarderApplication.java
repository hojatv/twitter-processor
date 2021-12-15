package com.abshar.twitter.processor.twitter.kafka.forwarder;

import com.abshar.twitter.processor.data.config.TwitterKafkaForwarderConfiguration;
import com.abshar.twitter.processor.twitter.kafka.forwarder.runner.impl.TwitterStreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.abshar.twitter.processor")

@RequiredArgsConstructor
@Slf4j
public class TwitterKafkaForwarderApplication implements CommandLineRunner {
    private final TwitterKafkaForwarderConfiguration twitterKafkaForwarderConfiguration;
    private final TwitterStreamRunner twitterStreamRunner;
    public static void main(String[] args) {
        SpringApplication.run(TwitterKafkaForwarderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(twitterKafkaForwarderConfiguration.getKeywords().toString());
        twitterStreamRunner.start();
    }
}
