/**
 * Author:  Coffeeddicted
 * Created: 14 mars 2018
 *
 * Preload data for unit tests.
 * Designed for H2 in-memory (AutoConfigured thanks to Spring Boot).
 */

/*
 * Class SomethingType
 * Table SOMETHING_TYPE [ ID, NAME ]
 */
SELECT SEQ_SOMETHING_TYPE.nextval FROM DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some type'); -- 1
SELECT SEQ_SOMETHING_TYPE.nextval FROM DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some other type'); -- 2
SELECT SEQ_SOMETHING_TYPE.nextval FROM DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some type again'); -- 3
SELECT SEQ_SOMETHING_TYPE.nextval FROM DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some other type again'); -- 4
SELECT SEQ_SOMETHING_TYPE.nextval FROM DUAL;
INSERT INTO SOMETHING_TYPE VALUES (SEQ_SOMETHING_TYPE.currval, 'Some type again'); -- 5

/*
 * Class Something
 * Table SOMETHING [ ID, NAME, PRIMARY_SOMETHING_TYPE, SECONDARY_SOMETHING_TYPE ]
 */
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 1', 1, 2); -- 1
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 2', 1, NULL); -- 2
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 3', 3, 1); -- 3
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 4', 1, 3); -- 4
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 5', 1, NULL); -- 5
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 6', 2, 2); -- 6
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 7', 4, 1); -- 7
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 8', 4, 1); -- 8
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 9', 4, 3); -- 9
SELECT SEQ_SOMETHING.nextval FROM DUAL;
INSERT INTO SOMETHING VALUES (SEQ_SOMETHING.currval, 'Something 10', 4, 2); -- 10

/*
 * Class Contraption
 * Table CONTRAPTION [ ID, NAME, SOME_DATE, EXPIRATION_DATE, ELEMENTARY ]
 * Nota : OneToMany relationship is stored outside of the table representing
 *        the container class.
 * Nota : Hibernate generates schema ordering columns alaphabetically, so
 *        it's better to use the extended INSERT notation (with column names).
 */
 SELECT SEQ_CONTRAPTION.nextval FROM DUAL;
 INSERT INTO CONTRAPTION (ID, NAME, SOME_DATE, EXPIRATION_DATE, ELEMENTARY)
 VALUES (SEQ_CONTRAPTION.currval, 'Contraption 1', PARSEDATETIME('2015-03-23', 'yyyy-MM-dd'), PARSEDATETIME('2020-06-23', 'yyyy-MM-dd'), FALSE); -- 1
 SELECT SEQ_CONTRAPTION.nextval FROM DUAL;
 INSERT INTO CONTRAPTION (ID, NAME, SOME_DATE, EXPIRATION_DATE, ELEMENTARY)
 VALUES (SEQ_CONTRAPTION.currval, 'Contraption 2', PARSEDATETIME('2018-01-01', 'yyyy-MM-dd'), PARSEDATETIME('2018-12-31', 'yyyy-MM-dd'), FALSE); -- 2
 SELECT SEQ_CONTRAPTION.nextval FROM DUAL;
 INSERT INTO CONTRAPTION (ID, NAME, SOME_DATE, EXPIRATION_DATE, ELEMENTARY)
 VALUES (SEQ_CONTRAPTION.currval, 'Contraption 3', PARSEDATETIME('2017-06-30', 'yyyy-MM-dd'), PARSEDATETIME('2018-06-29', 'yyyy-MM-dd'), FALSE); -- 3
 SELECT SEQ_CONTRAPTION.nextval FROM DUAL;
 INSERT INTO CONTRAPTION (ID, NAME, SOME_DATE, EXPIRATION_DATE, ELEMENTARY)
 VALUES (SEQ_CONTRAPTION.currval, 'Contraption 4', PARSEDATETIME('2019-03-23', 'yyyy-MM-dd'), PARSEDATETIME('2020-06-23', 'yyyy-MM-dd'), FALSE); -- 4
 SELECT SEQ_CONTRAPTION.nextval FROM DUAL;
 INSERT INTO CONTRAPTION (ID, NAME, SOME_DATE, EXPIRATION_DATE, ELEMENTARY)
 VALUES (SEQ_CONTRAPTION.currval, 'Contraption 5', PARSEDATETIME('2015-03-23', 'yyyy-MM-dd'), PARSEDATETIME('2016-06-23', 'yyyy-MM-dd'), FALSE); -- 5
