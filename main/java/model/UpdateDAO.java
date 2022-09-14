package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.dto.TodoDTO;

// Todoの更新を行うクラス
public class UpdateDAO {

	/**
	 * idを元にデータベースからTodo情報を取得する
	 * @param id
	 * @return todo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TodoDTO getTodo(int id) throws SQLException, ClassNotFoundException {
		// 取得したTodoを格納する変数
		TodoDTO todo = new TodoDTO();

		// Idを指定してTodoを取得するSQL
		String sql = "SELECT id, todo, timeLimit FROM todo where id = ? ";

		// DBに接続し、Todoを取得する
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);

			// SQLを実行しTodoを取得する
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				// DBから取得したTodoの情報をtodoに持たせる
				todo.setId(res.getInt("id"));
				todo.setTodo(res.getString("todo"));
				todo.setTimeLimit(res.getDate("timeLimit"));
			}
		}

		return todo;

	}
}
