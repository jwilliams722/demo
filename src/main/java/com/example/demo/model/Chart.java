package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.mixin.Auditable;

@Entity
public class Chart extends BaseModel implements Auditable {
  @ManyToOne
  @JoinColumn(name = "workspace_id", nullable = false)
  private Workspace workspace;
  
  @OneToMany(mappedBy = "chart", cascade = CascadeType.REMOVE)
  private List<Edge> edges;

  @OneToMany(mappedBy = "chart", cascade = CascadeType.REMOVE)
  private List<Node> nodes;
  
  public Workspace getWorkspace() {
    return workspace;
  }

  public Long getWorkspaceId() {
    Workspace workspace = getWorkspace();
    return workspace == null ? null : workspace.getId();
  }

  public void setWorkspace(Workspace workspace) {
    this.workspace = workspace;
  }

  public List<Node> getNodes() {
    return nodes;
  }

  public List<Edge> getEdges() {
    return edges;
  }
}
