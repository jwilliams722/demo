package com.example.demo.model;

import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseModel extends Model {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "", allocationSize = 50)
  protected Long id;

  @Version
  protected Long version;

  @WhenCreated
  protected Instant createdOn;

  @WhenModified
  protected Instant modifiedOn;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Instant getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Instant createdOn) {
    this.createdOn = createdOn;
  }

  public Instant getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Instant modifiedOn) {
    this.modifiedOn = modifiedOn;
  }
}
