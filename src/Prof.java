import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Prof extends JPanel {
	
	private JPanel contentPane;
	 JTextField textNom;
	private JTextField textPrenom;
	private JDateChooser textDNais;
	private JTextField textNif;
	
	private JComboBox comboSexe;
	public JComboBox comboSection;
	private JTextField textEmail;
	private JTextField texttel;
	private JPanel panel_info;
	private JTextField textAdresse;
	private JTextField textNiv;
	private JButton btnModifier;
	private DefaultTableModel model = new DefaultTableModel();
	Professeur p = new Professeur();
	cours cour = new cours();
	public int id;
	
	private String code = null;
	

	/**
	 * Create the panel.
	 */
	public Prof() {
		
       setLayout(null);
		
		panel_info = new JPanel();
		panel_info.setBounds(108, 11, 978, 460);
		add(panel_info);
		panel_info.setLayout(null);
		
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sp = new SimpleDateFormat("MMM d,yyyy");
				String dat = sp.format(textDNais.getDate());

				Professeur prof = new Professeur(textNom.getText(), textPrenom.getText(), comboSexe.getSelectedItem().toString(), textAdresse.getText(),
						dat, Integer.valueOf(textNif.getText()), textNiv.getText(), comboSection.getSelectedItem().toString(),
						Integer.valueOf(texttel.getText()),textEmail.getText());
				prof.enregistrer();
				model.setRowCount(0);
//				prof.lister(table,model);
				panel_info.setVisible(false);
				cour.setBounds(108, 11, 946, 467);
				p.classe(cour.comboClasse,id);
				add(cour);
			}
		});
		btnContinuer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnContinuer.setBounds(624, 424, 155, 32);
		panel_info.add(btnContinuer);
		
		JLabel label_1 = new JLabel("Section");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(533, 202, 144, 23);
		panel_info.add(label_1);
		
		comboSection = new JComboBox();
		comboSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id=comboSection.getSelectedIndex()+1;
				if(comboSection.getSelectedItem().equals("Kindergarten")) {
					cour.comboVaca.removeAllItems();
					cour.comboVaca.addItem("Matin");
					
				}
				else{
					cour.comboVaca.removeAllItems();
					cour.comboVaca.setModel(new DefaultComboBoxModel(new String[] {"Matin", "Median", "Soir",}));
				}
			}
		});
		p.sect(comboSection);
		comboSection.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboSection.setBounds(780, 204, 164, 23);
		panel_info.add(comboSection);
		
		textNif = new JTextField();
		textNif.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				isNumerique(k);
			}
		});
		textNif.setBounds(238, 202, 165, 23);
		panel_info.add(textNif);
		textNif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNif.setColumns(10);
		
		textDNais = new JDateChooser();
		textDNais.setBounds(780, 141, 164, 23);
		panel_info.add(textDNais);
		textDNais.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		textDNais.setColumns(10);
		
		JLabel lblNif = new JLabel("NIF");
		lblNif.setBounds(10, 202, 126, 23);
		panel_info.add(lblNif);
		lblNif.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDateNaissance = new JLabel("Date Naissance");
		lblDateNaissance.setBounds(533, 140, 144, 23);
		panel_info.add(lblDateNaissance);
		lblDateNaissance.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboSexe = new JComboBox();
		comboSexe.setBounds(238, 140, 165, 23);
		panel_info.add(comboSexe);
		comboSexe.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboSexe.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "Feminin"}));
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(10, 139, 126, 23);
		panel_info.add(lblSexe);
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textPrenom = new JTextField();
		textPrenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				isNotNumerique(k);
			}
		});
		textPrenom.setBounds(780, 81, 164, 23);
		panel_info.add(textPrenom);
		textPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenom.setColumns(10);
		
		textNom = new JTextField();
		textNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				isNotNumerique(k);
			}
		});
		textNom.setBounds(238, 81, 165, 23);
		panel_info.add(textNom);
		textNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(533, 80, 144, 23);
		panel_info.add(lblPrenom);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 82, 126, 23);
		panel_info.add(lblNom);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuitter.setBounds(34, 425, 144, 31);
		panel_info.add(btnQuitter);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(780, 281, 164, 23);
		panel_info.add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(533, 281, 144, 23);
		panel_info.add(lblEmail);
		
		texttel = new JTextField();
		texttel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		texttel.setColumns(10);
		texttel.setBounds(238, 359, 165, 23);
		panel_info.add(texttel);
		
		JLabel label_5 = new JLabel("Telephone");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 359, 126, 23);
		panel_info.add(label_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(355, 61, 1, 2);
		panel_info.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 61, 944, 33);
		panel_info.add(separator_1);
		
		JLabel lblInformationPersonnel = new JLabel("INFORMATION PERSONNEL");
		lblInformationPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformationPersonnel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblInformationPersonnel.setBounds(252, 11, 443, 39);
		panel_info.add(lblInformationPersonnel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdresse.setBounds(10, 281, 126, 23);
		panel_info.add(lblAdresse);
		
		textAdresse = new JTextField();
		textAdresse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAdresse.setColumns(10);
		textAdresse.setBounds(238, 278, 165, 23);
		panel_info.add(textAdresse);
		
		JLabel label_2 = new JLabel("Niveau");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(533, 359, 126, 23);
		panel_info.add(label_2);
		
		textNiv = new JTextField();
		textNiv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				isNotNumerique(ke);
			}
		});
		textNiv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNiv.setColumns(10);
		textNiv.setBounds(779, 359, 165, 23);
		panel_info.add(textNiv);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
				String dat = sp.format(textDNais.getDate());
				Professeur prof = new Professeur(textNom.getText(), textPrenom.getText(), comboSexe.getSelectedItem().toString(), textAdresse.getText(),
						dat, Integer.valueOf(textNif.getText()), textNiv.getText(), comboSection.getSelectedItem().toString(),
						Integer.valueOf(texttel.getText()),textEmail.getText());
				prof.modifier(code);
				model.setRowCount(0);
//				prof.lister(table_1,model);
			}
		});
		btnModifier.setEnabled(false);
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModifier.setBounds(447, 424, 144, 32);
		panel_info.add(btnModifier);
		
		JButton btnAnnuler = new JButton("ANNULER");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				netoyer();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnnuler.setBounds(234, 427, 155, 30);
		panel_info.add(btnAnnuler);
		
		JButton btnSuivant = new JButton("SUIVANT");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_info.setVisible(false);
				cour.setBounds(108, 11, 946, 467);
				p.classe(cour.comboClasse,id);
				add(cour);
				cour.setVisible(true);
			}
		});
		btnSuivant.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSuivant.setBounds(824, 424, 126, 30);
		panel_info.add(btnSuivant);
	
	}
	
	public void isNotNumerique(KeyEvent ke) {
		char c = ke.getKeyChar();
		if(Character.isDigit(c)) {
			ke.consume();
			getToolkit().beep();
		}
		
	}
	
	public void isNumerique(KeyEvent ke) {
		char c = ke.getKeyChar();
		if(!Character.isDigit(c)) {
			ke.consume();
			getToolkit().beep();
		}
		
	}
	
	public void selection(int ligne) {
		try {
			 code = model.getValueAt(ligne, 0).toString();
			 textNom.setText(model.getValueAt(ligne, 1).toString());
			 textPrenom.setText(model.getValueAt(ligne, 2).toString());
			 comboSexe.setSelectedItem(model.getValueAt(ligne, 3));
			 comboSection.setSelectedItem(model.getValueAt(ligne, 4));
			 textNiv.setText(model.getValueAt(ligne, 5).toString());
			 textEmail.setText(model.getValueAt(ligne, 6).toString());
			 texttel.setText(model.getValueAt(ligne, 7).toString());
			 textAdresse.setText(model.getValueAt(ligne, 8).toString());
			 textNif.setText(model.getValueAt(ligne, 9).toString());
			 String d = model.getValueAt(ligne, 10).toString();
			 SimpleDateFormat sp = new SimpleDateFormat("MMM d,yyyy");
			 Date da = sp.parse(d);
			 textDNais.setDate(da);
			 cour.comboClasse.setSelectedItem(model.getValueAt(ligne, 11));
			 cour.comboCours.setSelectedItem(model.getValueAt(ligne, 12));
			 cour.comboHeure.setSelectedItem(model.getValueAt(ligne, 13));
			 cour.textPrix.setText(model.getValueAt(ligne, 14).toString());
			 cour.comboVaca.setSelectedItem(model.getValueAt(ligne, 15));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreue"+e);
		}
	}
	public void netoyer() {
		textNom.setText(null);
		textNiv.setText(null);
		textPrenom.setText(null);
		textEmail.setText(null);
		texttel.setText(null);
		textAdresse.setText(null);
		textNif.setText(null);
		comboSection.setSelectedIndex(0);
		comboSexe.setSelectedIndex(0);
	}
}
