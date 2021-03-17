package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Chart;

import org.springframework.stereotype.Service;

import io.ebean.Database;

@Service
public class ChartService {
  private final Database database;

  public ChartService(Database database) {
    this.database = database;
  }

  public List<Chart> findAll() {
    return database.find(Chart.class).findList();
  }

  public void delete(Long id) {
    Chart chart = database.find(Chart.class).where().eq("id", id).findOne();
    chart.delete();
  }
}
