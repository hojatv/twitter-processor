package com.abshar.twitter.processor.twitter.kafka.forwarder.runner.impl;

//import com.abshar.twitter.processor.data.config.TwitterKafkaForwarderConfiguration;
import com.abshar.twitter.processor.data.config.TwitterKafkaForwarderConfiguration;
import com.abshar.twitter.processor.twitter.kafka.forwarder.listener.TwitterStatusListener;
import com.abshar.twitter.processor.twitter.kafka.forwarder.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class TwitterStreamRunner implements StreamRunner {
    private final TwitterKafkaForwarderConfiguration twitterKafkaForwarderConfiguration;
    private final TwitterStatusListener twitterStatusListener;
    private TwitterStream twitterStream;
    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterStatusListener);
        String[] keys = twitterKafkaForwarderConfiguration.getKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keys);
        twitterStream.filter(filterQuery);
        log.info("filtering strea for keys {}" , Arrays.toString(keys));

    }

    @PostConstruct
    public void shutDown(){
        if(twitterStream != null){
            log.info("Closing twitter Stream");
            twitterStream.shutdown();
        }
    }
}
