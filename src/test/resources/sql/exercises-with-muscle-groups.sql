insert into muscle_group (id, name, parent_id)
values (nextval('seq_muscle_group'), 'shoulders', null),
       (nextval('seq_muscle_group'), 'chest', null),
       (nextval('seq_muscle_group'), 'anterior delta', 1),
       (nextval('seq_muscle_group'), 'average delta', 1),
       (nextval('seq_muscle_group'), 'rear delta', 1);

insert into exercise (id, name)
values (nextval('seq_exercise'), 'bench press'),
       (nextval('seq_exercise'), 'standing dumbbell fly'),
       (nextval('seq_exercise'), 'high pull');

insert into exercise_muscle_group (exercise_id, muscle_group_id, percentage)
values (1, 2, 100),
       (1, 3, 30),
       (2, 3, 40),
       (2, 4, 100);
