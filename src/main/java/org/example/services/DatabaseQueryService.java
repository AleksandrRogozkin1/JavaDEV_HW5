package org.example.services;

import org.example.select.LongestProject;
import org.example.select.MaxProjectCountClient;
import org.example.select.MaxSalaryWorker;
import org.example.select.OldestYoungestWorkers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private ResultSet queryResult(String path) throws SQLException {
        ResultSet resultSet;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String maxProjectCountQueryStr =ReaderFileSQL.readSQLFile(path);
        resultSet = statement.executeQuery(maxProjectCountQueryStr);
        return resultSet;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> resultMaxProjectsClient = new ArrayList<>();
        try( ResultSet resultSet=queryResult("sql/find_max_projects_client.sql")){
            while(resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("name"));
                client.setProjectCount(resultSet.getInt("client"));
                resultMaxProjectsClient.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultMaxProjectsClient;
    }


    public List<LongestProject> findLongestProject(){
        List<LongestProject> resultLongestProject = new ArrayList<>();
        try (ResultSet resultSet=queryResult("sql/find_longest_project.sql")){
            while (resultSet.next()){
                LongestProject project=new LongestProject();
                project.setName(resultSet.getString("name"));
                project.setMonthCount(resultSet.getInt("monthCount"));
                resultLongestProject.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultLongestProject;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        try (ResultSet resultSet=queryResult("sql/find_max_salary_worker.sql")){
            while (resultSet.next()){
                MaxSalaryWorker worker=new MaxSalaryWorker();
                worker.setName(resultSet.getString("name"));
                worker.setSalary(resultSet.getInt("salary"));
                maxSalaryWorkers.add(worker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkers;
    }
    public List<OldestYoungestWorkers> findOldestYoungestWorkers(){
        List<OldestYoungestWorkers> oldestYoungestWorkers = new ArrayList<>();
        try (ResultSet resultSet=queryResult("sql/find_youngest_eldest_workers.sql")){
            while (resultSet.next()){
                OldestYoungestWorkers oyWorker=new OldestYoungestWorkers();
                oyWorker.setName(resultSet.getString("name"));
                oyWorker.setType(resultSet.getString("type"));
                oyWorker.setBirtday(resultSet.getString("birthday"));
                oldestYoungestWorkers.add(oyWorker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oldestYoungestWorkers;
    }


}
