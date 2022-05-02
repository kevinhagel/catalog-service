package com.polarbookshop.catalogservice.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * PolarProperties
 *
 * @author Kevin Hagel
 * @since 2022-05-02
 */
@ConfigurationProperties(prefix = "polar")
@Getter
@Setter
public class PolarProperties {

  /**
   * A message to welcome users.
   */
  private String greeting;

}
