CREATE TABLE APP_USERS(
USER_ID  INT GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USERNAME VARCHAR(20),
PASSWORD VARCHAR(100)
);