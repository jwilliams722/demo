package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Chart;
import com.example.demo.model.Edge;
import com.example.demo.model.Node;
import com.example.demo.model.Workspace;

import org.springframework.stereotype.Service;

import io.ebean.Database;

@Service
public class WorkspaceService {
  private final Database database;

  public WorkspaceService(Database database) {
    this.database = database;
  }

  public List<Workspace> findAll() {
    return database.find(Workspace.class).findList();
  }

  public void delete(Long id) {
    Workspace workspace = database.find(Workspace.class).where().eq("id", id).findOne();
    workspace.delete();
  }

  public void populate() {
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
  }
}
