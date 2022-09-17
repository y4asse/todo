package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class DeleteDAO {
	public int deleteTodo(int id) throws SQLException, ClassNotFoundException {
		int processingNumber = 0;
		String sql = "DELETE FROM todo WHERE id = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, id);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}
