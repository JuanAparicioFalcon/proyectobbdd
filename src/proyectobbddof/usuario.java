package proyectobbddof;

import java.sql.*;
import Conexionbbdd.ConexionMysql;

public class usuario {
	
	private String Usuario;
	private String Contraseña;
	private String DNI;
	private String Email;


public usuario(String Usuario, String Contraseña, String DNI, String Email) {
	this.setUsername(Usuario);
	this.setContraseña(Contraseña);
	this.setDNI(DNI);
	this.setEmail(Email);
}


public String getContraseña() {
	return Contraseña;
}


public void setContraseña(String Contraseña) {
	this.Contraseña = Contraseña;
}


public String getUsuario() {
	return Usuario;
}


public void setUsername(String Usuario) {
	this.Usuario = Usuario;
}

public String getDNI() {
	return DNI;
}


public void setDNI(String DNI) {
	this.DNI = DNI;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}

/*METODO LOGIN */
public static boolean login(String Usuario, String Contraseña) {
	ConexionMysql conexion = new ConexionMysql("root","test","login_proyecto");
	try {
		conexion.conectar();
		String consulta = "SELECT * FROM Usuarios WHERE Usuario="+Usuario+;
		ResultSet resultado = conexion.ejecutarSelect(consulta);
		} catch (SQLException e) {
		System.out.println("Error al intentar login: " + e.getMessage());
		return false;
		} finally {
			try {
				conexion.desconectar();
			} catch (SQLException e){
				System.out.println("Error al intentar login: " + e.getMessage());
			}
			
	
	}
}

/*METODO registrar */
public static boolean registrar(String Usuario, String Contraseña, String DNI, String Email) {
	Connection connection = ConexionMysql.conectar();
	if(connection !=null) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Usuarios (Usuario, Contraseña, DNI, Email) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1,Usuario);
			preparedStatement.setString(2,Contraseña);
			preparedStatement.setString(3,DNI);
			preparedStatement.setString(2,Email);
			
			int result = preparedStatement.executeUpdate();
			connection.close();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error al crear el Usuario " + e.getMessage());
			return false;
			}
	}
	return false;
}



}