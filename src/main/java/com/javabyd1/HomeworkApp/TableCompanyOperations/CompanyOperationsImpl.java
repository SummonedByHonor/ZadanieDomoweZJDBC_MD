package com.javabyd1.HomeworkApp.TableCompanyOperations;

import com.javabyd1.HomeworkApp.Database.Database;
import com.javabyd1.HomeworkApp.TableOperationsInterface.TableOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class CompanyOperationsImpl implements TableOperations {
    private Scanner scanner = new Scanner(System.in);
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
        System.out.println("DODAJ ADRES:");
        System.out.println("Podaj id firmy:");
        Integer companyIdGivenValue = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj nazwę firmy:");
        String companyNameGivenValue = scanner.nextLine();
        System.out.println("Podaj adres, firmy:");
        System.out.print("ulica: ");
        String street = scanner.nextLine();
        System.out.print("numer domu: ");
        String houseNumber = scanner.nextLine();
        System.out.print("numer mieszkania: ");
        String apartamentNumber = scanner.nextLine();
        System.out.println("Podaj NIP firmy:");
        String NIPGivenValue = scanner.nextLine();
        sql = "INSERT INTO firmy (id_firmy, nazwa, ulica, numer_domu, numer_mieszkania, nip)" + "VALUES (" + companyIdGivenValue +
                ", '" + companyNameGivenValue + "', '" + street + "', '" + houseNumber + "', '" + apartamentNumber + "', '" +
                NIPGivenValue + "')";
        Integer newRecord = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        System.out.println("Dodano rekord o id " + companyIdGivenValue + " do bazy");
    }

    @Override
    public void deleteRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("Podaj id rekordu, który chcesz usunąć: ");
        Integer choosenIdToDelete = scanner.nextInt();
        sql = "DELETE FROM firmy WHERE id_firmy = '" + choosenIdToDelete + "'";
        int queryResult = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        System.out.println("Usunięto rekord o id " + choosenIdToDelete);
    }

    @Override
    public void updateRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("Podaj id rekordu, który chcesz zaktualizować.");
        int chosenIdToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wybierz opcję:");
        System.out.println("1. Aktualizacja nazwy firmy.");
        System.out.println("2. Aktualizacja adresu firmy.");
        System.out.println("3. Aktualizacja nazwy i adresu firmy.");
//        System.out.println("4. Wstecz.");
        String choosenOptionOfUpdate = scanner.nextLine();
        switch (choosenOptionOfUpdate) {
            case "1": {
                System.out.println("Podaj nazwę firmy:");
                String companyNameGivenValue = scanner.nextLine();
                sql = "UPDATE firmy SET nazwa = '" + companyNameGivenValue + "' WHERE id_firmy = " + chosenIdToUpdate;
                Integer companyNameUptade = statement.executeUpdate(sql);
                System.out.println("POWIADOMIENIE: Uaktualniono firmę o id " + chosenIdToUpdate);
                break;
            }
            case "2": {
                System.out.println("Podaj adres, firmy:");
                System.out.print("ulica: ");
                String street = scanner.nextLine();
                System.out.print("numer domu: ");
                String houseNumber = scanner.nextLine();
                System.out.print("numer mieszkania: ");
                String apartamentNumber = scanner.nextLine();
                sql = "UPDATE firmy SET ulica = '" + street + "', numer_domu = '" + houseNumber + "', numer_mieszkania = '" +
                        apartamentNumber + "' WHERE id_firmy = " + chosenIdToUpdate;
                Integer companyAdressUpdate = statement.executeUpdate(sql);
                System.out.println("POWIADOMIENIE: Uaktualniono firmę o id " + chosenIdToUpdate);
                break;
            }
            case "3": {
                System.out.println("Podaj nazwę firmy:");
                String companyNameGivenValue = scanner.nextLine();
                System.out.println("Podaj adres, firmy:");
                System.out.print("ulica: ");
                String street = scanner.nextLine();
                System.out.print("numer domu: ");
                String houseNumber = scanner.nextLine();
                System.out.print("numer mieszkania: ");
                String apartamentNumber = scanner.nextLine();
                sql = "UPDATE firmy SET nazwa = '" + companyNameGivenValue + "', ulica = '" + street + "', numer_domu = '" + houseNumber + "', numer_mieszkania = '" +
                        apartamentNumber + "' WHERE id_firmy = " + chosenIdToUpdate;
                Integer companyNameAndAdressUptade = statement.executeUpdate(sql);
                System.out.println("POWIADOMIENIE: Uaktualniono firmę o id " + chosenIdToUpdate);
                break;
            }
            case "4": {

            }
        }
        statement.close();
        connection.close();
    }

    @Override
    public void getListOfRows() throws SQLException {
        Statement statement = getStatement();
        sql = "SELECT * FROM firmy";
        ResultSet resultQuerySet = statement.executeQuery(sql);
        while (resultQuerySet.next()) {
            int id = resultQuerySet.getInt("id_firmy");
            String street = resultQuerySet.getString("ulica");
            String houseNumber = resultQuerySet.getString("numer_domu");
            String apartmentNumber = resultQuerySet.getString("numer_mieszkania");
            String companyName = resultQuerySet.getString("nazwa");
            String NIPNumber = resultQuerySet.getString("nip");

            System.out.println("ID firmy: " + id);
            System.out.println("Nazwa firmy: " + companyName);
            System.out.println("Ulica: " + street);
            System.out.println("Numer domu: " + houseNumber);
            System.out.println("Numer mieszkania: " + apartmentNumber);
            System.out.println("NIP: " + NIPNumber);
        }
        resultQuerySet.close();
        statement.close();
        connection.close();
    }
}
