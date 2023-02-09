INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Anonymous', 'secret@gmail.com', '{noop}secret');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);



INSERT INTO QUOTE(user_id, author, content, score)
VALUES (1, 'Альберт Эйнштейн', 'Чем умнее человек, тем легче он признает себя дураком', 0),
       (2, 'Теодор Рузвельт', 'Никогда не ошибается тот, кто ничего не делает', 1),
       (3, 'Лев Николаевич Толстой', 'Менее всего просты люди, желающие казаться простыми', 2),
       (3, 'Стив Джобс', 'Мы находимся здесь, чтобы внести свой вклад в этот мир. Иначе зачем мы здесь?', 3);


INSERT INTO USERS_QUOTE(user_id, quote_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (3, 4);

INSERT INTO VOTE(quote_id, user_id, vote_value)
VALUES (1, 1, true),
       (1, 2, false),
       (2, 1, true),
       (3, 1, true),
       (3, 2, true),
       (4, 1, true),
       (4, 2, true),
       (4, 3, false),
       (4, 4, true);
