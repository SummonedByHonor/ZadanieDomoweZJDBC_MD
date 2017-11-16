package com.javabyd1.HomeworkApp.TableEmployeesOperations;

import com.javabyd1.HomeworkApp.Database.Database;
import com.javabyd1.HomeworkApp.TableOperationsInterface.TableOperations;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.J;

public class EmployeesOperationsImpl implements TableOperations {
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
        System.out.println("DODAJ PRACOWNIKA:");
        System.out.println("Podaj id nowego pracownika:");
        Integer newEmployerId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj imię nowego pracownika:");
        String newEmployerNameGivenValue = scanner.nextLine();
        System.out.println("Podaj nazwisko nowego pracownika:");
        String newEmployerLastname = scanner.nextLine();
        System.out.println("Podaj kolor oczu nowego pracownika:");
        String newEmployerEyeColorGivenValue = scanner.nextLine();
        System.out.println("Podaj wzrost nowego pracownika:");
        String newEmployerHeightGivenValue = scanner.nextLine();
        System.out.println("Podaj płeć nowego pracownika:");
        scannerChar.useDelimiter("");
        String newEmployerSesGivenValue = scannerChar.nextLine();
        System.out.println("Podaj datę urodzin nowego pracownika (format DD-MM-YYYY:");
        Date dateOfBirthGivenValue = Date.valueOf(scanner.nextLine());
        System.out.println("Podaj telefon kontaktowy:");
        String telephoneNumberGivenValue = scanner.nextLine();
        System.out.println("Podaj mail nowego pracownika:");
        String emailGivenValue = scanner.nextLine();
        System.out.println("Podaj numer PESEL nowego pracownika:");
        String PESELnumber = scanner.nextLine();
        System.out.println("Podaj wynagrodzenie nowego pracownika:");
        Integer newEmployerSalary = scanner.nextInt();
        System.out.println("Podaj id stanowiska nowego pracownika:");
        Integer newEmployerJobId = scanner.nextInt();
        System.out.println("Podaj id firmy nowego pracownika:");
        Integer newEmployerCompanyId = scanner.nextInt();

        sql = "INSERT INTO pracownicy (id_pracownika, imie, nazwisko, kolor_oczu, wzrost, plec, telefon, " +
                "email, PESEL, data_urodzin, id_stanowiska, wynagrodzenie, id_firmy) VALUES (" +
                newEmployerId + ", '" + newEmployerNameGivenValue + "', '" + newEmployerLastname + "', '" +
                newEmployerEyeColorGivenValue + "', " + newEmployerHeightGivenValue + ", '" +
                newEmployerSesGivenValue + "', '" + telephoneNumberGivenValue + "', '" + emailGivenValue + "', '" +
                PESELnumber + "', " + dateOfBirthGivenValue + ", " + newEmployerJobId + ", " + newEmployerSalary +
                ", " + newEmployerCompanyId + ")";

        Integer newRecord = statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    @Override
    public void deleteRow() throws SQLException {
        Statement statement = getStatement();
        System.out.println("Podaj id rekordu, który chcesz usunąć: ");
        Integer choosenIdToDelete = scanner.nextInt();
        sql = "DELETE FROM pracownicy WHERE id_pracownika = '" + choosenIdToDelete + "'";
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
        System.out.println("Podaj nowy numer telefonu:");
        String updatedTelephoneNumber = scanner.nextLine();
        System.out.println("Podaj nowy adres email:");
        String updatedEmailAdress = scanner.nextLine();
        System.out.println("Podaj wynagrodzenie:");
        Integer updatedSalaryValue = scanner.nextInt();
        sql = "UPDATE pracownicy SET telefon = '" + updatedTelephoneNumber + "', email = '" + updatedEmailAdress +
                "', wynagrodzenie = " + updatedSalaryValue;
        Integer employerUpdate = statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    @Override
    public void getListOfRows() throws SQLException {
        Statement statement = getStatement();
        sql = "SELECT * FROM pracownicy";
        ResultSet resultQuerySet = statement.executeQuery(sql);
        while (resultQuerySet.next()) {
            int id = resultQuerySet.getInt("id_pracownika");
            String name = resultQuerySet.getString("imie");
            String lastName = resultQuerySet.getString("nazwisko");
            String eyeColor = resultQuerySet.getString("kolor_oczu");
            Integer height = resultQuerySet.getInt("wzrost");
            String sex = resultQuerySet.getString("plec");
            String telephoneNumber = resultQuerySet.getString("telefon");
            String email = resultQuerySet.getString("email");
            String PESELNumber = resultQuerySet.getString("PESEL");
            Integer salary = resultQuerySet.getInt("wynagrodzenie");

            System.out.println("ID pracownika: " + id);
            System.out.println("Imię: " + name);
            System.out.println("Nazwisko: " + lastName);
            System.out.println("Kolor oczu: " + eyeColor);
            System.out.println("Wzrost: " + height);
            System.out.println("Płeć: " + sex);
            System.out.println("Numer telefonu: " + telephoneNumber);
            System.out.println("Adres email: " + email);
            System.out.println("Numer PESEL: " + PESELNumber);
            System.out.println("Aktualne wynagrodzenie pracownika: " + salary);
            System.out.println("");
        }
        resultQuerySet.close();
        statement.close();
        connection.close();
    }
}
