/**
 * Author:  Coffeeddicted
 * Created: 14 mars 2018
 *
 * Preload data for unit tests.
 * Designed for H2 in-memory (AutoConfigured thanks to Spring Boot).
 */

/*
 * Class SomethingType
 * Table SOMETHING_TYPE
 */
SELECT SEQ_SOMETHING_TYPE.nextval from DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some name'); -- 1
SELECT SEQ_SOMETHING_TYPE.nextval from DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some other name'); -- 2
SELECT SEQ_SOMETHING_TYPE.nextval from DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some name again'); -- 3
SELECT SEQ_SOMETHING_TYPE.nextval from DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some other name again'); -- 4
SELECT SEQ_SOMETHING_TYPE.nextval from DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some name again'); -- 5
