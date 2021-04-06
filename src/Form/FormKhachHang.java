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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import DTO.KhachHang;
import DTO.SanPham;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormKhachHang extends JFrame {

	private JPanel contentPane;
	private JTable tableSP;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSoDT;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					FormKhachHang frame = new FormKhachHang();
					frame.showkh();
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
	public ArrayList<KhachHang> LoadDataKh() {
        ArrayList<KhachHang> LoadDataKh = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM khachhang";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	KhachHang khachhang;
            while (rs.next()) {
            	khachhang = new KhachHang();
            	khachhang.setMaKhachHang(rs.getString(1));
            	khachhang.setTenKhachHang(rs.getString(2));
            	khachhang.setNgaySinh(rs.getString(3));
            	khachhang.setDiaChi(rs.getString(4));
            	khachhang.setSoDT(rs.getString(5));
            	LoadDataKh.add(khachhang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoadDataKh;
    }
	
	public void showkh() {
		ArrayList<KhachHang> list = LoadDataKh();
		DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
		
		Object[] row = new Object[5];
		model.setRowCount(0);
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMaKhachHang();
			row[1] = list.get(i).getTenKhachHang();
			row[2] = list.get(i).getNgaySinh();
			row[3] = list.get(i).getDiaChi();
			row[4] = list.get(i).getSoDT();
			model.addRow(row);
		}
		
	
	}
	public FormKhachHang	() {
		
		setBounds(100, 100, 716, 664);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Quản Lý Khách Hàng");
		Object [][] data={
		};
		
		String[] colums= {"Mã Khách Hàng","Tên Khách Hàng","Ngày Sửa Lần Cuối","Địa Chỉ","Số Điện Thoại"};
		
		int rowCount = 0;
		TableModel tableModel = new DefaultTableModel(colums, rowCount);
		
		JScrollPane scrollPane = new JScrollPane(tableSP);
		scrollPane.setBounds(10, 84, 682, 237);
		contentPane.add(scrollPane);
		
		tableSP = new JTable(tableModel);
		tableSP.setEnabled(false);
		scrollPane.setViewportView(tableSP);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(186, 331, 506, 29);
		contentPane.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(186, 385, 506, 29);
		contentPane.add(txtTenKhachHang);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(186, 442, 506, 29);
		contentPane.add(txtDiaChi);
		
		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(186, 491, 506, 29);
		contentPane.add(txtSoDT);
		
		JButton btnNewButton = new JButton("Xoá");
		btnNewButton.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/trash.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					String name = txtMaKhachHang.getText();
					if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá ko?")==0) {
					PreparedStatement ps = conn.prepareStatement("DELETE FROM `khachhang` WHERE `khachhang`.`MaKhachHang` = ?");
					ps.setString(1,name);
					ps.executeUpdate(); 
					showkh();
					}
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setBounds(42, 579, 133, 39);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/edit.png")));
		btnSa.setForeground(Color.WHITE);
		btnSa.setBackground(Color.DARK_GRAY);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					
					if(!txtTenKhachHang.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `khachhang` SET `TenKhachHang`=\""+ txtTenKhachHang.getText()+"\" WHERE `MaKhachHang`=" + txtMaKhachHang.getText());
						ps.executeUpdate(); 
					}
					if(!txtDiaChi.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `khachhang` SET `DiaChi`=\""+ txtDiaChi.getText()+"\"  WHERE `MaKhachHang`=" + txtMaKhachHang.getText());
						ps.executeUpdate(); 
					}
					if(!txtSoDT.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `khachhang` SET `SoDT`=\""+ txtSoDT.getText()+"\" WHERE `MaKhachHang`=" + txtMaKhachHang.getText());
						ps.executeUpdate(); 
					}
					
					showkh();
					
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnSa.setBounds(195, 530, 133, 39);
		contentPane.add(btnSa);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/plus.png")));
		btnThm.setForeground(Color.WHITE);
		btnThm.setBackground(Color.DARK_GRAY);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO `khachhang`(`MaKhachHang`, `TenKhachHang`, `NgaySinh`, `DiaChi`,`SoDT`) VALUES (null,?,now(),?,?)");
					ps.setString(1,txtTenKhachHang.getText());
					ps.setString(2,txtDiaChi.getText());
					ps.setString(3,txtSoDT.getText());
					int x = ps.executeUpdate();
					showkh();
					if(x>0) {
						
						JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công");}
					else JOptionPane.showMessageDialog(rootPane, "Thêm Không Thành Công");
				} catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnThm.setBounds(42, 530, 133, 39);
		contentPane.add(btnThm);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/refresh.png")));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showkh();
		        txtMaKhachHang.setText("");
		        txtTenKhachHang.setText("");
		        txtDiaChi.setText("");
		        txtSoDT.setText("");
		        txtSearch.setText("");
		        
			}
		});
		btnNewButton_3.setBounds(195, 579, 133, 39);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Khách Hàng","Tên Khách Hàng","Địa Chỉ","Số Điện Thoại" }));
		comboBox.setBounds(141, 44, 133, 30);
		contentPane.add(comboBox);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(273, 44, 419, 30);
		contentPane.add(txtSearch);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/search.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<KhachHang> list = null;
				TimKiem search = new TimKiem();
				
				list=search.timkiemKH(comboBox.getSelectedIndex(),txtSearch.getText());
				DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
				System.out.println(comboBox.getSelectedIndex() +  " " + txtSearch.getText());
				Object[] row = new Object[5];
				model.setRowCount(0);
				for(int i=0;i<list.size();i++)
				{
					row[0] = list.get(i).getMaKhachHang();
					row[1] = list.get(i).getTenKhachHang();
					row[2] = list.get(i).getNgaySinh();
					row[3] = list.get(i).getDiaChi();
					row[4] = list.get(i).getSoDT();
					model.addRow(row);
				}
			}
		});
		btnNewButton_1.setBounds(10, 44, 133, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Import");
		btnNewButton_2.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/import.png")));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Import n = new Import();
				try {
					n.NhapKH();
					JOptionPane.showMessageDialog(rootPane, "Import Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(416, 530, 133, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Export");
		btnNewButton_2_1.setIcon(new ImageIcon(FormKhachHang.class.getResource("/Img/export.png")));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
            {
				Export x = new Export();
				try {
					x.XuatKH();
					JOptionPane.showMessageDialog(rootPane, "Export Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
              }
		});
		btnNewButton_2_1.setBounds(559, 530, 133, 39);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_5 = new JButton("Mã Khách Hàng");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(10, 331, 176, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Tên Khách Hàng");
		btnNewButton_5_1.setForeground(Color.BLACK);
		btnNewButton_5_1.setEnabled(false);
		btnNewButton_5_1.setBounds(10, 385, 176, 29);
		contentPane.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Địa Chỉ");
		btnNewButton_5_1_1.setForeground(Color.BLACK);
		btnNewButton_5_1_1.setEnabled(false);
		btnNewButton_5_1_1.setBounds(10, 442, 176, 29);
		contentPane.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_1_2 = new JButton("Số Điện Thoại");
		btnNewButton_5_1_2.setForeground(Color.BLACK);
		btnNewButton_5_1_2.setEnabled(false);
		btnNewButton_5_1_2.setBounds(10, 491, 176, 29);
		contentPane.add(btnNewButton_5_1_2);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setBackground(Color.BLACK);
		btnNewButton_6.setBounds(373, 530, 2, 84);
		contentPane.add(btnNewButton_6);
	}
}
