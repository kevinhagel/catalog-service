package com.polarbookshop.catalogservice.domain;

/**
 * Your basic Book.
 */
public record Book(
  String isbn,
  String title,
  String author,
  Double price
) {}

