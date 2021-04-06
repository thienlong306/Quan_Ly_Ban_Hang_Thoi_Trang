package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import UTILS.ConnectionUtil;

import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FormThongKe extends JFrame {

	private JPanel contentPane;
	private JTable tableModel;
	public double sodudauky=0;
	public double tongthu=0;
	public double tongchi=0;
	public double tonquy=0;
	/**
	 * Launch the application.
	 */
	public void tinhtongthu() {
		try {
			ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT SUM(TongTien) FROM hoadon";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	while (rs.next()) {
                int c = rs.getInt(1);
                tongthu = tongthu + c;
        	}
       
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void tinhtongchi() {
		try {
			ConnectionUtil conUtil = new ConnectionUtil();
        	Connection conn = conUtil.getConnection();
        	String qry = "SELECT SUM(GiaNhap) FROM sanpham";
        	PreparedStatement ps = conn.prepareStatement(qry);
        	ResultSet rs = ps.executeQuery();
        	while (rs.next()) {
                int c = rs.getInt(1);
                tongchi = tongchi + c;
        	}
       
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void tinhtonquy() {
		tinhtongthu();
		tinhtongchi();
		tonquy=sodudauky+tongthu-tongchi;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThongKe frame = new FormThongKe();
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
	public FormThongKe() {
		setBounds(100, 100, 841, 687);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Thống Kê");
		
		Object [][] data={
		};
		
		String[] colums= {"Số dư đầu kỳ","Tổng thu","Tổng chi","Tồn quỹ"};
		
		int rowCount = 0;
		TableModel tableModel = new DefaultTableModel(colums, rowCount);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 807, 54);
		contentPane.add(scrollPane);
		tinhtonquy();
		JTable tableSP = new JTable(tableModel);
		scrollPane.setViewportView(tableSP);
		
		DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
		Object[] row = new Object[4];
		model.setRowCount(0);
		row[0] = sodudauky;
		row[1] = tongthu;
		row[2] = tongchi;
		row[3] = tonquy;
		model.addRow(row);
		
		JLabel bieudi = new JLabel("Tình hình lợi nhuận và kinh doanh toàn cửa hàng");
		bieudi.setBackground(Color.WHITE);
		bieudi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bieudi.setHorizontalAlignment(SwingConstants.LEFT);
		bieudi.setBounds(10, 151, 779, 77);
		contentPane.add(bieudi);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormThongKe.class.getResource("/Img/Thongke.PNG")));
		lblNewLabel_1.setBounds(54, 199, 735, 451);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Số dư đầu kỳ    +    Tổng Thu    -    Tổng Chi    =    Tồn Quỹ ");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 807, 66);
		contentPane.add(btnNewButton);
	}
}
