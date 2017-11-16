package com.javabyd1.HomeworkApp.TableJobOperations;

import com.javabyd1.HomeworkApp.Database.Database;
import com.javabyd1.HomeworkApp.TableOperationsInterface.TableOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JobOperationsImp implements TableOperations {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scannerChar = new Scanner(System.in);
    private String sql = null;
    Connection connection = Database.getConnection();

    private Statement getStatement() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public void createNewRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("DODAJ STANOWISKO");
        System.out.println("Podaj id stanowiska:");
        Integer newJobId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj nazwę stanowiska:");
        String newJobName = scanner.nextLine();
        sql = "INSERT INTO stanowiska (id_stanowiska, nazwa) VALUES (" + newJobId + ", '" +
                newJobName + "')";
        Integer newRecord = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        System.out.println("Dodano rekord o id " + newJobId + " do bazy");
        statement.close();
        connection.close();
    }

    @Override
    public void deleteRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("Podaj id rekordu, który chcesz usunąć: ");
        Integer choosenIdToDelete = scanner.nextInt();
        sql = "DELETE FROM stanowiska WHERE id_stanowiska = '" + choosenIdToDelete + "'";
        int queryResult = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        System.out.println("Usunięto rekord o id " + choosenIdToDelete);
    }

    @Override
    public void updateRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("Podaj id stanowiska, które chcesz uaktualnić:");
        Integer chosenIdToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podan nową nazwę stanowiska:");
        String updatedJobName = scanner.nextLine();
        sql = "UPDATE stanowiska SET nazwa = '" + updatedJobName + "' WHERE id_stanowiska = " +
                chosenIdToUpdate;
        Integer jobUpdate = statement.executeUpdate(sql);
        System.out.println("POWIADOMIENIE: Uaktualniono stanowisko o id " + chosenIdToUpdate);
        statement.close();
        connection.close();
    }

    @Override
    public void getListOfRows() throws SQLException {
        Statement statement = getStatement();
        sql = "SELECT * FROM stanowiska";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int jobId = resultSet.getInt("id_stanowiska");
            String jobName = resultSet.getString("nazwa");

            System.out.println("ID stanowiska: " + jobId);
            System.out.println("Nazwa stanowiska: " + jobName);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
