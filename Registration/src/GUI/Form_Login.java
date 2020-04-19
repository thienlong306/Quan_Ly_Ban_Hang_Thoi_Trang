package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import BLL.UserBLL;
import DTO.UserDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
public class Form_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Login frame = new Form_Login();
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
	public Form_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		txtUserName = new JTextField();
		txtUserName.setBackground(Color.GRAY);
		txtUserName.setBounds(142, 124, 231, 34);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBackground(Color.GRAY);
		txtPassword.setColumns(10);
		txtPassword.setBounds(142, 226, 231, 34);
		contentPane.add(txtPassword);
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass.setForeground(Color.WHITE);
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBounds(10, 199, 122, 84);
		contentPane.add(pass);
		
		JLabel user = new JLabel("Username:");
		user.setFont(new Font("Tahoma", Font.PLAIN, 19));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setForeground(Color.WHITE);
		user.setBounds(10, 107, 122, 65);
		contentPane.add(user);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 417, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginForm.setBounds(10, 10, 122, 65);
		panel.add(lblLoginForm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 75, 417, 243);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDTO userDTO = new UserDTO (txtUserName.getText(), txtPassword.getText());
				UserBLL userBLL = new UserBLL();
				
				try {
					if (userBLL.Login(userDTO)==null) {
						System.out.println("Login ko thanh cong");
					}
					else {
						System.out.println("Login thanh cong");
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(200, 212, 85, 21);
		panel_1.add(btnNewButton);
	}
}
