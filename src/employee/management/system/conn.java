package employee.management.system;

import java.sql.*;

public class conn {
    public Connection c;
    public Statement statement;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Roorshi@221#");
            statement = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
