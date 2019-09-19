INSERT INTO USER (ID, NAME, BIRTH_DATE, NOT_TO_DISPLAY) VALUES ('10000', 'Bob Charlie', SYSDATE, 'Not to display this field. Add @JsonIgnore on it in User bean, if displayed');
INSERT INTO USER (ID, NAME, BIRTH_DATE, NOT_TO_DISPLAY) VALUES('10001', 'Adam Ji', SYSDATE, 'Not to display this field. Add @JsonIgnore on it in User bean, if displayed');
INSERT INTO USER (ID, NAME, BIRTH_DATE, NOT_TO_DISPLAY) VALUES('10002', 'Jack Sir', SYSDATE, 'Not to display this field. Add @JsonIgnore on it in User bean, if displayed');
INSERT INTO POST VALUES (11000, 'MY FIRST POST', 10000);
INSERT INTO POST VALUES (11001, 'MY SECOND POST', 10000);