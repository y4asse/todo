package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete-servlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void exec (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException {
		int id = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		DeleteDAO dao = new DeleteDAO();
		dao.deleteTodo(id);
		response.sendRedirect("list-servlet");
	}

}
