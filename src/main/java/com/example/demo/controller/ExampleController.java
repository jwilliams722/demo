package com.example.demo.controller;

import com.example.demo.service.ExampleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {
  private final ExampleService exampleService;

  public ExampleController(ExampleService exampleService) {
    this.exampleService = exampleService;
  }

  @PostMapping
  public ResponseEntity<?> example() {
    exampleService.execute();
    return ResponseEntity.ok().build();
  }
}
