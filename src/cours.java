import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;

public class cours extends JPanel {

	/**
	 * Create the panel.
	 */
	public TextField textPrix;
	public JComboBox comboHeure;
	public JComboBox comboCours;

	private Professeur p = new Professeur();
	Cour c = new Cour();
	
	public JComboBox comboClasse;
	public JComboBox comboVaca;
	public cours() {
		setLayout(null);
		
		JLabel lblCours = new JLabel("Cours");
		lblCours.setBounds(10, 252, 46, 14);
		add(lblCours);
		
		JLabel lblVacation = new JLabel("Vacation");
		lblVacation.setBounds(10, 86, 46, 14);
		add(lblVacation);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(10, 170, 46, 14);
		add(lblClasse);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(10, 334, 46, 14);
		add(lblHeure);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(10, 421, 46, 14);
		add(lblPrix);
		
		comboCours = new JComboBox();
		comboCours.setModel(new DefaultComboBoxModel(new String[] {"Math", "Francais", "Science", "Biologie"}));
		comboCours.setBounds(139, 249, 175, 20);
		add(comboCours);
		
		comboClasse = new JComboBox();
		comboClasse.setBounds(139, 167, 175, 20);
		add(comboClasse);
		
		comboVaca = new JComboBox();
//		comboVaca.setModel(new DefaultComboBoxModel(new String[] {"Matin", "Median", "Soir",}));
		comboVaca.setBounds(139, 83, 175, 20);
		add(comboVaca);
		
		comboHeure = new JComboBox();
		comboHeure.setModel(new DefaultComboBoxModel(new String[] {"1h", "2h", "3h", "4h"}));
		comboHeure.setBounds(139, 331, 175, 20);
		add(comboHeure);
		
		textPrix = new TextField();
		textPrix.setBounds(146, 413, 168, 22);
		add(textPrix);

	}
}
