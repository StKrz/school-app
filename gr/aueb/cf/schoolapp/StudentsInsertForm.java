package gr.aueb.cf.schoolapp;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudentsInsertForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField lastnameTxt;
	private JTextField firstnameTxt;
	

	public StudentsInsertForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			firstnameTxt.setText("");
			lastnameTxt.setText("");
		}
	}); 
		
		setTitle("Εισαγωγή Μαθητή");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(128, 128, 128)));
		panel.setBounds(24, 11, 325, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel firstnameLbl = new JLabel("Όνομα");
		firstnameLbl.setForeground(new Color(128, 0, 0));
		firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl.setBounds(49, 37, 53, 20);
		panel.add(firstnameLbl);
		
		JLabel lastnameLbl = new JLabel("Επώνυμο");
		lastnameLbl.setForeground(new Color(128, 0, 0));
		lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastnameLbl.setBounds(36, 84, 66, 20);
		panel.add(lastnameLbl);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setBounds(112, 84, 143, 20);
		panel.add(lastnameTxt);
		lastnameTxt.setColumns(10);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setColumns(10);
		firstnameTxt.setBounds(112, 37, 143, 20);
		panel.add(firstnameTxt);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getStudentsSearchForm().setEnabled(true);
				Main.getStudentsInsertForm().setVisible(false);
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeBtn.setForeground(new Color(0, 0, 255));
		closeBtn.setBounds(239, 199, 110, 43);
		contentPane.add(closeBtn);
		
		JButton insertBtn = new JButton("Εισαγωγή");
		insertBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			    
			    
			    try {
			    	String firstname = firstnameTxt.getText().trim();
			    	String lastname = lastnameTxt.getText().trim();
			    	
			    	if (firstname.equals("") || lastname.equals("")) {
			    		JOptionPane.showMessageDialog(null, "Empty firstname / lastname", "Error", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
			    	String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME) VALUES (?, ?)";	
			    	Connection connection = Menu.getConnection();
			    	PreparedStatement ps = connection.prepareStatement(sql);
			    	ps.setString(1, firstname);
			    	ps.setString(2, lastname);
			    	
			    	int n = ps.executeUpdate();
			    	JOptionPane.showMessageDialog(null,  n + " row affected", "Insert", JOptionPane.INFORMATION_MESSAGE);
			    } catch (SQLException e1) {
			    	e1.printStackTrace();
			    }
			}
		});
		insertBtn.setForeground(new Color(0, 0, 255));
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.setBounds(132, 199, 110, 43);
		contentPane.add(insertBtn);
	}
}
