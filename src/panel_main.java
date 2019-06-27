import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panel_main extends JPanel {

	/**
	 * Create the panel.
	 */
	private DefaultTableModel model = new DefaultTableModel();
	JPanel panelTab;
	JPanel panel_btnProf;
	private JTable table;
	Professeur p = new Professeur();
	Prof pf = new Prof();
	cours cour = new cours();
	private JPanel panel_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton btnQuitter;
	private JButton btnNewButton;
	private JButton btnSuivant;
	public panel_main() {
		setLayout(null);
		
		panel_btnProf = new JPanel();
		panel_btnProf.setLayout(null);
		panel_btnProf.setBounds(48, 480, 975, 55);
		add(panel_btnProf);
		
		btnQuitter = new JButton("QUITTER");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBounds(74, 14, 144, 30);
		panel_btnProf.add(btnQuitter);
		
		btnNewButton = new JButton("ANNULER");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(416, 14, 144, 30);
		panel_btnProf.add(btnNewButton);
		
		btnSuivant = new JButton("SUIVANT");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pf.setVisible(false);
				panel_btnProf.setVisible(false);
				cour.setBounds(108, 11, 946, 467);
				p.classe(cour.comboClasse,pf.id);
				add(cour);
				cour.setVisible(true);
				panel_1.setVisible(true);
			}
		});
		btnSuivant.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSuivant.setBounds(760, 14, 144, 29);
		panel_btnProf.add(btnSuivant);

		pf.setBounds(0, 11, 1102, 433);
		add(pf);
		pf.setVisible(true);
		
		panelTab = new JPanel();
		panelTab.setBounds(48, 551, 978, 208);
		add(panelTab);
		panelTab.setLayout(null);
		panelTab.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 941, 192);
		panelTab.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = table.getSelectedRow();
				JOptionPane.showMessageDialog(null,""+ligne);
				pf.selection(ligne);
//				btnModifier.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		
		model.addColumn("CODE");
		model.addColumn("NOM");
		model.addColumn("PRENOM");
		model.addColumn("SEXE");
		model.addColumn("SECTION");
		model.addColumn("NIVEAU");
		model.addColumn("EMAIL");
		model.addColumn("TELEPHONE");
		model.addColumn("ADRESSE");
		model.addColumn("NIF");
		model.addColumn("DATE NAISSANCE");
		model.addColumn("CLASSE");
		model.addColumn("MATIERE");
		model.addColumn("HEURE");
		model.addColumn("PRIX");
		model.addColumn("VACATION");
		
		p.lister(table,model);
		
		panel_1 = new JPanel();
		panel_1.setBounds(764, 57, 277, 400);
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		button = new JButton("Enregistrer");
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(53, 31, 175, 29);
		panel_1.add(button);
		
		button_1 = new JButton("Modifier");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(53, 115, 175, 29);
		panel_1.add(button_1);
		
		button_2 = new JButton("Annuler");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(53, 197, 175, 29);
		panel_1.add(button_2);
		
		button_3 = new JButton("RETOUR");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(53, 278, 175, 29);
		panel_1.add(button_3);
		
		button_4 = new JButton("Quitter");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_4.setBounds(53, 360, 175, 29);
		panel_1.add(button_4);
	}
	
}
