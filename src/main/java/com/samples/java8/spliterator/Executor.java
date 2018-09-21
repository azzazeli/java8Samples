package com.samples.java8.spliterator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author AlexM
 */
public class Executor {

    public static int countAuthors(Stream<Author> stream) {
        RelatedAuthorCounter relatedAuthorCounter = stream.reduce(new RelatedAuthorCounter(0, true),
                RelatedAuthorCounter::accumulate, RelatedAuthorCounter::combine);
        return relatedAuthorCounter.getCounter();
    }

    public static List<Article> generateElement() {
        return Stream.generate(() -> new Article("Java")).limit(35000).collect(Collectors.toList());
    }
}
