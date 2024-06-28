-- Create the schema and the tables in the current database
CREATE SCHEMA otus_test
    AUTHORIZATION pg_database_owner;

CREATE TABLE otus_test.test
(
    test_id serial NOT NULL,
    name character varying(256) NOT NULL,
    PRIMARY KEY (test_id),
    UNIQUE (test_name)
);

CREATE TABLE otus_test.question
(
    question_id serial NOT NULL,
    content text NOT NULL,
    test_id integer NOT NULL,
    PRIMARY KEY (question_id),
    FOREIGN KEY (test_id)
        REFERENCES otus_test.test (test_id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);

CREATE TABLE otus_test.answer
(
    answer_id serial NOT NULL,
    content text NOT NULL,
    question_id integer NOT NULL,
    is_correct boolean NOT NULL,
    PRIMARY KEY (answer_id),
    FOREIGN KEY (question_id)
        REFERENCES otus_test.question (question_id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);

-- Fill in example data
INSERT INTO otus_test.test(test_id, name)
	VALUES (1, 'Java basic test');

INSERT INTO otus_test.question(test_id, question_id, content)
	VALUES (1, 1, 'Java is...?');
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (1, 1, '... a coffee', false);
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (1, 2, '... run by trillion devices', false);
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (1, 3, 'No one truly knows', true);

INSERT INTO otus_test.question(test_id, question_id, content)
	VALUES (1, 2, 'What does garbage collector collect?');
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (2, 4, 'Garbage', false);
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (2, 5, 'Coins', false);
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (2, 6, 'Lag spikes', true);

INSERT INTO otus_test.test(test_id, name)
	VALUES (2, 'Java pro test');
INSERT INTO otus_test.question(test_id, question_id, content)
	VALUES (2, 3, 'Java is...');
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (3, 7, '... a programming language and computing platform first released by Sun Microsystems in 1995', false);
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (3, 8, '... consisting of the Java Virtual Machine (JVM), Java platform core classes, and supporting Java platform libraries', false);
INSERT INTO otus_test.answer(question_id, answer_id, content, is_correct)
	VALUES (3, 9, '... a coffee', true);

-- List all tests
SELECT t.test_id, t.name FROM otus_test.test AS t;

-- List all questions of a specific test
SELECT q.question_id, q.content FROM otus_test.question AS q WHERE q.test_id = 1;

-- List all answers of a specific question
SELECT a.answer_id, a.content FROM otus_test.answer AS a WHERE a.question_id = 1;

-- List all questions of a specific test and their respectful correct answer
SELECT q.content, a.content
    FROM otus_test.question AS q
    JOIN otus_test.answer AS a ON a.question_id = q.question_id
    WHERE q.test_id = 1 AND a.is_correct;