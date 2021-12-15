package com.abshar.twitter.processor.data.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix="twitter-kafka-forwarder")
@Data
public class TwitterKafkaForwarderConfiguration {
    List<String> keywords;
}
