package com.javabyd1.HomeworkApp;

import com.javabyd1.HomeworkApp.TableAdressesOperations.AdressesOperationsImpl;
import com.javabyd1.HomeworkApp.TableCompanyOperations.CompanyOperationsImpl;
import com.javabyd1.HomeworkApp.TableEmployeesOperations.EmployeesOperationsImpl;
import com.javabyd1.HomeworkApp.TableJobOperations.JobOperationsImp;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
    static AdressesOperationsImpl adressesOperations = new AdressesOperationsImpl();
    static EmployeesOperationsImpl employeesOperations = new EmployeesOperationsImpl();
    static CompanyOperationsImpl companyOperations = new CompanyOperationsImpl();
    static JobOperationsImp jobOperations = new JobOperationsImp();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz tabelę z bazy, na której chcesz pracować:");
        System.out.println("1. Adresy");
        System.out.println("2. Pracownicy");
        System.out.println("3. Stanowiska");
        System.out.println("4. Firmy");
        System.out.println("5. Wyjdź");
        String menuChoice = scanner.nextLine();
        System.out.println("");


        switch (menuChoice) {
            case "1": {
                System.out.println("Wybierz działanie:");
                System.out.println("1. Wyświetl wszystkie rekordy.");
                System.out.println("2. Dodaj rekord.");
                System.out.println("3. Usuń rekord o określonym id.");
                System.out.println("4. Zmodyfikuj rekord o określonym id.");
                String adresyMenuChoice = scanner.nextLine();

                switch (adresyMenuChoice) {
                    case "1": {
                        try {
                            adressesOperations.getListOfRows();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "2": {
                        try {
                            adressesOperations.createNewRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "3": {
                        try {
                            adressesOperations.deleteRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    case "4": {
                        try {
                            adressesOperations.updateRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            case "2": {
                System.out.println("Wybierz działanie:");
                System.out.println("1. Wyświetl wszystkie rekordy.");
                System.out.println("2. Dodaj rekord.");
                System.out.println("3. Usuń rekord o określonym id.");
                System.out.println("4. Zmodyfikuj rekord o określonym id.");
                String employersMenuChoice = scanner.nextLine();

                switch (employersMenuChoice) {
                    case "2": {
                        try {
                            employeesOperations.createNewRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "1": {
                        try {
                            employeesOperations.getListOfRows();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "3": {
                        try {
                            employeesOperations.deleteRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    case "4": {
                        try {
                            employeesOperations.updateRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            case "3": {
                System.out.println("Wybierz działanie:");
                System.out.println("1. Wyświetl wszystkie rekordy.");
                System.out.println("2. Dodaj rekord.");
                System.out.println("3. Usuń rekord o określonym id.");
                System.out.println("4. Zmodyfikuj rekord o określonym id.");
                String jobMenuChoice = scanner.nextLine();

                switch (jobMenuChoice){
                    case "1": {
                        jobOperations.createNewRow();
                    }
                    case "2": {
                        jobOperations.getListOfRows();
                    }
                    case "3": {
                        jobOperations.deleteRow();
                    }
                    case "4": {
                        jobOperations.updateRow();
                    }
                }
            }
            case "4": {
                System.out.println("Wybierz działanie:");
                System.out.println("1. Wyświetl wszystkie rekordy.");
                System.out.println("2. Dodaj rekord.");
                System.out.println("3. Usuń rekord o określonym id.");
                System.out.println("4. Zmodyfikuj rekord o określonym id.");
                String companyMenuChoice = scanner.nextLine();

                switch (companyMenuChoice){
                    case "1": {
                        try {
                            companyOperations.createNewRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    case "2": {
                        try {
                            companyOperations.getListOfRows();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    case "3": {
                        try {
                            companyOperations.deleteRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    case "4": {
                        try {
                            companyOperations.updateRow();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            case "5": {
                System.exit(0);
            }
        }
    }
}

