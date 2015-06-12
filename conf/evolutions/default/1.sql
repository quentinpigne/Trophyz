# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table championship (
  stage_id                  bigint not null,
  stage_name                varchar(255),
  stage_start_date          timestamp,
  stage_end_date            timestamp,
  stage_pts_per_win         bigint,
  stage_pts_per_loss        bigint,
  stage_draw_active         boolean,
  stage_pts_per_draw        bigint,
  stage_contest_contest_id  bigint,
  constraint pk_championship primary key (stage_id))
;

create table contest (
  contest_id                bigint not null,
  contest_name              varchar(255),
  contest_start_date        timestamp,
  contest_end_date          timestamp,
  contest_nb_contestants    bigint,
  contest_by_team           boolean,
  contest_organizer_user_id bigint,
  constraint pk_contest primary key (contest_id))
;

create table s_group (
  group_id                  bigint not null,
  group_name                varchar(255),
  group_stage_stage_id      bigint,
  constraint pk_s_group primary key (group_id))
;

create table knockout (
  stage_id                  bigint not null,
  stage_name                varchar(255),
  stage_start_date          timestamp,
  stage_end_date            timestamp,
  stage_pts_per_win         bigint,
  stage_pts_per_loss        bigint,
  stage_draw_active         boolean,
  stage_pts_per_draw        bigint,
  stage_contest_contest_id  bigint,
  constraint pk_knockout primary key (stage_id))
;

create table match (
  match_id                  bigint not null,
  match_date                timestamp,
  match_time                timestamp,
  match_duration            bigint,
  match_score               varchar(255),
  match_group_group_id      bigint,
  match_place_place_id      bigint,
  constraint pk_match primary key (match_id))
;

create table place (
  place_id                  bigint not null,
  place_name                varchar(255),
  place_location            varchar(255),
  constraint pk_place primary key (place_id))
;

create table score (
  score_id                  bigint not null,
  score_nb_wins             bigint,
  score_nb_draws            bigint,
  score_nb_losses           bigint,
  score_points              bigint,
  score_goal_for            bigint,
  score_goal_against        bigint,
  score_group_group_id      bigint,
  score_user_user_id        bigint,
  constraint pk_score primary key (score_id))
;

create table stage (
  stage_id                  bigint not null,
  stage_name                varchar(255),
  stage_start_date          timestamp,
  stage_end_date            timestamp,
  stage_pts_per_win         bigint,
  stage_pts_per_loss        bigint,
  stage_draw_active         boolean,
  stage_pts_per_draw        bigint,
  stage_contest_contest_id  bigint,
  constraint pk_stage primary key (stage_id))
;

create table team (
  team_id                   bigint not null,
  team_name                 varchar(255),
  constraint pk_team primary key (team_id))
;

create table user (
<<<<<<< HEAD
  user_id                   bigint  auto_increment not null,
  user_email                varchar(255),
  user_password             varchar(255),
  user_first_name           varchar(255),
  user_last_name            varchar(255),
  user_birth_date           timestamp,
  user_age                  bigint,
  user_address              varchar(255),
  user_user_name            varchar(255),
  user_phone                varchar(255),
  user_description          varchar(255),
  constraint pk_user primary key (user_id))
;


create table contest_user (
  contest_contest_id             bigint not null,
  user_user_id                   bigint not null,
  constraint pk_contest_user primary key (contest_contest_id, user_user_id))
;

create table contest_team (
  contest_contest_id             bigint not null,
  team_team_id                   bigint not null,
  constraint pk_contest_team primary key (contest_contest_id, team_team_id))
;

create table s_group_user (
  s_group_group_id               bigint not null,
  user_user_id                   bigint not null,
  constraint pk_s_group_user primary key (s_group_group_id, user_user_id))
;

create table match_user (
  match_match_id                 bigint not null,
  user_user_id                   bigint not null,
  constraint pk_match_user primary key (match_match_id, user_user_id))
;

create table match_team (
  match_match_id                 bigint not null,
  team_team_id                   bigint not null,
  constraint pk_match_team primary key (match_match_id, team_team_id))
;

create table team_user (
  team_team_id                   bigint not null,
  user_user_id                   bigint not null,
  constraint pk_team_user primary key (team_team_id, user_user_id))
;
create sequence championship_seq;

create sequence contest_seq;

create sequence s_group_seq;

create sequence knockout_seq;

create sequence match_seq;

create sequence place_seq;

create sequence score_seq;

create sequence stage_seq;

create sequence team_seq;

alter table championship add constraint fk_championship_stageContest_1 foreign key (stage_contest_contest_id) references contest (contest_id) on delete restrict on update restrict;
create index ix_championship_stageContest_1 on championship (stage_contest_contest_id);
alter table contest add constraint fk_contest_contestOrganizer_2 foreign key (contest_organizer_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_contest_contestOrganizer_2 on contest (contest_organizer_user_id);
alter table s_group add constraint fk_s_group_groupStage_3 foreign key (group_stage_stage_id) references stage (stage_id) on delete restrict on update restrict;
create index ix_s_group_groupStage_3 on s_group (group_stage_stage_id);
alter table knockout add constraint fk_knockout_stageContest_4 foreign key (stage_contest_contest_id) references contest (contest_id) on delete restrict on update restrict;
create index ix_knockout_stageContest_4 on knockout (stage_contest_contest_id);
alter table match add constraint fk_match_matchGroup_5 foreign key (match_group_group_id) references s_group (group_id) on delete restrict on update restrict;
create index ix_match_matchGroup_5 on match (match_group_group_id);
alter table match add constraint fk_match_matchPlace_6 foreign key (match_place_place_id) references place (place_id) on delete restrict on update restrict;
create index ix_match_matchPlace_6 on match (match_place_place_id);
alter table score add constraint fk_score_scoreGroup_7 foreign key (score_group_group_id) references s_group (group_id) on delete restrict on update restrict;
create index ix_score_scoreGroup_7 on score (score_group_group_id);
alter table score add constraint fk_score_scoreUser_8 foreign key (score_user_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_score_scoreUser_8 on score (score_user_user_id);
alter table stage add constraint fk_stage_stageContest_9 foreign key (stage_contest_contest_id) references contest (contest_id) on delete restrict on update restrict;
create index ix_stage_stageContest_9 on stage (stage_contest_contest_id);



alter table contest_user add constraint fk_contest_user_contest_01 foreign key (contest_contest_id) references contest (contest_id) on delete restrict on update restrict;

alter table contest_user add constraint fk_contest_user_user_02 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;

alter table contest_team add constraint fk_contest_team_contest_01 foreign key (contest_contest_id) references contest (contest_id) on delete restrict on update restrict;

alter table contest_team add constraint fk_contest_team_team_02 foreign key (team_team_id) references team (team_id) on delete restrict on update restrict;

alter table s_group_user add constraint fk_s_group_user_s_group_01 foreign key (s_group_group_id) references s_group (group_id) on delete restrict on update restrict;

alter table s_group_user add constraint fk_s_group_user_user_02 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;

alter table match_user add constraint fk_match_user_match_01 foreign key (match_match_id) references match (match_id) on delete restrict on update restrict;

alter table match_user add constraint fk_match_user_user_02 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;

alter table match_team add constraint fk_match_team_match_01 foreign key (match_match_id) references match (match_id) on delete restrict on update restrict;

alter table match_team add constraint fk_match_team_team_02 foreign key (team_team_id) references team (team_id) on delete restrict on update restrict;

alter table team_user add constraint fk_team_user_team_01 foreign key (team_team_id) references team (team_id) on delete restrict on update restrict;

alter table team_user add constraint fk_team_user_user_02 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists championship;

drop table if exists contest;

drop table if exists contest_user;

drop table if exists contest_team;

drop table if exists s_group;

drop table if exists s_group_user;

drop table if exists knockout;

drop table if exists match;

drop table if exists match_user;

drop table if exists match_team;

drop table if exists place;

drop table if exists score;

drop table if exists stage;

drop table if exists team;

drop table if exists team_user;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists championship_seq;

drop sequence if exists contest_seq;

drop sequence if exists s_group_seq;

drop sequence if exists knockout_seq;

drop sequence if exists match_seq;

drop sequence if exists place_seq;

drop sequence if exists score_seq;

drop sequence if exists stage_seq;

drop sequence if exists team_seq;

