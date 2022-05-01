package com.polarbookshop.catalogservice.domain;

/**
 * BookNotFoundException
 *
 * @author Kevin Hagel
 * @since 2022-05-01
 */
public class BookNotFoundException extends RuntimeException {

  public BookNotFoundException(String isbn) {
    super("The book with ISBN " + isbn + " was not found.");
  }
}
