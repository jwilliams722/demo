package com.example.demo.service;

import com.example.demo.model.Chart;
import com.example.demo.model.Edge;
import com.example.demo.model.Node;
import com.example.demo.model.Workspace;

import org.springframework.stereotype.Service;

import io.ebean.Database;


@Service
public class ExampleService {
  private final Database database;

  public ExampleService(Database database) {
    this.database = database;
  }

  public void execute() {
    Workspace workspace = new Workspace();
    workspace.save();

    Chart chart = new Chart();
    chart.setWorkspace(workspace);
    chart.save();

    Node node1 = new Node();
    node1.setChart(chart);
    node1.save();

    Node node2 = new Node();
    node2.setChart(chart);
    node2.save();

    Edge edge = new Edge();
    edge.setChart(chart);
    edge.setFromNode(node1);
    edge.setToNode(node2);
    edge.save();

    workspace.delete();
  }
}
