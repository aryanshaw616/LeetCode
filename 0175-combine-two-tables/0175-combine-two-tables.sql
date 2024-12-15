# Write your MySQL query statement below
SELECT P.firstname, P.lastname, A.city, A.state
From Person p LEFT JOIN Address A 
on P.PersonId = A.personId