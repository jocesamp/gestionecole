import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connect {
	private Statement st;
	private Connection con;
	public Connect() {
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/ecole";
			con=DriverManager.getConnection(url,"root","");
			
			
			st=con.createStatement();
		} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null, "Driver  not found!");
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, " Erreur Connection!"+e);
	}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erreur!\n"+e);
		}
	}

	public Statement getSt() {
		return st;
	}
	public void setSt(Statement st) {
		this.st = st;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
}
