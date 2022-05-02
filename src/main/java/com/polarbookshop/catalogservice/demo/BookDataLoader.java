package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * BookDataLoader Load book test data when testdata profile is active
 *
 * @author Kevin Hagel
 * @since 2022-05-02
 */
@Component
@Profile("testdata")
public class BookDataLoader {
  private final BookRepository bookRepository;

  public BookDataLoader(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void loadBookTestData() {
    bookRepository.deleteAll();
    var book1 = Book.build("1234567891", "Northern Lights", "Lyra Silvertoungue", 9.90, "Polarsophia");
    var book2 = Book.build("1234567892", "Polar Journey", "Iorek Polarson", 12.90, "Polarsophia");
    bookRepository.saveAll(List.of(book1, book2));
  }
}
