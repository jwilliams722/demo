package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;

@Component
public class EbeanFactoryBean implements FactoryBean<Database> {
  private final DataSource dataSource;

  public EbeanFactoryBean(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Database getObject() throws Exception {
    DatabaseConfig config = new DatabaseConfig();
    config.setName("db");
    config.setDataSource(dataSource);

    config.loadFromProperties();

    return DatabaseFactory.create(config);
  }

  @Override
  public Class<?> getObjectType() {
    return Database.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}