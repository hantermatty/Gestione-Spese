package Storage;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class SingletonDataBase {
	private static Connection con = null;
	private static SingletonDataBase db = new SingletonDataBase();
	public SingletonDataBase(){
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/prog_web";
		String username = "root"; 
		String pwd = "antonio97"; 
		con = (Connection) DriverManager.getConnection(url,username,pwd);
	}
	catch(Exception e)
	{
		System.out.println("Connessione fallita!!");
	}
	}
	
	//il metodo consente di poter ottenere un'istanza unica della classe
	public static SingletonDataBase getInstance() {
		return db;
	}
	
	// il metodo consente di ottenere il drivere per la connessione al DB
	public Connection getConnection() {
		return con;
	}

}
