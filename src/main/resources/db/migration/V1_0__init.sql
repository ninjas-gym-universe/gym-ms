create table muscle_group
(
    id        smallint    not null,
    "name"    varchar(50) not null,
    parent_id smallint,
    constraint muscle_group_pkey primary key (id),
    constraint muscle_group_fkey foreign key (parent_id) references muscle_group (id) on delete restrict on update cascade
);
create sequence seq_muscle_group maxvalue 500;
create unique index muscle_group_uindex on muscle_group using btree (parent_id, name);

create table exercise
(
    id     smallint    not null,
    "name" varchar(50) not null,
    constraint exercise_pkey primary key (id)
);
create sequence seq_exercise maxvalue 500;
create unique index exercise_uindex on exercise using btree (name);

create table exercise_muscle_group
(
    exercise_id     smallint not null,
    muscle_group_id smallint not null,
    percentage      smallint,
    constraint exercise_muscle_group_pkey primary key (exercise_id, muscle_group_id),
    constraint exercise_muscle_group_exercise_fkey foreign key (exercise_id) references exercise (id) on delete cascade on update cascade,
    constraint exercise_muscle_group_muscle_group_fkey foreign key (muscle_group_id) references muscle_group (id) on delete restrict on update cascade
);
