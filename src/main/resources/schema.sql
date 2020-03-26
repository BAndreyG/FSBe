DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS news CASCADE;
DROP TABLE IF EXISTS categorys CASCADE;
DROP TABLE IF EXISTS user_category CASCADE;
DROP SEQUENCE IF EXISTS GLOBAL_SEQ CASCADE;

CREATE SEQUENCE global_seq START WITH 100000;
CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    surname    VARCHAR(50)                       NOT NULL,
    name       VARCHAR(50)                       NOT NULL,
    patronymic VARCHAR(50),
    birthday   TIMESTAMP           DEFAULT NOW() NOT NULL,
    foto       OID,
    gender     VARCHAR(1)                        NOT NULL,
    registered TIMESTAMP           DEFAULT NOW() NOT NULL,
    password   VARCHAR(255)                      NOT NULL,
    enabled    BOOLEAN             DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_name_password_idx
    ON USERS (name, password);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(50),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE categorys
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(50) NOT NULL
);

CREATE TABLE news
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    head        VARCHAR(100)                      NOT NULL,
    minText     VARCHAR(200)                      NOT NULL,
    news        VARCHAR                           NOT NULL,
    preview     OID,
    createDay   TIMESTAMP           DEFAULT NOW() NOT NULL,
    category_id INTEGER                           NOT NULL,
    link        VARCHAR(100)                      NOT NULL,
    enabled     BOOLEAN             DEFAULT TRUE  NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categorys (id) ON DELETE CASCADE
);

CREATE TABLE user_category
(
    user_id     INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categorys (id) ON DELETE CASCADE,
    CONSTRAINT user_category_idx UNIQUE (user_id, category_id)
);