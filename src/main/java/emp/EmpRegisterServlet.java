package emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpList;

@WebServlet("/empRegister.do")
public class EmpRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");
		String name = request.getParameter("NAME");
		String d_name = request.getParameter("DEPT");
		String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");
		//부서명(d_name)으로 부서번호를 찾는다.
		DBExpert dbe = new DBExpert();
		int no = dbe.getDeptNo(d_name);
		EmpList el = new EmpList();
		el.setId(id);//사원 번호
		el.setName(name);//사원 이름
		el.setNo(no);//부서 번호 설정
		el.setD_addr(addr);//주서 설정
		el.setD_phone(tel);//전화 번호 설정
		boolean result = dbe.putEmp(el);
		if(result) {// 삽입 성공
			response.sendRedirect("putEmpResult.jsp?R=Y");
		}else { //삽입 실패
			response.sendRedirect("putEmpResult.jsp?R=N");
		}
	}

}
