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
import BLL.Report;
import BLL.TimKiem;
import UTILS.ConnectionUtil;
import net.sf.jasperreports.engine.JRException;
import DTO.HoaDon;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable tableSP;
	private JTextField txtMaHoaDon;
	private JTextField txtMaKhachHang;
	private JTextField txtMaNhanVien;
	private JTextField txtMaSanPham;
	private JTextField txtTongTien;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					FormHoaDon frame = new FormHoaDon();
					frame.showhd();
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
	public ArrayList<HoaDon> LoadDataHd() {
        ArrayList<HoaDon> LoadDataHd = new ArrayList<>();
        try {
    		ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT * FROM hoadon";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	HoaDon hoadon;
            while (rs.next()) {
            	hoadon = new HoaDon();
            	hoadon.setMaHoaDon(rs.getString(1));
            	hoadon.setMaKhacHang(rs.getString(2));
            	hoadon.setMaNhanVien(rs.getString(3));
            	hoadon.setMaSanPham(rs.getString(4));
            	hoadon.setNgayLapHoaDon(rs.getString(5));
            	hoadon.setTongTien(rs.getDouble(6));
            	LoadDataHd.add(hoadon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoadDataHd;
    }
	
	public void showhd() {
		ArrayList<HoaDon> list = LoadDataHd();
		DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
		
		Object[] row = new Object[6];
		model.setRowCount(0);
		for(int i=0;i<list.size();i++)
		{
			row[0] = list.get(i).getMaHoaDon();
			row[1] = list.get(i).getMaKhacHang();
			row[2] = list.get(i).getMaNhanVien();
			row[3] = list.get(i).getMaSanPham();
			row[4] = list.get(i).getNgayLapHoaDon();
			row[5] = list.get(i).getTongTien();
			model.addRow(row);
		}
		
	
	}
	public FormHoaDon() {
		
		setBounds(100, 100, 716, 711);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Quản Lý Hoá Đơn");
		
		Object [][] data={
		};
		
		String[] colums= {"Mã Hoá Đơn","Mã Khách Hàng","Mã Nhân Viên","Mã Sản Phẩm","Ngày Sửa Lần Cuối","Tổng Tiền"};
		
		int rowCount = 0;
		TableModel tableModel = new DefaultTableModel(colums, rowCount);
		
		JButton btnNewButton_4 = new JButton("...");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormKhachHang nv = new FormKhachHang();
				nv.showkh();
				nv.setVisible(true);
			}
		});
		
		JButton btnNewButton_4_2 = new JButton("...");
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_4_2.setForeground(Color.WHITE);
		btnNewButton_4_2.setBackground(Color.DARK_GRAY);
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormSanPham sp = new FormSanPham();
				sp.showsp();
				sp.setVisible(true);
			}
		});
		btnNewButton_4_2.setBounds(652, 496, 41, 21);
		contentPane.add(btnNewButton_4_2);
		btnNewButton_4.setBounds(652, 390, 41, 21);
		contentPane.add(btnNewButton_4);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(186, 328, 456, 29);
		contentPane.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);
		
		txtMaKhachHang = new JTextField(null);
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(186, 382, 456, 29);
		contentPane.add(txtMaKhachHang);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(186, 439, 456, 29);
		contentPane.add(txtMaNhanVien);
		
		txtMaSanPham = new JTextField();
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(186, 488, 456, 29);
		contentPane.add(txtMaSanPham);
		
		JButton btnNewButton = new JButton("Xoá");
		btnNewButton.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/trash.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					String name = txtMaHoaDon.getText();
					if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá ko?")==0) {
					PreparedStatement ps = conn.prepareStatement("DELETE FROM `hoadon` WHERE `hoadon`.`MaHoaDon` = ?");
					ps.setString(1,name);
					ps.executeUpdate(); 
					showhd();
					}
					
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setBounds(49, 623, 133, 39);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/edit.png")));
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSa.setForeground(Color.WHITE);
		btnSa.setBackground(Color.DARK_GRAY);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					
					if(!txtMaKhachHang.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `MaKhachHang`=\""+ txtMaKhachHang.getText()+"\" WHERE `MaHoaDon`=" + txtMaHoaDon.getText());
						ps.executeUpdate();
					}
					if(!txtMaNhanVien.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `MaNhanVien`=\""+ txtMaNhanVien.getText()+"\" WHERE `MaHoaDon`=" + txtMaHoaDon.getText());
						ps.executeUpdate();
					}
					if(!txtMaSanPham.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `MaSanPham`=\""+ txtMaSanPham.getText()+"\" WHERE `MaHoaDon`=" + txtMaHoaDon.getText());
						ps.executeUpdate();
					}
					if(!txtTongTien.getText().equals("")) {
						PreparedStatement ps = conn.prepareStatement("UPDATE `hoadon` SET `TongTien`=\""+ txtTongTien.getText()+"\" WHERE `MaHoaDon`=" + txtMaHoaDon.getText());
						ps.executeUpdate();
					}
					showhd();
				}catch (Exception e2) {
					System.out.println(e2);
					String ekhachhang="Cannot add or update a child row: a foreign key constraint fails (`banhang`.`hoadon`, CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`))";
					String enhanvien="Cannot add or update a child row: a foreign key constraint fails (`banhang`.`hoadon`, CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`))";
					String esanpham="Cannot add or update a child row: a foreign key constraint fails (`banhang`.`hoadon`, CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`))";
					if(e2.getMessage().equals(ekhachhang)) JOptionPane.showMessageDialog(rootPane,"Mã Khách Hàng Không Tìm Thấy");
						else if(e2.getMessage().equals(enhanvien)) JOptionPane.showMessageDialog(rootPane,"Mã Nhân Viên Không Tìm Thấy");
							else if(e2.getMessage().equals(esanpham)) JOptionPane.showMessageDialog(rootPane,"Mã Sản Phẩm Không Tìm Thấy");
				}
			}
		});
		btnSa.setBounds(192, 578, 133, 39);
		contentPane.add(btnSa);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/plus.png")));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnThm.setForeground(Color.WHITE);
		btnThm.setBackground(Color.DARK_GRAY);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection conn = conUtil.getConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO `hoadon`(`MaHoaDon`, `MaKhachHang`, `MaNhanVien`, `MaSanPham`, `NgayLapHoaDon`, `TongTien`) VALUES (null,?,?,?,now(),?)");
					ps.setString(1,txtMaKhachHang.getText());
					ps.setString(2,txtMaNhanVien.getText());
					ps.setString(3,txtMaSanPham.getText());
					ps.setString(4,txtTongTien.getText());
					int x = ps.executeUpdate();
					if(x>0) {
						showhd();
						JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công");}
					else JOptionPane.showMessageDialog(rootPane, "Thêm Không Thành Công");
				} catch(Exception e2) {
					System.out.println(e2);
					String ekhachhang="Cannot add or update a child row: a foreign key constraint fails (`banhang`.`hoadon`, CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`))";
					String enhanvien="Cannot add or update a child row: a foreign key constraint fails (`banhang`.`hoadon`, CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`))";
					String esanpham="Cannot add or update a child row: a foreign key constraint fails (`banhang`.`hoadon`, CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`))";
					if(e2.getMessage().equals(ekhachhang)) JOptionPane.showMessageDialog(rootPane,"Mã Khách Hàng Không Tìm Thấy");
						else if(e2.getMessage().equals(enhanvien)) JOptionPane.showMessageDialog(rootPane,"Mã Nhân Viên Không Tìm Thấy");
							else if(e2.getMessage().equals(esanpham)) JOptionPane.showMessageDialog(rootPane,"Mã Sản Phẩm Không Tìm Thấy");
					
				}
			}
		});
		btnThm.setBounds(49, 578, 133, 39);
		contentPane.add(btnThm);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/refresh.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showhd();
		        txtMaHoaDon.setText("");
		        txtMaKhachHang.setText("");
		        txtMaNhanVien.setText("");
		        txtMaSanPham.setText("");
		        txtSearch.setText("");
			}
		});
		btnNewButton_3.setBounds(192, 623, 133, 39);
		contentPane.add(btnNewButton_3);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(186, 539, 456, 29);
		contentPane.add(txtTongTien);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Hoá Đơn","Mã Khách Hàng","Mã Nhân Viên","Mã Sản Phẩm" }));
		comboBox.setBounds(140, 37, 133, 34);
		contentPane.add(comboBox);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(271, 37, 422, 34);
		contentPane.add(txtSearch);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/search.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<HoaDon> list = null;
				TimKiem search = new TimKiem();
				
				list=search.timkiemHD(comboBox.getSelectedIndex(),txtSearch.getText());
				DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
				System.out.println(comboBox.getSelectedIndex() +  " " + txtSearch.getText());
				Object[] row = new Object[6];
				model.setRowCount(0);
				for(int i=0;i<list.size();i++)
				{
					row[0] = list.get(i).getMaHoaDon();
					row[1] = list.get(i).getMaKhacHang();
					row[2] = list.get(i).getMaNhanVien();
					row[3] = list.get(i).getMaSanPham();
					row[4] = list.get(i).getNgayLapHoaDon();
					row[5] = list.get(i).getTongTien();
					model.addRow(row);
				}
			}
		});
		btnNewButton_1.setBounds(10, 37, 133, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Import");
		btnNewButton_2.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/import.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Import n = new Import();
				try {
					n.NhapHD();
					JOptionPane.showMessageDialog(rootPane, "Import Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(366, 578, 133, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Export");
		btnNewButton_2_1.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/export.png")));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export x = new Export();
				try {
					x.XuatHD();
					JOptionPane.showMessageDialog(rootPane, "Export Thành Công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setBounds(509, 578, 133, 39);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Report");
		btnNewButton_2_2.setIcon(new ImageIcon(FormHoaDon.class.getResource("/Img/Report.png")));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Report rp = new Report();
					rp.rphd();
					JOptionPane.showMessageDialog(rootPane, "Report Thành Công");
				} catch (ClassNotFoundException | IOException | JRException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2_2.setBounds(366, 623, 276, 39);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_5 = new JButton("Mã Hoá Đơn");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(10, 328, 176, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Mã Khách Hàng");
		btnNewButton_5_1.setForeground(Color.BLACK);
		btnNewButton_5_1.setEnabled(false);
		btnNewButton_5_1.setBounds(10, 382, 176, 29);
		contentPane.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Mã Nhân Viên");
		btnNewButton_5_1_1.setForeground(Color.BLACK);
		btnNewButton_5_1_1.setEnabled(false);
		btnNewButton_5_1_1.setBounds(10, 439, 176, 29);
		contentPane.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_1_2 = new JButton("Mã Sản Phẩm");
		btnNewButton_5_1_2.setForeground(Color.BLACK);
		btnNewButton_5_1_2.setEnabled(false);
		btnNewButton_5_1_2.setBounds(10, 488, 176, 29);
		contentPane.add(btnNewButton_5_1_2);
		
		JButton btnNewButton_5_1_3 = new JButton("Tổng Tiền");
		btnNewButton_5_1_3.setForeground(Color.BLACK);
		btnNewButton_5_1_3.setEnabled(false);
		btnNewButton_5_1_3.setBounds(10, 539, 176, 29);
		contentPane.add(btnNewButton_5_1_3);
		
		JScrollPane scrollPane = new JScrollPane(tableSP);
		scrollPane.setBounds(10, 81, 683, 237);
		contentPane.add(scrollPane);
		
		tableSP = new JTable(tableModel);
		tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)tableSP.getModel();
				int SelectedRowIndex = tableSP.getSelectedRow();
				txtMaHoaDon.setText(model.getValueAt(SelectedRowIndex, 0).toString());
		        txtMaKhachHang.setText(model.getValueAt(SelectedRowIndex, 1).toString());
		        txtMaNhanVien.setText(model.getValueAt(SelectedRowIndex, 2).toString());
		        txtMaSanPham.setText("");
		        txtSearch.setText("");
			}
		});
		tableSP.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableSP);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(Color.BLACK);
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setBounds(343, 578, 2, 84);
		contentPane.add(btnNewButton_6);
	}
}
