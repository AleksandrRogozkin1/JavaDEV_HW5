SELECT 
    CONCAT('project',project.id) as NAME,
    SUM(worker.SALARY *DATEDIFF(MONTH, project.start_date, project.finish_date)) as PRICE
FROM project_worker
    left join worker on worker.id = project_worker.worker_id
    left join project on project.id = project_worker.project_id
group by NAME
order by PRICE desc