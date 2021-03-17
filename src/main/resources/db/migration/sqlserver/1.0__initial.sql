-- apply changes
create table chart (
  id                            numeric(19) not null,
  workspace_id                  numeric(19) not null,
  version                       numeric(19) not null,
  created_on                    datetime2 not null,
  modified_on                   datetime2 not null,
  constraint pk_chart primary key (id)
);
create sequence chart_seq as bigint start with 1 increment by 50;

create table edge (
  id                            numeric(19) not null,
  chart_id                      numeric(19),
  from_node_id                  numeric(19),
  to_node_id                    numeric(19),
  version                       numeric(19) not null,
  created_on                    datetime2 not null,
  modified_on                   datetime2 not null,
  constraint pk_edge primary key (id)
);
create sequence edge_seq as bigint start with 1 increment by 50;

create table node (
  id                            numeric(19) not null,
  chart_id                      numeric(19),
  version                       numeric(19) not null,
  created_on                    datetime2 not null,
  modified_on                   datetime2 not null,
  constraint pk_node primary key (id)
);
create sequence node_seq as bigint start with 1 increment by 50;

create table workspace (
  id                            numeric(19) not null,
  version                       numeric(19) not null,
  created_on                    datetime2 not null,
  modified_on                   datetime2 not null,
  constraint pk_workspace primary key (id)
);
create sequence workspace_seq as bigint start with 1 increment by 50;

create index ix_chart_workspace_id on chart (workspace_id);
alter table chart add constraint fk_chart_workspace_id foreign key (workspace_id) references workspace (id);

create index ix_edge_chart_id on edge (chart_id);
alter table edge add constraint fk_edge_chart_id foreign key (chart_id) references chart (id);

create index ix_edge_from_node_id on edge (from_node_id);
alter table edge add constraint fk_edge_from_node_id foreign key (from_node_id) references node (id);

create index ix_edge_to_node_id on edge (to_node_id);
alter table edge add constraint fk_edge_to_node_id foreign key (to_node_id) references node (id);

create index ix_node_chart_id on node (chart_id);
alter table node add constraint fk_node_chart_id foreign key (chart_id) references chart (id);

