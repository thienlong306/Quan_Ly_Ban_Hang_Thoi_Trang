package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FormMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMenu frame = new FormMenu();
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
	public FormMenu() {
		setBounds(100, 100, 676, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Menu");
		
		JButton btnNewButton = new JButton("Quản Lý Sản Phẩm");
		btnNewButton.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/product.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormSanPham sp = new FormSanPham();
				sp.showsp();
				sp.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(236, 27, 416, 52);
		contentPane.add(btnNewButton);
		
		JButton btnQunLHo = new JButton("Quản Lý Hoá Đơn");
		btnQunLHo.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/bill.png")));
		btnQunLHo.setForeground(Color.WHITE);
		btnQunLHo.setBackground(Color.DARK_GRAY);
		btnQunLHo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			{
				FormHoaDon nv = new FormHoaDon();
				nv.showhd();
				nv.setVisible(true);
			}
			}
		});
		btnQunLHo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQunLHo.setBounds(236, 89, 416, 52);
		contentPane.add(btnQunLHo);
		
		JButton btnNewButton_1_1 = new JButton("Quản Lý Khách Hàng");
		btnNewButton_1_1.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/CUSTOMER.png")));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormKhachHang nv = new FormKhachHang();
				nv.showkh();
				nv.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(236, 151, 416, 52);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Thống Kê");
		btnNewButton_1_1_1.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/STATISTICAL.png")));
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormThongKe nv = new FormThongKe();
				nv.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(236, 278, 416, 52);
		contentPane.add(btnNewButton_1_1_1);
		
		
		JButton btnNewButton_1_1_1_1 = new JButton("Đăng Xuất");
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/logout.png")));
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormDangNhap formDN = new FormDangNhap();
				formDN.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1_1.setBounds(236, 340, 416, 52);
		contentPane.add(btnNewButton_1_1_1_1);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/login.PNG")));
		lblNewLabel.setBounds(0, 0, 224, 402);
		contentPane.add(lblNewLabel);
		
	}
	public void checkadmin(String s) {
		if(s.equals("admin"))  {
			JButton btnNewButton_1_2 = new JButton("Quản Lý Nhân Viên");
			btnNewButton_1_2.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/staff.png")));
			btnNewButton_1_2.setForeground(Color.WHITE);
			btnNewButton_1_2.setBackground(Color.DARK_GRAY);
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FormNhanVien nv = new FormNhanVien();
					nv.shownv();
					nv.setVisible(true);
				}
			});
			btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1_2.setBounds(236, 213, 416, 52);
			contentPane.add(btnNewButton_1_2);
		} 
	
	}
	public void checknv(String s) {
		if(!s.equals("admin"))  {
			JButton btnNewButton_1_2 = new JButton("Quản Lý Nhân Viên");
			btnNewButton_1_2.setIcon(new ImageIcon(FormMenu.class.getResource("/Img/staff.png")));
			btnNewButton_1_2.setForeground(Color.WHITE);
			btnNewButton_1_2.setBackground(Color.DARK_GRAY);
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(rootPane, "Bạn không phải admin");
				}
			});
			btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1_2.setBounds(236, 213, 416, 52);
			contentPane.add(btnNewButton_1_2);
		} 
	
	}
}
