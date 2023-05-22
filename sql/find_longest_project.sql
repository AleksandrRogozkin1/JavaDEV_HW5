SELECT CONCAT('Project ',id) as NAME, DATEDIFF(MONTH, start_date, finish_date) as month_count from project
group by ID
having month_count = (
select max(DATEDIFF(MONTH, start_date, finish_date)) from project)