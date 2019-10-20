CREATE TABLE students
(
    id         INTEGER(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(50)          NOT NULL,
    created_at TIMESTAMP            NOT NULL,
    updated_at TIMESTAMP NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;