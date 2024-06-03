package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }


  @Bean
  RestClient createRestClient() {

    return RestClient.create();
  }

  @Bean
  RestClient builderRestClient(RestClient.Builder builder) {

    return builder.build();
  }

  @Bean
  CommandLineRunner commandLineRunner(
      @Qualifier("createRestClient") RestClient createRestClient,
      @Qualifier("builderRestClient") RestClient builderRestClient) {

    return args -> {

      var body = Map.of(
          "message", "Hello World!"
      );

      var response = createRestClient.method(HttpMethod.GET)
          .uri(URI.create("http://localhost:8080/get"))
          .headers(httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_JSON))
          .body(new ObjectMapper().writeValueAsString(body))
          .retrieve()
          .body(Map.class);
      System.out.println(response);

      response = builderRestClient.method(HttpMethod.GET)
          .uri(URI.create("http://localhost:8080/get"))
          .headers(httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_JSON))
          .body(body)
          .retrieve()
          .body(Map.class);
      System.out.println(response);
    };
  }
}