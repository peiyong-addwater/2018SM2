USE SCOTT;
SET AUTOCOMMIT=0;
-- Statement 
-- CONFIRM TRANSACTIONS are ENABLED
SELECT @@AUTOCOMMIT;

-- TRANSACTION BEGINS
START TRANSACTION; 
SELECT * FROM EMP
WHERE NAME = 'KING';
-- Statement 2
UPDATE EMP SET SALARY = 6000 
WHERE NAME = 'KING';
-- Statement 3 
SELECT * FROM EMP
WHERE NAME='KING';
-- Statement 4 
INSERT INTO EMP values 
(9999,'WADLEY', 'MANAGER', 7839, '2007-04-01',5500,NULL, 10);
SELECT * from EMP 
WHERE name in ('KING', 'WADLEY');

COMMIT; -- ALL CHANGES ARE MADE PERMANENT 

-- SEE our durable records here 
SELECT * from EMP 
WHERE name in ('KING', 'WADLEY');

-- TRY TO ROLLBACK
ROLLBACK;

SELECT * FROM EMP
WHERE name in ('KING','WADLEY');

-- ALL CHANGES ARE  ATOMIC - transactions either totally successful or totally fail
-- ALL DATA    IS   CONSISTENT
-- ALL CHANGES were ISOLATED and not viewable by other transactions until complete
-- ALL CHANGES are  DURABLE and made permanent even if the database fails. 