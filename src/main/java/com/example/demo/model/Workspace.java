package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.demo.mixin.Auditable;

@Entity
public class Workspace extends BaseModel implements Auditable {
  @OneToMany(mappedBy = "workspace", cascade = CascadeType.REMOVE)
  private List<Chart> charts;

  public List<Chart> getCharts() {
    return this.charts;
  }
}
