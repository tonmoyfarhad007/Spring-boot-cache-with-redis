CREATE SEQUENCE students_id_sequence as integer START 1 INCREMENT 1;

CREATE TABLE students (
     id         INT4         DEFAULT nextval('students_id_sequence') PRIMARY KEY,

     name       VARCHAR(255) NOT NULL,
     email      VARCHAR(255) UNIQUE NOT NULL,
     roll       INT4         UNIQUE NOT NULL,

     created_by VARCHAR(255),
     updated_by VARCHAR(255),
     created_at TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP(6) NOT NULL,
     updated_at TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP(6)
);