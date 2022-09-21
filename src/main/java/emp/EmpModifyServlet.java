package emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpList;

/**
 * Servlet implementation class EmpModifyServlet
 */
@WebServlet("/empModify.do")
public class EmpModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpModifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");
		//사번으로 사원 정보 조회
		DBExpert dbe = new DBExpert();
		EmpList el = dbe.getEmp(id);
		//조회 결과를 jsp로 전송 deleteForm.jsp
		request.setAttribute("EMP", el);
		RequestDispatcher rd= request.getRequestDispatcher("showEmp.jsp");
		rd.forward(request, response);
	}

}
