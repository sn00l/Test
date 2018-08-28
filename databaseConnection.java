import java.sql.*;
import javax.swing.*;

public class databaseConnection {
	public static void main(String[] args) {

	}

	Connection dbConnection = null;

	public static Connection dataConnection() {
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create a variable for the connection string.
			Connection dbConnection = DriverManager.getConnection(
					"jdbc:sqlserver://;servername=localhost;integratedSecurity=true;" + "databaseName=NORTHWND");
			JOptionPane.showMessageDialog(null, "Connection to the database successful");
			return dbConnection;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}

	}
}
