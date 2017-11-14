package com.javabyd1.HomeworkApp.TableOperationsInterface;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface TableOperations {


    public void createNewRow() throws SQLException;

    public void deleteRow() throws SQLException;

    public void updateRow() throws SQLException;

    public void getListOfRows() throws SQLException;
}
