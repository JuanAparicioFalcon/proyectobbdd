package proyectobbddof;

import java.sql.*;
import Conexionbbdd.ConexionMysql;

public class usuario {
	
	private String username;
	private String password;


public usuario(String username, String password) {
	this.setUsername(username);
	this.setPassword(password);
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}

public static boolean login(String username, String password) {
	Connection connection = ConexionMysql.conectar();
	if(connection !=null) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Usuarios WHERE username =? AND password =?");
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
		
			ResultSet resultSet = preparedStatement.executeQuery();
			boolean hasUser = resultSet.next();
			connection.close();
			return hasUser;
		} catch (SQLException e) {
		System.out.println("Error al intentar login: " + e.getMessage());
		return false;
		}
	}
}

public static boolean insert(String username, String password) {
	Connection connection = ConexionMysql.conectar();
	if(connection !=null) {
		try {
			PreparedStatement PreparedStatement = connection.prepareStatement("INSERT INTO Usuarios (username, password) VALUES (?, ?)");
			PreparedStatement.setString(1,username);
			PreparedStatement.setString(2,password);
			
			ResultSet result = PreparedStatement.executeUpdate();
			connection.close();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error al intentar login: " + e.getMessage());
			return false;
			}
	}
}
}