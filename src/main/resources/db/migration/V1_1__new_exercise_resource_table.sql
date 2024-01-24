create type "extension" as enum ('jpg', 'jpeg', 'png', 'avi', 'gif', 'mp4', 'mpeg4');

create table exercise_resource
(
    id             smallint    not null,
    exercise_id    smallint    not null,
    "content"      bytea       not null,
    file_name      varchar(50) not null,
    file_extension extension   not null,
    constraint exercise_resource_pkey primary key (id),
    constraint exercise_resource_fkey foreign key (exercise_id) references exercise (id) on delete cascade on update cascade
);
create sequence seq_exercise_resource maxvalue 50000;

alter table muscle_group
    add column avatar bytea;

