# --- Initialize users

# --- !Ups
insert into user values (1, 'quentin', 't', 'Quentin', 'Pigné', '1991-06-06', 24, '32 Rue Champ Rochas', 'quentin.pigne@gmail.com', '0625474415', 'Quentin !!');
insert into user values (2, 'amadou', 't', 'Amadou', 'Sall', '1991-04-01', 24, '', 'amadou.sall@ensimag.grenoble-inp.fr', '', 'Amadou !!');

# --- !Downs
SET REFERENTIAL_INTEGRITY FALSE;

delete from user;