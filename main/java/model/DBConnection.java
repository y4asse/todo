package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
                // データベースのURL
		final String URL = "jdbc:mysql://localhost/tododb?useSSL=false";
                // データベースにアクセスするユーザー
		final String USER = "root";
                // パスワード
		final String PASSWORD = "Tpexbsk3238";

		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

		return con;
	}
}