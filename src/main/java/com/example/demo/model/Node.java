package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

import com.example.demo.mixin.Auditable;

@Entity
public class Node extends BaseModel implements Auditable {
  @ManyToOne
  @JoinColumn(name = "chart_id")
  private Chart chart;

  @OneToMany(mappedBy = "fromNode")
  List<Edge> fromEdges;

  @OneToMany(mappedBy ="toNode")
  List<Edge> toEdges;

  public Chart getChart() {
    return chart;
  }

  public void setChart(Chart chart) {
    this.chart = chart;
  }

  public List<Edge> getFromEdges() {
    return fromEdges;
  }

  public List<Edge> getToEdges() {
    return toEdges;
  }
}
