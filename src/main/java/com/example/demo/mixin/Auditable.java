package com.example.demo.mixin;

import javax.persistence.PreRemove;

public interface Auditable {
  @PreRemove
  default void preRemove() {
    this.refresh();
    // Run auditing logic that writes current model properties to db
  }

  // Should fetch the latest property data and ensure no lazy-loading of properties occurs
  public void refresh();
}
