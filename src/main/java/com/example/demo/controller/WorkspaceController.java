package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Workspace;
import com.example.demo.service.WorkspaceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {
  private final WorkspaceService workspaceService;

  public WorkspaceController(WorkspaceService workspaceService) {
    this.workspaceService = workspaceService;
  }

  @GetMapping
  public List<Workspace> getWorkspaces() {
    return workspaceService.findAll();
  }

  @PostMapping("/populate")
  public ResponseEntity<Workspace> populate() {
    workspaceService.populate();
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Workspace> delete(@PathVariable(value = "id") Long id) {
    workspaceService.delete(id);
    return ResponseEntity.ok().build();
  }
}
