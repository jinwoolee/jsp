package kr.or.ddit.user.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;


@WebServlet("/userListOnlyHalf")
public class UserListOnlyHalfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserListOnlyHalfController.class);
	private IUserDao userDao;
       
   @Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userList",userDao.getUserListOnlyHalf());
		
		request.getRequestDispatcher("/user/userListOnlyHalf.jsp").forward(request, response);
	}

}
