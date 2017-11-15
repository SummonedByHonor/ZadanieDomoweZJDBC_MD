package com.javabyd1.HomeworkApp.TableEmployeesOperations;

import com.javabyd1.HomeworkApp.Database.Database;
import com.javabyd1.HomeworkApp.TableOperationsInterface.TableOperations;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("DODAJ ADRES:");
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

        ResultSet resultSet = statement.executeQuery(sql);

    }

    @Override
    public void deleteRow() {

    }

    @Override
    public void updateRow() {

    }

    @Override
    public void getListOfRows() {

    }
}
