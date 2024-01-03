insert into muscle_group (id, name, parent_id)
values (nextval('seq_muscle_group'), 'shoulders', null),
       (nextval('seq_muscle_group'), 'chest', null),
       (nextval('seq_muscle_group'), 'anterior delta', 1),
       (nextval('seq_muscle_group'), 'average delta', 1),
       (nextval('seq_muscle_group'), 'rear delta', 1);
