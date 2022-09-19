package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;

public class LoginDAO {
	public String LoginAuthenticate(String id, String password) throws SQLException, ClassNotFoundException{
		String resId = "";
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("	id ");
		sql.append(" FROM ");
		sql.append("	users ");
		sql.append(" WHERE ");
		sql.append("	id = ? ");
		sql.append(" AND ");
		sql.append("	password = ? ");
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())){
					pstmt.setString(1, id);
					pstmt.setString(2, password);
					
					ResultSet res = pstmt.executeQuery();
					
					if(res.next()) {
						resId = res.getString("id");
					}
		}
		return resId;
	}
}
