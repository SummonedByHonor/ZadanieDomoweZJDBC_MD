package com.javabyd1.HomeworkApp.TableAdressesOperations;

import com.javabyd1.HomeworkApp.Database.Database;
import com.javabyd1.HomeworkApp.TableOperationsInterface.TableOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdressesOperationsImpl implements TableOperations {

    private Scanner scanner = new Scanner(System.in);
    String sql = null;
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
        System.out.println("Podaj id adresu:");
        Integer adressId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj ulicę:");
        String streetGivenValue = scanner.nextLine();
        System.out.println("Podaj numer domu:");
        String houseNumberGivenValue = scanner.nextLine();
        System.out.println("Podaj numer mieszkania:");
        String apartmentNumberGivenValue = scanner.nextLine();
        System.out.println("Podaj kod pocztowy:");
        String postalCodeGivenValue = scanner.nextLine();
        System.out.println("Podaj nazwę miasta:");
        String cityGivenValue = scanner.nextLine();
        System.out.println("Podaj nazwę województwa:");
        String vovoidshipGivenValue = scanner.nextLine();

        sql = "INSERT INTO adresy (id_adresu, ulica, numer_domu, numer_mieszkania, kod_pocztowy, miasto, wojewodztwo)" + " VALUES (" + adressId + ", '" + streetGivenValue + "', '" +
                houseNumberGivenValue + "', '" + apartmentNumberGivenValue + "', '" + postalCodeGivenValue + "', '" + cityGivenValue + "', '" + vovoidshipGivenValue + "')";

        int queryResult = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        System.out.println("Dodano rekord o id " + adressId + " do bazy");
    }

    @Override
    public void deleteRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("Podaj id rekordu, który chcesz usunąć: ");
        Integer choosenIdToDelete = scanner.nextInt();
        sql = "DELETE FROM adresy WHERE id_adresu = '" + choosenIdToDelete + "'";
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
        System.out.println("1. Aktualizacja całego adresu.");
        System.out.println("2. Aktualizacja adresu zamieszkania bez zmiany miasta i województwa.");
        String choosenOptionOfUpdate = scanner.nextLine();
        boolean flag = false;
        switch (choosenOptionOfUpdate) {
            case "1": {
                System.out.println("Podaj ulicę:");
                String streetGivenValue = scanner.nextLine();
                System.out.println("Podaj numer domu:");
                String houseNumberGivenValue = scanner.nextLine();
                System.out.println("Podaj numer mieszkania:");
                String apartmentNumberGivenValue = scanner.nextLine();
                System.out.println("Podaj kod pocztowy:");
                String postalCodeGivenValue = scanner.nextLine();
                System.out.println("Podaj nazwę miasta:");
                String cityGivenValue = scanner.nextLine();
                System.out.println("Podaj nazwę województwa:");
                String vovoidshipGivenValue = scanner.nextLine();
                sql = "UPDATE adresy SET ulica = '" + streetGivenValue + "', numer_domu = '" + houseNumberGivenValue + "', numer_mieszkania = '" +
                        apartmentNumberGivenValue + "', kod_pocztowy = '" + postalCodeGivenValue + "', miasto = '" + cityGivenValue +
                        "', wojewodztwo = '" + vovoidshipGivenValue + "'" + "WHERE id_adresu = '" + chosenIdToUpdate + "'";
                Integer update = statement.executeUpdate(sql);
                System.out.println("POWIADOMIENIE: Uaktualniono adres o id " + chosenIdToUpdate);
                statement.close();
                connection.close();
            }
            case "2": {
                System.out.println("Podaj ulicę:");
                String streetGivenValue = scanner.nextLine();
                System.out.println("Podaj numer domu:");
                String houseNumberGivenValue = scanner.nextLine();
                System.out.println("Podaj numer mieszkania:");
                String apartmentNumberGivenValue = scanner.nextLine();
                System.out.println("Podaj kod pocztowy:");
                String postalCodeGivenValue = scanner.nextLine();
                sql = "UPDATE adresy SET ulica = '" + streetGivenValue + "' numer_domu = '" + houseNumberGivenValue + "', numer_mieszkania = '" +
                        apartmentNumberGivenValue + "', kod_pocztowy = '" + postalCodeGivenValue + "' WHERE id_adresu = '" +
                        chosenIdToUpdate + "'";
                Integer uptade = statement.executeUpdate(sql);
                System.out.println("POWIADOMIENIE: Uaktualniono adres o id " + chosenIdToUpdate);
                statement.close();
                connection.close();
            }
        }

    }

    @Override
    public void getListOfRows() throws SQLException {
        Statement statement = getStatement();
        sql = "SELECT * FROM adresy";
        ResultSet resultQuerySet = statement.executeQuery(sql);
        while (resultQuerySet.next()) {
            int id = resultQuerySet.getInt("id_adresu");
            String street = resultQuerySet.getString("ulica");
            String postalCode = resultQuerySet.getString("kod_pocztowy");
            String houseNumber = resultQuerySet.getString("numer_domu");
            String apartmentNumber = resultQuerySet.getString("numer_mieszkania");
            String city = resultQuerySet.getString("miasto");
            String vovoidship = resultQuerySet.getString("wojewodztwo");

            System.out.println("ID: " + id);
            System.out.println("Ulica: " + street);
            System.out.println("Kod pocztowy: " + postalCode);
            System.out.println("Numer domu: " + houseNumber);
            System.out.println("Numer mieszkania: " + apartmentNumber);
            System.out.println("Miasto: " + city);
            System.out.println("Województwo: " + vovoidship);
            System.out.println("");
        }
        resultQuerySet.close();
        statement.close();
        connection.close();
    }
}
