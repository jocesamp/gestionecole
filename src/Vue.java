import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vue extends JFrame {
	
	/**
	 * Launch the application.
	 */
	panel_main pm = new panel_main();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vue frame = new Vue();
					frame.setBounds(30, 20, 1200, 750);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vue() {
		getContentPane().setLayout(null);
		pm.setBounds(22, 11, 1074, 727);
		getContentPane().add(pm);
		pm.setVisible(true);
	}
}
