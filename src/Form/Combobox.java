package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UTILS.ConnectionUtil;

import javax.swing.JComboBox;

public class Combobox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combobox frame = new Combobox();
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
	public Combobox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		try {
			ConnectionUtil conUntil = new ConnectionUtil();
			Connection conn = conUntil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select * from khachhang");
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()) {
				String name = rs.getString("TenKhachHang");
				comboBox.addItem(name);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
