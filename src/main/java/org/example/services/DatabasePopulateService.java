package org.example.services;

import org.example.ConstructorsForDBP.ClientC;
import org.example.ConstructorsForDBP.ProjectC;
import org.example.ConstructorsForDBP.ProjectWorkerC;
import org.example.ConstructorsForDBP.WorkersC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DatabasePopulateService {

    private final Connection connection=Database.getInstance().getConnection();

    public static void main(String[] args) {

        List<WorkersC> workers= Arrays.asList(
                new WorkersC("Messi", LocalDate.parse("1995-05-08"), "Senior", 6600),
                new WorkersC("Barzagli", LocalDate.parse("1977-09-04"), "Junior", 359),
                new WorkersC("Ronaldo", LocalDate.parse("1992-12-11"), "Senior", 7500),
                new WorkersC("Yarmolenko", LocalDate.parse("2000-01-01"), "Trainee", 250),
                new WorkersC("Welback", LocalDate.parse("2005-03-22"), "Trainee", 377),
                new WorkersC("Rashford", LocalDate.parse("1979-08-15"), "Junior", 1234),
                new WorkersC("Sterling", LocalDate.parse("1995-02-02"), "Junior", 1277),
                new WorkersC("Haaland", LocalDate.parse("1999-06-17"), "Middle", 3000),
                new WorkersC("Mbape", LocalDate.parse("2001-09-23"), "Middle", 3333),
                new WorkersC("Dybala", LocalDate.parse("1997-11-29"), "Trainee", 600)

        );
        List<ClientC> clients = Arrays.asList(
                new ClientC( "Chelsea"),
                new ClientC("DZK"),
                new ClientC( "Arsenal"),
                new ClientC( "Lvi na Jeepe"),
                new ClientC( "Ubisoft"));

        List<ProjectC> projects=Arrays.asList(
                new ProjectC(1,LocalDate.parse("2022-02-03"), LocalDate.parse("2023-07-20")),
                new ProjectC(2,LocalDate.parse("2021-01-12"), LocalDate.parse("2022-11-25")),
                new ProjectC(3,LocalDate.parse("2020-12-04"), LocalDate.parse("2021-12-28")),
                new ProjectC(4,LocalDate.parse("2020-01-10"), LocalDate.parse("2025-08-28")),
                new ProjectC(5,LocalDate.parse("2019-01-09"), LocalDate.parse("2030-11-21")),
                new ProjectC(1,LocalDate.parse("2020-01-12"), LocalDate.parse("2022-09-12")),
                new ProjectC(2,LocalDate.parse("2018-01-11"), LocalDate.parse("2021-10-10")),
                new ProjectC(3,LocalDate.parse("2022-11-11"), LocalDate.parse("2024-10-19")),
                new ProjectC(4,LocalDate.parse("2020-01-10"), LocalDate.parse("2025-10-01")),
                new ProjectC(5,LocalDate.parse("2022-06-23"), LocalDate.parse("2026-01-11"))
        );
        List<ProjectWorkerC> projectWorker=Arrays.asList(
                new ProjectWorkerC(1, 7),
                new ProjectWorkerC(1, 8),
                new ProjectWorkerC(1, 6),
                new ProjectWorkerC(2, 9),
                new ProjectWorkerC(2, 10),
                new ProjectWorkerC(3, 9),
                new ProjectWorkerC(3, 8),
                new ProjectWorkerC(4, 7),
                new ProjectWorkerC(5, 9),
                new ProjectWorkerC(5, 8),
                new ProjectWorkerC(5, 6),
                new ProjectWorkerC(5, 7),
                new ProjectWorkerC(6, 9),
                new ProjectWorkerC(6, 7),
                new ProjectWorkerC(7, 7),
                new ProjectWorkerC(7, 8),
                new ProjectWorkerC(7, 6),
                new ProjectWorkerC(8, 7),
                new ProjectWorkerC(8, 9),
                new ProjectWorkerC(9, 6),
                new ProjectWorkerC(10, 6),
                new ProjectWorkerC(10, 5)
        );
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        databasePopulateService.insertWorker(workers);
        databasePopulateService.insertClient(clients);
        databasePopulateService.insertProject(projects);

        databasePopulateService.insertProjectWorker(projectWorker);


    }
    public void insertWorker(List<WorkersC> workers){
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO worker  (name, birthday, level, salary) VALUES (? , ? , ? , ? )")){
            for (WorkersC worker : workers) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setString(2, worker.getBirthday().toString());
                preparedStatement.setString(3, worker.getLevel());
                preparedStatement.setInt(4, worker.getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertClient(List<ClientC> clients){
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (name) VALUES (?)")) {
            for (ClientC client :clients) {
                preparedStatement.setString(1, client.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertProject( List<ProjectC> projects){
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES ( ?, ?, ?)")) {
            for (ProjectC project :projects) {
                preparedStatement.setInt(1, project.getClient_id());
                preparedStatement.setString(2, project.getStart_date().toString());
                preparedStatement.setString(3, project.getFinish_date().toString());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertProjectWorker( List<ProjectWorkerC> projectWorker){
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES ( ? , ? )")) {
            for (ProjectWorkerC projectW :projectWorker) {
                preparedStatement.setInt(1, projectW.getProjectId());
                preparedStatement.setInt(2, projectW.getWorkerId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}

