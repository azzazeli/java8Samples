package com.samples.java8.spliterator;

import java.util.Spliterator;
import java.util.concurrent.Callable;

/**
 * @author AlexM
 */
public class Task implements Callable<String> {

    private final Spliterator<Article> spliterator;
    private static final String SUFIX = " published by Baeldung";

    public Task(Spliterator<Article> spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public String call() throws Exception {
        int current = 0;
        while (spliterator.tryAdvance(article -> { article.setName(article.getName() + SUFIX); })){
            current++;
        };

        return Thread.currentThread().getName() + ":" + current;
    }
}
