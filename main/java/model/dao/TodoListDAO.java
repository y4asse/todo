package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.dao.dto.TodoDTO;

/**
 * Todoの一覧を取得するクラス
 *
 * @author yuhablog
 */
public class TodoListDAO {

	/**
	 * Todoの一覧を取得する
	 * @return todoの一覧
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<TodoDTO> getTodoList() throws ClassNotFoundException, SQLException {
		// 返却用Listの初期化
		List<TodoDTO> todoList = new ArrayList<>();

		// 実行するSQL
		String sql = "SELECT id, todo, timeLimit from todo";

		// DBに接続し、Todo一覧を取得する
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLを実行しResultSetの変数に結果を格納する
			ResultSet res = pstmt.executeQuery();
			// 実行結果を順番に取り出す
			while (res.next()) {
			        //  それぞれid, todo, timeLimitを取得する
				int id = res.getInt("id");
				String todo = res.getString("todo");
				Date timeLimit = res.getDate("timeLimit");

				// 取得したid, todo, timeLimitでTodoDTOを初期化してListに追加
				todoList.add(new TodoDTO(id, todo, timeLimit));
			}
		}

		return todoList;
	}
}