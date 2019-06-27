
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;



public class Professeur {
	private String nom;
	private String prenom;
	private String sexe;
	private String adresse;
	private String dateNais;
	private int nif;
	private String niveau;
	private String section;
	private String code;
	private int tel;
	private String email;
	private DefaultTableModel model = new DefaultTableModel();

	static int tabid[]=new int[20];
	
	private Connect c=new Connect();
	private Statement st;
	private ResultSet rs,rs1,rs2;
	
	public Professeur() {
		
	}

	

	public Professeur(String nom, String prenom, String sexe, String adresse, String dateNais, int nif,
			String niveau, String section, int tel,String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.adresse = adresse;
		this.dateNais = dateNais;
		this.nif = nif;
		this.niveau = niveau;
		this.section = section;
		this.tel = tel;
		this.email = email;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateNais() {
		return dateNais;
	}

	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void enregistrer() {
		String insertion = "insert into prof values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			st=c.getSt();
			PreparedStatement prepare =c.getCon().prepareStatement(insertion);
			prepare.setString(1, null);
			prepare.setString(2, getCodeProf());
			prepare.setInt(3, this.getNif());
			prepare.setString(4, this.getDateNais());
			prepare.setString(5, this.getNom());
			prepare.setString(6, this.getPrenom());
			prepare.setString(7, this.getSexe());
			prepare.setString(8, this.getAdresse());
			prepare.setString(9, this.getSection());
			prepare.setString(10, this.getEmail());
			prepare.setInt(11, this.getTel());
			prepare.setString(12, this.getNiveau());
			
			
			prepare.execute();
			prepare.close();
			JOptionPane.showMessageDialog(null,"Succes");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erreur Sql!"+ex);
		}
	}
	
	public String getCodeProf() {
		st=c.getSt();
		int n=0;
		String req="Select count(*) from prof";
		String codep=null;
		try {
			rs = st.executeQuery(req);
			int i=0;
			while(rs.next()) {
			  n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n<10)
			codep="prof-00"+n;
		else if(n>=10 && n<100)
			codep="prof-0"+n;
		else
			codep="prof-"+n;
		 return codep;
	}
	
	public void lister(JTable table,DefaultTableModel mod) {
		st=c.getSt();
		String req = "select * from prof,cours,classe where cours.id_classe = classe.id AND cours.id_prof = prof.id";
		try {
			rs =st.executeQuery(req);
			
			while(rs.next()) {
				mod.addRow(new Object[] {
						rs.getString("code"),rs.getString("prof.nom"),rs.getString("prenom"),rs.getString("sexe"),rs.getString("section"),rs.getString("niveau"),
						rs.getString("email"),rs.getString("telephone"),rs.getString("adresse"),rs.getString("nif"),rs.getString("datenais"),rs.getString("classe.nom"),
						rs.getString("cours.nom"),rs.getString("cours.heure")+"h",rs.getString("cours.prix")+"$HT",rs.getString("cours.vacation")
				});
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erreur Sql!"+ex);
//			e.printStackTrace();
		}
		table.setModel(mod);
	}
	
	public void modifier(String code) {
		st=c.getSt();
		String req = "update prof set nom=?,prenom=?,sexe=?,section=?,niveau=?,email=?,telephone=?,adresse=?,nif=?,datenais=? WHERE code=?";
		try {
			PreparedStatement prepare =c.getCon().prepareStatement(req);
			
			prepare.setInt(9, this.getNif());
			prepare.setString(10, this.getDateNais());
			prepare.setString(1, this.getNom());
			prepare.setString(2, this.getPrenom());
			prepare.setString(3, this.getSexe());
			prepare.setString(8, this.getAdresse());
			prepare.setString(4, this.getSection());
			prepare.setString(6, this.getEmail());
			prepare.setInt(7, this.getTel());
			prepare.setString(5, this.getNiveau());
			prepare.setString(11, code);
			
			
			prepare.execute();
			prepare.close();
			JOptionPane.showMessageDialog(null,"Succes");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erreur Sql!"+ex);
//	
		}
	}
	
	public void sect(JComboBox combo) {
		st=c.getSt();
		String req="Select * from section";
		try {
			rs1 = st.executeQuery(req);
			while(rs1.next()) {
				 combo.addItem(rs1.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void classe(JComboBox combo,int id) {
		st=c.getSt();
		String req="Select * from classe where id_section="+id;
		try {
			int i=0;
			rs = st.executeQuery(req);
			while(rs.next()) {
				combo.addItem(rs.getString(2));
				tabid[i]=rs.getInt(1);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
