package com.polarbookshop.catalogservice.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.polarbookshop.catalogservice.domain.Book;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Profile;

@JsonTest
class BookJsonTests {

  @Autowired
  private JacksonTester<Book> json;

  @Test
  void testSerialize() throws Exception {
    var now = Instant.now();
    var book = new Book(null, "1234567890", "Title", "Author", 9.90, "Polarsophia", now, now, 0);
    System.out.println("book = " + book);
    var jsonContent = json.write(book);
    System.out.println("jsoncontent = " + jsonContent);
    assertThat(jsonContent).extractingJsonPathNumberValue("@.id")
      .isEqualTo(book.id());
    assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
      .isEqualTo(book.isbn());
    assertThat(jsonContent).extractingJsonPathStringValue("@.title")
      .isEqualTo(book.title());
    assertThat(jsonContent).extractingJsonPathStringValue("@.author")
      .isEqualTo(book.author());
    assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
      .isEqualTo(book.price());
    assertThat(jsonContent).extractingJsonPathStringValue("@.createdDate")
      .isEqualTo(book.createdDate().toString());
    assertThat(jsonContent).extractingJsonPathStringValue("@.lastModifiedDate")
      .isEqualTo(book.lastModifiedDate().toString());
    assertThat(jsonContent).extractingJsonPathNumberValue("@.version")
      .isEqualTo(book.version());
  }

  @Test
  void testDeserialize() throws Exception {
    var instant = Instant.parse("2021-09-07T22:50:37.135029Z");

    var content = """
      {
        "id"   :            394,
        "isbn" :            "1234567890",
        "title" :           "Title",
        "author" :          "Author",
        "createdDate":      "2021-09-07T22:50:37.135029Z",
        "lastModifiedDate": "2021-09-07T22:50:37.135029Z",
        "price" :            9.90,
        "publisher" :        "Polarsophia",
        "version" :          21
      }
      """;
    assertThat((json.parse(content)))
      .usingRecursiveComparison()
      .isEqualTo(new Book( 394L,"1234567890", "Title", "Author", 9.90, "Polarsophia", instant, instant, 21));
  }

}