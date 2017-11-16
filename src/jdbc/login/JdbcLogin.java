package jdbc.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcLogin
 */
@WebServlet("/JdbcLogin")
public class JdbcLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public JdbcLogin() {
        super();
    }
    
    @Override
    public void init() {
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionManger.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		try {
			pstm = conn.prepareStatement("select * from t_user where userId = ? ");
			pstm.setString(1, userId);
			
			rs = pstm.executeQuery();
			
			List<UserVo> userList = new ArrayList<UserVo>();
			
			while(rs.next()) {
				UserVo userVo = new UserVo(rs.getString("USERID"), rs.getString("USERNM"), rs.getString("PASS"), rs.getString("REG_DT")); 
				userList.add(userVo);
			}
			
			if(userList.size() == 1) {
				UserVo userVo = userList.get(0);
				//로그인 성공 : main page로 이동
				if(pass.equals(userVo.getPass())) {
					RequestDispatcher rd = request.getRequestDispatcher("serverProgram/jsp/connection/main.jsp");
					request.setAttribute("userNm", userVo.getUserNm());
					rd.forward(request, response);
				}
				
				//패스워드가 다르다
				else {
					RequestDispatcher rd = request.getRequestDispatcher("serverProgram/jsp/connection/jdbcLogin.jsp");
					request.setAttribute("msg", "패스워드가 다릅니다.");
					rd.forward(request, response);				
				}
			}
			//실패 : 로그인 화면으로 이동
			else {
				RequestDispatcher rd = request.getRequestDispatcher("serverProgram/jsp/connection/jdbcLogin.jsp");
				request.setAttribute("msg", "사용자 아이디가 없습니다.");
				rd.forward(request, response);				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if(pstm != null) pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

	@Override
	public void destroy() {
		
	}
}