USE ssafydb;

# 인사팀
CREATE VIEW view_emp1 AS
SELECT employee_id "사번", first_name "이름", hire_date "입사일자", salary "급여액"
FROM employees;

# 기획실
CREATE VIEW view_emp2 AS
SELECT e.employee_id "사번", e.first_name "이름", d.department_name "근무부서", j.job_title "담당업무"
FROM employees e
LEFT OUTER JOIN departments d ON e.department_id = d.department_id
LEFT OUTER JOIN jobs j ON e.job_id = j.job_id;

# 사내복지팀
CREATE VIEW view_emp3 AS
SELECT e.employee_id "사번", e.first_name "이름", d.department_name "근무부서", 
	CONCAT(l.street_address, ", ", l.postal_code, ", ", l.city) "근무부서 주소"
FROM employees e
LEFT OUTER JOIN departments d ON e.department_id = d.department_id
LEFT OUTER JOIN locations l ON d.location_id = l.location_id;

SELECT *
FROM view_emp1;

SELECT *
FROM view_emp2;

SELECT *
FROM view_emp3;