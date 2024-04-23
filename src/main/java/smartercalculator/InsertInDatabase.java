package smartercalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInsert {
    private static final String url = "jdbc:mysql://localhost:3306/laborator";
    private static final String user = "student";
    private static final String pass = "student";

    private Connection conn;
    private static DatabaseInsert instanta;

    public DatabaseInsert() {
        try {
            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseInsert getInstance() {
        if (instanta == null) {
            instanta = new DatabaseInsert();
        }
        return instanta;
    }

    public void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS createTable (" +
                "id INT auto_increment," +
                "result VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (id)" +
                ")";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableSQL);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertResult(CalculationRequest calcRequest, Object res) {
        String insertSQL = "INSERT INTO smarterCalculatorResults (operation_type, left_operand, right_operand, operation, result) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
            preparedStatement.setString(2, res.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}