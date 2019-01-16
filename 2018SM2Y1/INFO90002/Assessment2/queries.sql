-- Question One
SELECT `givenName`, `familyName` FROM `Student`
ORDER BY LENGTH(`givenName`) + LENGTH(`familyName`) DESC
LIMIT 1;

-- Question Two
SELECT `givenName`, `familyName` FROM `Student`
LEFT JOIN `Availability` ON `Student`.`id` = `Availability`.`Student`
WHERE `Availability`.`Student` IS NULL;

-- Question Three
SELECT `Student`.* FROM `Student`, `Availability`
WHERE `Student`.`id` = `Availability`.`Student` 
AND `Availability`.`hour` = 10
AND `Availability`.`day` = 'Wed'; 

-- Question Four
SELECT `Student`.`givenName`, `Student`.`familyName`, `Groups`.`name` AS 'groupName'
FROM `Student` LEFT OUTER JOIN `StudentInGroup`
ON `Student`.`id` = `StudentInGroup`.`StudentId`
LEFT OUTER JOIN `Groups` 
ON `StudentInGroup`.`groupId` = `Groups`.`id`;

-- Question Five
SELECT `groupId` AS 'ID of the group', COUNT(`groupId`) AS 'number of students'
FROM `StudentInGroup`
GROUP BY `StudentInGroup`.`groupId` HAVING (COUNT(`StudentInGroup`.`groupId`) > 3);

-- Question Six
SELECT IF(
(SELECT `description` 
FROM `Student` INNER JOIN `Availability` ON `Student`.`id` = `Availability`.`Student`  
INNER JOIN `Calendar` ON `Availability`.`day` = `Calendar`.`day` AND `Availability`.`hour` = `Calendar`.`hour` 
WHERE `givenName` = 'Alice' AND `familyName` = 'Smith') = 'lunch', 'yes', 'no')
AS 'Is Alice Smith free at lunch on Wednesdays';

-- Question Seven
SELECT `Availability`.`day`, `Availability`.`hour` FROM `Availability` 
WHERE `Availability`.`Student` = 10001
AND (`Availability`.`day`,`Availability`.`hour`)
IN 
(SELECT `Availability`.`day`, `Availability`.`hour` FROM `Availability` 
WHERE `Availability`.`Student` = 10001);

-- Question Eight !!!!!!!!!
SELECT `groupId`, `givenName`, `familyName` FROM
(SELECT
`groupId`, `givenName`, `familyName` 
FROM `StudentInGroup` LEFT JOIN `Student` ON `StudentInGroup`.`StudentId`=`Student`.`id`
ORDER BY `groupId`, `familyName` DESC)
AS t1
LEFT JOIN 
(SELECT `groupId` AS gID, `givenName` AS ggN, `familyName` AS fN
FROM `StudentInGroup` LEFT JOIN `Student` ON `StudentInGroup`.`StudentId`=`Student`.`id`
ORDER BY `groupId`, `familyName` DESC)
AS t2
ON t1.`groupId` = t2.`gID` AND t1.`familyName` > t2.`fN`
WHERE t2.`gID` IS NULL
ORDER BY 1;

-- Question Nine
SELECT DISTINCT `Student`.`id`, `Student`.`givenName`, `Student`.`familyName`
FROM `Student` INNER JOIN `Availability` ON `Student`.`id`=`Availability`.`Student`
WHERE `Availability`.`day` = 'Wed' 
AND (`Availability`.`hour` BETWEEN 10 AND 12);

-- Question Ten
SELECT IF(
(SELECT COUNT(*) FROM `StudentInGroup` INNER JOIN `Groups` ON `StudentInGroup`.`groupId` = `Groups`.`id` WHERE `Groups`.`name`='WeLoveDb')
 = 
 (SELECT COUNT(*) FROM `StudentInGroup`  INNER JOIN `Groups` ON `StudentInGroup`.`groupId` = `Groups`.`id` 
 INNER JOIN `Availability` ON `Availability`.`Student`=`StudentInGroup`.`StudentId`
 WHERE `Groups`.`name`='WeLoveDb' AND `Availability`.`day`='Wed' AND `Availability`.`hour`=10),
'yes',
'no'
)
AS 'Are the members of \'WeLoveDb\' all free on Wednesday at 10am?';



-- SELECT * FROM `StudentInGroup` INNER JOIN `Groups` ON `StudentInGroup`.`groupId` = `Groups`.`id` WHERE `Groups`.`name`='WeLoveDb';

-- SELECT * FROM `StudentInGroup`  INNER JOIN `Groups` ON `StudentInGroup`.`groupId` = `Groups`.`id` INNER JOIN `Availability` ON `Availability`.`Student`=`StudentInGroup`.`StudentId` WHERE `Groups`.`name`='WeLoveDb' AND `Availability`.`day`='Wed' AND `Availability`.`hour`=10;