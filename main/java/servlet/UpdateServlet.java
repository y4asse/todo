package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.UpdateDAO;
import model.dao.dto.TodoDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void  exec (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException{
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			getGetRequest(request, response);
		}else if (method.equals("POST")) {
			getPostRequest(request, response);
		}
	}
	
	protected void getGetRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		// リクエストパラメータからtodoIdを取得する
		int todoId = 0;
		try {
			todoId = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("list-servlet").forward(request, response);
		}

		UpdateDAO dao = new UpdateDAO();
		TodoDTO todo = new TodoDTO();
		todo = dao.getTodo(todoId);

		request.setAttribute("todo", todo);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	protected void getPostRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		String todo = request.getParameter(Parameters.TODO);
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));
		
		UpdateDAO dao = new UpdateDAO();
		dao.updateTodo(id,  todo, timeLimit);
		response.sendRedirect("list-servlet");
	}

}
