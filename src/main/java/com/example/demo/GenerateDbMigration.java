package com.example.demo;

import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

import java.io.IOException;

public class GenerateDbMigration {
  /**
   * Generate the DDL for the next DB migration.
   */
  public static void main(String[] args) throws IOException {

    /**
     *
     * Ebean does not apply destructive actions to migrations by default
     *
     * Update the version and uncomment the line below to commit destructive migrations
     * Pending migrations will appear in the log as INFO level messages similar to:
     *   INFO  c.a.ebean.dbmigration.DbMigration - Pending un-applied drops in versions [1.0]
     */
    // System.setProperty("ddl.migration.pendingDropsFor", "1.0");

    DbMigration dbMigration = DbMigration.create();
    dbMigration.setPlatform(Platform.SQLSERVER17);

    /* 
      The statement below allows you to bypass certain DB restrictions such as bypassing required defaults for non-null columns
      Only use it after careful consideration and ensure that it is left commented before checking in any code changes.
    */
    // dbMigration.setStrictMode(false);
    dbMigration.generateMigration();
  }
}
