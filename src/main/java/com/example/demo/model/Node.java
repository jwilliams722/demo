package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Node extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "chart_id")
  private Chart chart;

  @OneToMany(mappedBy = "fromNode", cascade = CascadeType.REMOVE)
  List<Edge> fromEdges;

  @OneToMany(mappedBy ="toNode", cascade = CascadeType.REMOVE)
  List<Edge> toEdges;
}
