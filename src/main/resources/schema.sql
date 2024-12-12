CREATE TABLE question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mcq VARCHAR(255) NOT NULL,
    optiona VARCHAR(100) NOT NULL,
    optionb VARCHAR(100) NOT NULL,
    optionc VARCHAR(100) NOT NULL,
    optiond VARCHAR(100) NOT NULL,
    correct_option CHAR(1) NOT NULL
);