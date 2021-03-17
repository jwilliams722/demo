package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Workspace extends BaseModel {
  @OneToMany(mappedBy = "workspace", cascade = CascadeType.REMOVE)
  private List<Chart> charts;


  public List<Chart> getCharts() {
    return this.charts;
  }
}
