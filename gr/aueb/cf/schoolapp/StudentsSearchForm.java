package gr.aueb.cf.schoolapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class StudentsSearchForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lastnameTxt;
	private String lastname = "";

	public StudentsSearchForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				lastnameTxt.setText("");
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentsSearchForm.class.getResource("/resources/eduv2.png")));
		setTitle("Εισαγωγή / Αναζήτηση Μαθητή");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 0, 0, (Color) new Color(192, 192, 192)));
		panel.setBounds(109, 55, 289, 161);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lastnameLbl = new JLabel("Επώνυμο");
		lastnameLbl.setForeground(new Color(160, 82, 45));
		lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		lastnameLbl.setBounds(109, 22, 73, 20);
		panel.add(lastnameLbl);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(48, 52, 201, 37);
		panel.add(lastnameTxt);
		
		JButton searchBtn = new JButton("Αναζήτηση");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					lastname = lastnameTxt.getText();
					Main.getStudentsUpdateDeleteForm().setVisible(true);
					Main.getStudentsSearchForm().setEnabled(false);

			}});
		searchBtn.setForeground(Color.BLUE);
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchBtn.setBounds(88, 99, 113, 37);
		panel.add(searchBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 0, 0, (Color) new Color(192, 192, 192)));
		panel_1.setBounds(109, 237, 289, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton insertBtn = new JButton("Εισαγωγή");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getStudentsInsertForm().setVisible(true);
				Main.getStudentsSearchForm().setEnabled(false);
			}
		});
		insertBtn.setBounds(88, 38, 112, 29);
		insertBtn.setForeground(Color.BLUE);
		insertBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(insertBtn);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setEnabled(true);
				Main.getStudentsSearchForm().setVisible(false);
	
			}
		});
		closeBtn.setForeground(Color.BLUE);
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		closeBtn.setBounds(309, 357, 89, 37);
		contentPane.add(closeBtn);
	}


	public String getLastname() {
		return lastname;
	}



}
