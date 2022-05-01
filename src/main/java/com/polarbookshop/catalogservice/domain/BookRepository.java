package com.polarbookshop.catalogservice.domain;

import java.util.Optional;

/**
 * BookRepository
 *
 * @author Kevin Hagel
 * @since 2022-05-01
 */
public interface BookRepository {

  Iterable<Book> findAll();
  Optional<Book> findByIsbn(String isbn);
  boolean existsByIsbn(String isbn);
  Book save(Book book);
  void deleteByIsbn(String isbn);
}
