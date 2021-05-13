package servlets.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberDao;
import vo.Member;

@SuppressWarnings("serial")
@WebServlet("/modify")
public class BoardUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao) sc.getAttribute("BoardDao");
			 HttpSession session = (HttpSession)req.getSession();
		      Member member = (Member)session.getAttribute("member");
		     
		      req.setAttribute("member", member);
		      
		      RequestDispatcher rd = req.getRequestDispatcher("modifyWrite.jsp");
			  rd.forward(req, resp);
		
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, resp);
		}	      
	}
	
}
