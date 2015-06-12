# --- Initialize users

# --- !Ups
insert into user values (2, 'a@a.com', 'a', 'amadou', 'Sall', '1991-04-01', 24, 'Grenoble', 'a', '05', 'Amadou !!');
insert into user values (1, 'b@b.com', 'a', 'amadou', 'Sall', '1991-04-01', 24, 'Grenoble', 'a', '05', 'Amadou !!');

# --- !Downs
SET REFERENTIAL_INTEGRITY FALSE;

delete from user;