package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.SessionInfo;

public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public BaseServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUserId = (String)session.getAttribute(SessionInfo.LOGIN_USER_ID);
		
		if(loginUserId != null) {
			try {
				exec(request, response);
			}catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
	
	protected abstract void exec (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException;
}
