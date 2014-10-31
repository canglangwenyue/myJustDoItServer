package wenyue.justdoit.serevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wenyue.justdoit.Dao.userDao;
import wenyue.justdoit.DaoImpl.userDaoImpl;
import wenyue.justdoit.Entity.user;

public class loginServlet extends HttpServlet {

	public loginServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		// Put your code here
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		user u = new user();
		userDao dao = new userDaoImpl();
		u.setUsername(request.getParameter("username"));
		u.setUserpassword(request.getParameter("password"));
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = null;
		if (dao.getUserData(u.getUsername(), u.getUserpassword())) {
			msg = "success";
		} else {
			msg = "failed";
		}
		out.print(msg);
		out.flush();
		out.close();

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}
