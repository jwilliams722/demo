package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Workspace;
import com.example.demo.service.WorkspaceService;

import org.springframework.web.bind.annotation.GetMapping;
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
    // return List.of();
  }
}
