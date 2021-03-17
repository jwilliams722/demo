package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Workspace;

import org.springframework.stereotype.Service;

import io.ebean.Database;

@Service
public class WorkspaceService {
  private final Database database;

  public WorkspaceService(Database database) {
    this.database = database;
  }

  public List<Workspace> findAll() {
    return database.find(Workspace.class).findList();
  }
}
