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
import DTO.SanPham;
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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormSanPham extends JFrame {

	private JPanel contentPane;
	private JTable tableSP;
	private JTextField txtMaSanPham;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField txtTenSanPham;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					FormSanPham frame = new FormSanPham();
					frame.showsp();
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
	public ArrayList<SanPham> LoadDataSp() {
        ArrayList<SanPham> LoadDataSp = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM sanpham";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	SanPham sanpham;
            while (rs.next()) {
                sanpham = new SanPham();
                sanpham.setMaSanPham(rs.getInt(1));
                sanpham.setGiaNhap(rs.getDouble(2));
                sanpham.setGiaBan(rs.getDouble(3));
                sanpham.setTenSanPham(rs.getString(4));
                LoadDataSp.add(sanpham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoadDataSp;
    }
	
	public void showsp() {
		ArrayList<SanPham> list = LoadDataSp();
		DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
		
		Object[] row = new Object[4];
		model.setRowCount(0);
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMaSanPham();
			row[1] = list.get(i).getGiaNhap();
			row[2] = list.get(i).getGiaBan();
			row[3] = list.get(i).getTenSanPham();
			model.addRow(row);
		}
		
	
	}
	public FormSanPham() {
		
		setBounds(100, 100, 716, 663);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setTitle("Quản Lý Sản Phẩm");
		
		Object [][] data={
		};
		
		String[] colums= {"Mã Sản Phẩm","Giá Nhập","Giá Bán","Tên Sản Phẩm"};
		
		int rowCount = 0;
		TableModel tableModel = new DefaultTableModel(colums, rowCount);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(tableSP);
		scrollPane.setBounds(10, 69, 682, 237);
		contentPane.add(scrollPane);
		
		tableSP = new JTable(tableModel);
		scrollPane.setViewportView(tableSP);
		
		txtMaSanPham = new JTextField();
		txtMaSanPham.setBounds(186, 321, 506, 29);
		contentPane.add(txtMaSanPham);
		txtMaSanPham.setColumns(10);
		
		txtGiaNhap = new JTextField(null);
		txtGiaNhap.setBounds(186, 375, 506, 29);
		txtGiaNhap.setColumns(10);
		contentPane.add(txtGiaNhap);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setBounds(186, 432, 506, 29);
		txtGiaBan.setColumns(10);
		contentPane.add(txtGiaBan);
		
		txtTenSanPham = new JTextField();
		txtTenSanPham.setBounds(186, 481, 506, 29);
		txtTenSanPham.setColumns(10);
		contentPane.add(txtTenSanPham);
		
		JButton btnNewButton = new JButton("Xoá");
		btnNewButton.setBounds(45, 569, 133, 39);
		btnNewButton.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/trash.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					String name = txtMaSanPham.getText();
					if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá ko?")==0) {
					PreparedStatement ps = conn.prepareStatement("DELETE FROM `sanpham` WHERE `sanpham`.`MaSanPham` = ?");
					ps.setString(1,name);
					ps.executeUpdate(); 
					showsp();
					}
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(188, 520, 133, 39);
		btnSa.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/edit.png")));
		btnSa.setForeground(Color.WHITE);
		btnSa.setBackground(Color.DARK_GRAY);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					
					if(!txtGiaNhap.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `sanpham` SET `GiaNhap`="+ txtGiaNhap.getText()+" WHERE `MaSanPham`=" + txtMaSanPham.getText());
						ps.executeUpdate(); 
					}
					if(!txtGiaBan.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `sanpham` SET `GiaBan`="+ txtGiaBan.getText()+" WHERE `MaSanPham`=" + txtMaSanPham.getText());
						ps.executeUpdate(); 
					}
					if(!txtTenSanPham.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `sanpham` SET `TenSanPham`=\""+ txtTenSanPham.getText()+"\" WHERE `MaSanPham`=" + txtMaSanPham.getText());
						ps.executeUpdate(); 
					}
					
					showsp();
					
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		contentPane.add(btnSa);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setBounds(45, 520, 133, 39);
		btnThm.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/plus.png")));
		btnThm.setForeground(Color.WHITE);
		btnThm.setBackground(Color.DARK_GRAY);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO `sanpham`(`MaSanPham`, `GiaNhap`, `GiaBan`, `TenSanPham`) VALUES (null,?,?,?)");
					ps.setString(1,txtGiaNhap.getText());
					ps.setString(2,txtGiaBan.getText());
					ps.setString(3,txtTenSanPham.getText());
		
					
					int x = ps.executeUpdate();
					if(x>0) {
						showsp();
						JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công");}
					else JOptionPane.showMessageDialog(rootPane, "Thêm Không Thành Công");
				} catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		contentPane.add(btnThm);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setBounds(188, 569, 133, 39);
		btnNewButton_3.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/refresh.png")));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showsp();
		        txtMaSanPham.setText("");
		        txtGiaNhap.setText("");
		        txtGiaBan.setText("");
		        txtTenSanPham.setText("");
		        txtSearch.setText("");
			}
		});
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 29, 133, 30);
		comboBox.setForeground(Color.BLACK);
		setBounds(100, 100, 716, 711);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MaSanPham", "GiaNhap", "GiaBan", "TenSanPham" }));
		contentPane.add(comboBox);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(274, 29, 418, 30);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setBounds(10, 29, 133, 30);
		btnNewButton_1.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/search.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<SanPham> list = null;
				TimKiem search = new TimKiem();
				
				list=search.timkiemSP(comboBox.getSelectedIndex(),txtSearch.getText());
				DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
				System.out.println(comboBox.getSelectedIndex() +  " " + txtSearch.getText());
				Object[] row = new Object[5];
				model.setRowCount(0);
				for(int i=0;i<list.size();i++)
				{
					row[0] = list.get(i).getMaSanPham();
					row[1] = list.get(i).getGiaNhap();
					row[2] = list.get(i).getGiaBan();
					row[3] = list.get(i).getTenSanPham();
					model.addRow(row);
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Import");
		btnNewButton_2.setBounds(377, 520, 133, 39);
		btnNewButton_2.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/import.png")));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Import n = new Import();
				try {
					n.NhapSP();
					JOptionPane.showMessageDialog(rootPane, "Import Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Export");
		btnNewButton_2_1.setBounds(520, 520, 133, 39);
		btnNewButton_2_1.setIcon(new ImageIcon(FormSanPham.class.getResource("/Img/export.png")));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export x = new Export();
				try {
					x.XuatSP();
					JOptionPane.showMessageDialog(rootPane, "Export Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_5 = new JButton("Mã Sản Phẩm");
		btnNewButton_5.setBounds(10, 321, 176, 29);
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setEnabled(false);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Giá Nhập");
		btnNewButton_5_1.setBounds(10, 375, 176, 29);
		btnNewButton_5_1.setForeground(Color.BLACK);
		btnNewButton_5_1.setEnabled(false);
		contentPane.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Giá Bán");
		btnNewButton_5_1_1.setBounds(10, 432, 176, 29);
		btnNewButton_5_1_1.setForeground(Color.BLACK);
		btnNewButton_5_1_1.setEnabled(false);
		contentPane.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_1_2 = new JButton("Tên Sản Phẩm");
		btnNewButton_5_1_2.setBounds(10, 481, 176, 29);
		btnNewButton_5_1_2.setForeground(Color.BLACK);
		btnNewButton_5_1_2.setEnabled(false);
		contentPane.add(btnNewButton_5_1_2);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBounds(347, 520, 2, 84);
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setBackground(Color.BLACK);
		contentPane.add(btnNewButton_6);
	}
}
