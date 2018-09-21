package com.samples.java8.spliterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author AlexM
 */
public class ExecutorUnitTest {
    Article article;
    Stream<Author> stream;
    Spliterator<Article> split1;
    Spliterator<Article> split2;

    @Before
    public void init() {
        article = new Article(Arrays.asList(
                new Author("Ahmad", 0), new Author("Eugen", 0), new Author("Alice", 1),
                new Author("Alice", 1), new Author("Mike", 0),  new Author("Alice", 1),
                new Author("Mike", 0),  new Author("Alice", 1), new Author("Mike", 0),
                new Author("Alice", 1), new Author("Mike", 0),  new Author("Mike", 0),
                new Author("Alice", 1), new Author("Mike", 0),  new Author("Alice", 1),
                new Author("Mike", 0),  new Author("Alice", 1), new Author("Mike", 0),
                new Author("Alice", 1), new Author("Mike", 1),  new Author("Michał", 1),
                new Author("Loredana", 1)),
                0);
        stream =article.getListOfAuthors().stream();
        split1 = Executor.generateElement().spliterator();
        split2 = split1.trySplit();

    }

    @Test
    public void relatedCount() {
        Supplier<Stream<Author>> supplier = () -> Stream.of(article.getListOfAuthors().toArray(new Author[0]));
        System.out.println(Executor.countAuthors(supplier.get()));
        System.out.println(Executor.countAuthors(supplier.get().parallel()));
    }

    @Test
    public void spliterator() throws Exception {
        System.out.println("split1 size:" + split1.estimateSize());
        System.out.println("split1 characteristics:" + split1.characteristics());
        System.out.println(new Task(split1).call());
        System.out.println(new Task(split2).call());
    }
}
