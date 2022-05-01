package com.polarbookshop.catalogservice.domain;

/**
 * BookAlreadyExistsException
 *
 * @author Kevin Hagel
 * @since 2022-05-01
 */
public class BookAlreadyExistsException extends RuntimeException {



  public BookAlreadyExistsException(String isbn) {
    super("A book with ISBN " + isbn + " already exists");
  }
}
