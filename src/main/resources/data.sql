INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Anonymous', 'secret@gmail.com', '{noop}secret');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO QUOTE(user_id, author, content, score)
VALUES (1, 'Sveta', 'a nice good very perfect', 0),
       (2, 'Kolya', 'not nice not very perfect', 1);

INSERT INTO VOTE(quote_id, user_id, vote_value)
VALUES (1, 1, true),
       (1, 2, false),
       (2, 1, true);
