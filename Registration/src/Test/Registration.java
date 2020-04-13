package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField user1;
	private JTextField pass1;
	private JTextField email1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 219, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		user1 = new JTextField();
		user1.setBounds(10, 51, 183, 30);
		contentPane.add(user1);
		user1.setColumns(10);
		
		pass1 = new JTextField();
		pass1.setColumns(10);
		pass1.setBounds(10, 142, 183, 30);
		contentPane.add(pass1);
		
		email1 = new JTextField();
		email1.setColumns(10);
		email1.setBounds(10, 225, 183, 30);
		contentPane.add(email1);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					PreparedStatement ps = conn.prepareStatement("insert into user(user_name,user_email,user_password) values(?,?,?)");
					
					ps.setString(1,user1.getText());
					ps.setString(2,pass1.getText());	
					ps.setString(3,email1.getText());	
					int x = ps.executeUpdate();
					if(x>0) {
						System.out.println("Registration done sucessfully...");
					} else
					{
						System.out.println("Registration Failed...");	
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnRegistration.setBounds(10, 277, 183, 44);
		contentPane.add(btnRegistration);
		
		JLabel pass = new JLabel("Pass");
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		pass.setBounds(10, 97, 183, 34);
		contentPane.add(pass);
		
		JLabel user = new JLabel("User");
		user.setBounds(10, 11, 183, 29);
		contentPane.add(user);
		
		JLabel email = new JLabel("Email");
		email.setBounds(10, 183, 183, 31);
		contentPane.add(email);
	}
}
