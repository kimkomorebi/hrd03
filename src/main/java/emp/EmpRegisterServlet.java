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
		//�μ���(d_name)���� �μ���ȣ�� ã�´�.
		DBExpert dbe = new DBExpert();
		int no = dbe.getDeptNo(d_name);
		EmpList el = new EmpList();
		el.setId(id);//��� ��ȣ
		el.setName(name);//��� �̸�
		el.setNo(no);//�μ� ��ȣ ����
		el.setD_addr(addr);//�ּ� ����
		el.setD_phone(tel);//��ȭ ��ȣ ����
		boolean result = dbe.putEmp(el);
		if(result) {// ���� ����
			response.sendRedirect("putEmpResult.jsp?R=Y");
		}else { //���� ����
			response.sendRedirect("putEmpResult.jsp?R=N");
		}
	}

}
