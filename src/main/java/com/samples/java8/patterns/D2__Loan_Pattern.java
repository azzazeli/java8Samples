package com.samples.java8.patterns;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.jooq.lambda.Unchecked;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class D2__Loan_Pattern {

    static class Order {
        Long id;
        LocalDate creationDate;

        public Order(Long id, List<Object> emptyList, LocalDate localDate) {
            this.id = id;
            this.creationDate = localDate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDate getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
        }
    }

    interface OrderRepo extends JpaRepository<Order, Long> { // Spring Data FanClub
        Stream<Order> findByActiveTrue(); // 1 Mln orders ;)
    }

    class FileExporter {
        public File exportFile(String fileName, Consumer<Writer> contentWriter) throws Exception {
            File file = new File("export/" + fileName);
            try (Writer writer = new FileWriter(file)) {
                contentWriter.accept(writer);
                return file;
            } catch (Exception e) {
                // TODO send email notification
                System.out.println("Gotcha!" + e); // TERROR-Driven Development
                throw e;
            }
        }
    }

    static class OrderExportWriter  {

        private OrderRepo orderRepo;

        public void writeOrders(Writer writer) throws IOException {
            writer.write("OrderID;Date\n");
            orderRepo.findByActiveTrue()
                    .map(o -> o.getId() + ";" + o.getCreationDate())
                    .forEach(Unchecked.consumer(writer::write));
        }
    }


    @RunWith(MockitoJUnitRunner.class)
    public static class UserExportWriterTest {
        @InjectMocks
        private OrderExportWriter contentWriter;

        @Mock
        private OrderRepo repo;

        @Test
        public void writesExpectedContent() throws IOException {
            Writer w = new StringWriter();
            when(repo.findByActiveTrue()).thenReturn(Stream.of(new Order(1l, emptyList(), LocalDate.of(2018, 1, 1))));
            contentWriter.writeOrders(w);
            assertEquals("OrderID;Date\n1;2018-01-01", w.toString());
        }
    }

}
