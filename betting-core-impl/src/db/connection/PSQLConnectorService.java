package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PSQLConnectorService {

	public Connection createConnection() {

		String user = "michl";
		String password = "michl";
		try {
			String url = "jdbc:postgresql://localhost:5432/betting_db?currentSchema=public";
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) {
		PSQLConnectorService psqlConnectorService = new PSQLConnectorService();
		psqlConnectorService.createConnection();
	}

}
