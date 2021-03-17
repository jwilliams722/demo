package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Chart;
import com.example.demo.service.ChartService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charts")
public class ChartController {
  private final ChartService chartService;

  public ChartController(ChartService chartService) {
    this.chartService = chartService;
  }
  
  @GetMapping
  public List<Chart> getWorkspaces() {
    return chartService.findAll();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Chart> delete(@PathVariable(value = "id") Long id) {
    chartService.delete(id);
    return ResponseEntity.ok().build();
  }
}
