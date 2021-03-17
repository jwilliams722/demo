package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Edge extends BaseModel {
  
  @ManyToOne
  @JoinColumn(name = "chart_id")
  private Chart chart;

  @ManyToOne
  @JoinColumn(name = "from_node_id")
  private Node fromNode;

  @ManyToOne
  @JoinColumn(name = "to_node_id")
  private Node toNode;
  
}
