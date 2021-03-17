package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.mixin.Auditable;

@Entity
public class Edge extends BaseModel implements Auditable {
  @ManyToOne
  @JoinColumn(name = "chart_id")
  private Chart chart;

  @ManyToOne
  @JoinColumn(name = "from_node_id")
  private Node fromNode;

  @ManyToOne
  @JoinColumn(name = "to_node_id")
  private Node toNode;

  public Chart getChart() {
    return chart;
  }

  public void setChart(Chart chart) {
    this.chart = chart;
  }

  public Node getFromNode() {
    return fromNode;
  }

  public void setFromNode(Node fromNode) {
    this.fromNode = fromNode;
  }

  public Node getToNode() {
    return toNode;
  }

  public void setToNode(Node toNode) {
    this.toNode = toNode;
  }
}
