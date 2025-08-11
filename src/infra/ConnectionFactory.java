package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
private static final String URL = "jdbc:mysql://localhost:3306/banco?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
private static final String USER = "usuario";
private static final String PASS = "senha";

private ConnectionFactory() {
	// Private constructor to prevent instantiation
}
public static Connection getConnection() throws SQLException {
	
	return DriverManager.getConnection(URL, USER, PASS);}
}
