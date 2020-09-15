package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection users = null;
		try {
			users = DBConnection.openConnection();
			String id = request.getParameter("deleteId");
			Statement state = users.createStatement();
			state.executeUpdate("DELETE FROM user_table WHERE id='" + id + "'");
			response.sendRedirect("/select"); //UserSelectServletを呼び出す
			DBConnection.closeConnection(users, state);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
