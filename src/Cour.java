import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cour {
	private String nom;
	private int classe;
	private int prof;
	private int hr;
	private int prix;
	private String vaca;

	private Connect ct;
	private Statement st;
	private ResultSet rs,rs1,rs2;
	
	public Cour() {

	}

	public Cour(String nom, int classe, int prof, int hr, int prix, String vaca) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.prof = prof;
		this.hr = hr;
		this.prix = prix;
		this.vaca = vaca;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public String getVaca() {
		return vaca;
	}

	public void setVaca(String vaca) {
		this.vaca = vaca;
	}
	
	public void enregistrer() {
		String insertion = "insert into cours values(?,?,?,?,?,?,?)";
		try {
			ct=new Connect();
			st=ct.getSt();
			PreparedStatement prepare =ct.getCon().prepareStatement(insertion);
			prepare.setString(1, null);
			prepare.setString(2, this.getNom());
			prepare.setInt(3, this.getClasse());
			prepare.setInt(4, this.getProf());
			prepare.setInt(5, this.getHr());
			prepare.setInt(6, this.getPrix());
			prepare.setString(7, getVaca());
			
			prepare.execute();
			prepare.close();
			JOptionPane.showMessageDialog(null,"Succes");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erreur Sql!"+ex);
		}
	}
	
	public int lastIdProf() {
		ct=new Connect();
		st=ct.getSt();
		int id=0;
		String req="Select id from prof";
		try {
			rs = st.executeQuery(req);
			while(rs.next()) {
			  id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public int idClasse(String classe) {
		int id=0;
		String req="Select id from classe where nom="+classe;
		try {
			ct=new Connect();
			st=ct.getSt();
			rs1 = st.executeQuery(req);
			while(rs1.next()) {
			  id = rs1.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public void modifier(String code) {
		String req = "update cours set nom=?,id_classe=?,id_prof=?,heure=?,prix=? WHERE code=?";
		try {
			ct=new Connect();
			st=ct.getSt();
			PreparedStatement prepare =ct.getCon().prepareStatement(req);
			
			prepare.setString(1, this.getNom());
			prepare.setInt(2, this.getClasse());
			prepare.setInt(3, this.getProf());
			prepare.setInt(4, this.getHr());
			prepare.setInt(5, this.getPrix());
			prepare.setString(6, getVaca());
			
			prepare.execute();
			prepare.close();
			JOptionPane.showMessageDialog(null,"Succes");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erreur Sql!"+ex);
//	
		}
	}
	
}
