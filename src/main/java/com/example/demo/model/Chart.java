package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Chart extends BaseModel {

  @ManyToOne
  @JoinColumn(name = "workspace_id", nullable = false)
  private Workspace workspace;
  
  @OneToMany(mappedBy = "chart", cascade = CascadeType.REMOVE)
  private List<Edge> edges;

  @OneToMany(mappedBy = "chart", cascade = CascadeType.REMOVE)
  private List<Node> nodes;
  
}
