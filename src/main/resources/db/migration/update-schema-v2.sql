CREATE TABLE test_table
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    CONSTRAINT pk_testtable PRIMARY KEY (id)
);