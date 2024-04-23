package smartercalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEntriesByOperationType {
    public static void deleteEntriesByOperationType(String operationType) {

        String url = "jdbc:mysql://localhost:3306/nume_baza_date";
        String username = "username";
        String password = "parola";

        // Declarațiile SQL pentru ștergerea intrărilor
        String deleteQuery = "DELETE FROM smarterCalculatorResults WHERE operation_type = ?";

        try (
                // Crearea conexiunii
                Connection connection = DriverManager.getConnection(url, username, password);
                // Crearea instrucțiunii pregătite
                PreparedStatement statement = connection.prepareStatement(deleteQuery)
        ) {
            // Setarea parametrului pentru tipul de operație
            statement.setString(1, operationType);

            // Executarea instrucțiunii SQL de ștergere
            int rowsAffected = statement.executeUpdate();
            System.out.println("Numărul de intrări șterse: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Eroare la ștergerea intrărilor: " + e.getMessage());
        }
    }
}
