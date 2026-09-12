package org.example.springbootintro;

import java.math.BigDecimal;
import org.example.springbootintro.model.Book;
import org.example.springbootintro.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = new Book();
                book.setTitle("Kobzar");
                book.setAuthor("Taras Shevchenko");
                book.setIsbn("978-966-03-1234-5");
                book.setPrice(BigDecimal.valueOf(250));
                book.setDescription("Classic Ukrainian poetry collection");

                bookService.save(book);

                bookService.findAll().forEach(System.out::println);
            }
        };
    }
}
