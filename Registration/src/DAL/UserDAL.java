package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.UserDTO;
import UTILS.ConnectionUtil;

public class UserDAL {

	private Connection con;
	
	private java.sql.PreparedStatement preparedStatement;
	
	private ResultSet resultset;

	private ConnectionUtil conUtil;

	public ResultSet GetUserByNameNPass(UserDTO userDTO) throws  ClassNotFoundException {
	ResultSet result = null;
	String sql = "Select * from user where username=? and password=?";
	try {
		conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		
		preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, userDTO.getUsername());
		preparedStatement.setString(2, userDTO.getPassword());
		
		result = preparedStatement.executeQuery();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			con.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return result;
	}
}
