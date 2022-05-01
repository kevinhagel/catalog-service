package com.polarbookshop.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 *
 * @author Kevin Hagel
 * @since 2022-05-01
 */
@RestController
public class HomeController {

  @GetMapping("/")
  public String getGreeting() {
    return "Welcome to the book catalog!";
  }

}
