package com.abshar.twitter.processor.twitter.kafka.forwarder.runner;

import twitter4j.TwitterException;

public interface StreamRunner {
    void start() throws TwitterException;
}
