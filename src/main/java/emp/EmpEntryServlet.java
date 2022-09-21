package emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpEntryServlet
 */
@WebServlet("/empEntry.do")
public class EmpEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpEntryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//부서 정보 테이블에서 부서명을 검색한다.
		DBExpert dbe = new DBExpert();
		ArrayList<String> names = dbe.getDeptNames();
		request.setAttribute("DEPTS", names);
		RequestDispatcher rd = request.getRequestDispatcher("empEntry.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
