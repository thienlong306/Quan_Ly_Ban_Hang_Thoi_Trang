package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Statement;

import BLL.Export;
import BLL.Import;
import BLL.TimKiem;
import UTILS.ConnectionUtil;
import DTO.KhachHang;
import DTO.NhanVien;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormNhanVien extends JFrame {

	private JPanel contentPane;
	private JTable tableSP;
	private JTextField txtMaNhanVien;
	private JTextField txtTenDangNhap;
	private JTextField txtTenNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtSoDT;
	private JPasswordField txtPassword;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					FormNhanVien frame = new FormNhanVien();
					frame.shownv();
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
	public ArrayList<NhanVien> LoadDataNv() {
        ArrayList<NhanVien> LoadDataNv = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM nhanvien";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	NhanVien nhanvien;
            while (rs.next()) {
            	nhanvien = new NhanVien();
            	nhanvien.setMaNhanVien(rs.getInt(1));
            	nhanvien.setTenDangNhap(rs.getString(2));
            	nhanvien.setPassword(rs.getString(3));
            	nhanvien.setTenNhanVien(rs.getString(4));
            	nhanvien.setNgayDK(rs.getString(5));
            	nhanvien.setDiaChi(rs.getString(6));
            	nhanvien.setSoDT(rs.getString(7));
                LoadDataNv.add(nhanvien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoadDataNv;
    }
	
	public void shownv() {
		ArrayList<NhanVien> list = LoadDataNv();
		DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
		
		Object[] row = new Object[7];
		model.setRowCount(0);
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMaNhanVien();
			row[1] = list.get(i).getTenDangNhap();
			row[2] = list.get(i).getPassword();
			row[3] = list.get(i).getTenNhanVien();
			row[4] = list.get(i).getNgayDK();
			row[5] = list.get(i).getDiaChi();
			row[6] = list.get(i).getSoDT();
			model.addRow(row);
		}
		
	
	}
	public FormNhanVien() {
		
		setBounds(100, 100, 716, 736);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Quản Lý Nhân Viên");
		
		Object [][] data={
		};
		
		String[] colums= {"Mã Nhân Viên","Tên Đăng Nhập","Password","Tên Nhân Viên","Ngày Đăng Ký","Địa Chỉ","Số Điện Thoại"};
		
		int rowCount = 0;
		TableModel tableModel = new DefaultTableModel(colums, rowCount);
		
		JScrollPane scrollPane = new JScrollPane(tableSP);
		scrollPane.setBounds(10, 54, 682, 237);
		contentPane.add(scrollPane);
		
		tableSP = new JTable(tableModel);
		scrollPane.setViewportView(tableSP);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(186, 310, 506, 29);
		contentPane.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(186, 364, 506, 29);
		contentPane.add(txtTenDangNhap);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(186, 470, 506, 29);
		contentPane.add(txtTenNhanVien);
		
		JButton btnNewButton = new JButton("Xoá");
		btnNewButton.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/trash.png")));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					String name = txtMaNhanVien.getText();
					if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá ko?")==0) {
					PreparedStatement ps = conn.prepareStatement("DELETE FROM `nhanvien` WHERE `nhanvien`.`MaNhanVien` = ?");
					ps.setString(1,name);
					ps.executeUpdate(); 
					shownv();
					}
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setBounds(46, 653, 133, 39);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/edit.png")));
		btnSa.setBackground(Color.DARK_GRAY);
		btnSa.setForeground(Color.WHITE);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
		
					if(!txtTenDangNhap.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `TenDangNhap`=\""+ txtTenDangNhap.getText()+"\" WHERE `MaNhanVien`=" + txtMaNhanVien.getText());
						ps.executeUpdate(); 
					}
					if(!txtPassword.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `Password`=\""+ txtPassword.getText()+"\" WHERE `MaNhanVien`=" + txtMaNhanVien.getText());
						ps.executeUpdate(); 
					}
					if(!txtTenNhanVien.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `TenNhanVien`=\""+ txtTenNhanVien.getText()+"\" WHERE `MaNhanVien`=" + txtMaNhanVien.getText());
						ps.executeUpdate(); 
					}
					if(!txtDiaChi.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `DiaChi`=\""+ txtDiaChi.getText()+"\" WHERE `MaNhanVien`=" + txtMaNhanVien.getText());
						ps.executeUpdate(); 
					}
					if(!txtSoDT.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `nhanvien` SET `SoDT`=\""+ txtSoDT.getText()+"\" WHERE `MaNhanVien`=" + txtMaNhanVien.getText());
						ps.executeUpdate(); 
					}
					shownv();
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnSa.setBounds(189, 609, 133, 39);
		contentPane.add(btnSa);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/plus.png")));
		btnThm.setBackground(Color.DARK_GRAY);
		btnThm.setForeground(Color.WHITE);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO `nhanvien`(`MaNhanVien`, `TenDangNhap`, `Password`, `TenNhanVien`, `NgayDK`, `DiaChi`, `SoDT`) VALUES (null,?,?,?,now(),?,?)");
					ps.setString(1,txtTenDangNhap.getText());
					ps.setString(2,txtPassword.getText());
					ps.setString(3,txtTenNhanVien.getText());
					ps.setString(4,txtDiaChi.getText());
					ps.setString(5,txtSoDT.getText());
					
					int x = ps.executeUpdate();
					if(x>0) {
						shownv();
						JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công");}
					else JOptionPane.showMessageDialog(rootPane, "Thêm Không Thành Công");
				} catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnThm.setBounds(46, 609, 133, 39);
		contentPane.add(btnThm);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/refresh.png")));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shownv();
		        txtMaNhanVien.setText("");
		        txtTenDangNhap.setText("");
		        txtPassword.setText("");
		        txtTenNhanVien.setText("");
		        txtDiaChi.setText("");
		        txtSoDT.setText("");
		        txtSearch.setText("");
			}
		});
		btnNewButton_3.setBounds(189, 653, 133, 39);
		contentPane.add(btnNewButton_3);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(186, 521, 506, 29);
		contentPane.add(txtDiaChi);
		
		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(186, 570, 506, 29);
		contentPane.add(txtSoDT);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(186, 421, 508, 29);
		contentPane.add(txtPassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Nhân Viên","Tên Đăng Nhập","Tên Nhân Viên","Địa Chỉ","Số Điện Thoại" }));
		comboBox.setBounds(142, 10, 133, 34);
		contentPane.add(comboBox);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(273, 10, 419, 34);
		contentPane.add(txtSearch);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/search.png")));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<NhanVien> list = null;
				TimKiem search = new TimKiem();
				
				list=search.timkiemNV(comboBox.getSelectedIndex(),txtSearch.getText());
				DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
				System.out.println(comboBox.getSelectedIndex() +  " " + txtSearch.getText());
				Object[] row = new Object[7];
				model.setRowCount(0);
				for(int i=0;i<list.size();i++)
				{
					row[0] = list.get(i).getMaNhanVien();
					row[1] = list.get(i).getTenDangNhap();
					row[2] = list.get(i).getPassword();
					row[3] = list.get(i).getTenNhanVien();
					row[4] = list.get(i).getNgayDK();
					row[5] = list.get(i).getDiaChi();
					row[6] = list.get(i).getSoDT();
					model.addRow(row);
				}
			}
		});
		btnNewButton_1.setBounds(10, 10, 133, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Import");
		btnNewButton_2.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/import.png")));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Import n = new Import();
				try {
					n.NhapNV();
					JOptionPane.showMessageDialog(rootPane, "Import Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(370, 609, 133, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Export");
		btnNewButton_2_1.setIcon(new ImageIcon(FormNhanVien.class.getResource("/Img/export.png")));
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export x = new Export();
				try {
					x.XuatNV();
					JOptionPane.showMessageDialog(rootPane, "Export Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setBounds(513, 609, 133, 39);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_5 = new JButton("Mã Nhân Viên");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(10, 310, 176, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Tên Đăng Nhập");
		btnNewButton_5_1.setForeground(Color.BLACK);
		btnNewButton_5_1.setEnabled(false);
		btnNewButton_5_1.setBounds(10, 364, 176, 29);
		contentPane.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Password");
		btnNewButton_5_1_1.setForeground(Color.BLACK);
		btnNewButton_5_1_1.setEnabled(false);
		btnNewButton_5_1_1.setBounds(10, 421, 176, 29);
		contentPane.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_1_2 = new JButton("Tên Nhân Viên");
		btnNewButton_5_1_2.setForeground(Color.BLACK);
		btnNewButton_5_1_2.setEnabled(false);
		btnNewButton_5_1_2.setBounds(10, 470, 176, 29);
		contentPane.add(btnNewButton_5_1_2);
		
		JButton btnNewButton_5_1_3 = new JButton("Địa Chỉ");
		btnNewButton_5_1_3.setForeground(Color.BLACK);
		btnNewButton_5_1_3.setEnabled(false);
		btnNewButton_5_1_3.setBounds(10, 521, 176, 29);
		contentPane.add(btnNewButton_5_1_3);
		
		JButton btnNewButton_5_1_3_1 = new JButton("Số Điện Thoại");
		btnNewButton_5_1_3_1.setForeground(Color.BLACK);
		btnNewButton_5_1_3_1.setEnabled(false);
		btnNewButton_5_1_3_1.setBounds(10, 570, 176, 29);
		contentPane.add(btnNewButton_5_1_3_1);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setBackground(Color.BLACK);
		btnNewButton_6.setBounds(345, 609, 2, 84);
		contentPane.add(btnNewButton_6);
	}
}
