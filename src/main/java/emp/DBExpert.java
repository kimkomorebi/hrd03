package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.EmpList;

public class DBExpert {
	private String driver ="oracle.jdbc.OracleDriver";
	private String uri="jdbc:oracle:thin:@//localhost:1521/xe";
	
	public EmpList getEmp(String id) {
		String select = "select e.id, e.name, d.name, e.addr, e.phone"
				+ " from emps_info e, dept_info d"
				+ " where e.dept = d.no"
				+ " and e.id = ?";
		EmpList el = new EmpList();
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(uri,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();// select 실행
			if(rs.next()) {//조회 결과로 이동
				el.setId(rs.getString(1));//사번
				el.setName(rs.getString(2));//이름
				el.setD_name(rs.getString(3));//부서명
				el.setD_addr(rs.getString(4));//주소
				el.setD_phone(rs.getString(5));//연락처
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return el;
	}
	
	public boolean deleteEmp(String id) {
		String delete = "delete from emps_info where id = ?";
		boolean flag = false;
		Connection con = null;PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(uri,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			con.commit();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	public boolean putEmp(EmpList el) {
		String insert = "insert into emps_info values("
		+ "?,?,?,?,?) ";
		boolean flag = false; // 삽입 성공 유무를 위한 변수 선언
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(uri,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, el.getId());//사번
			pstmt.setString(2, el.getName());//이름
			pstmt.setString(3, el.getD_addr());//부서 주소
			pstmt.setInt(4, el.getNo());//부서 번호
			pstmt.setString(5, el.getD_phone());//전화번호
			pstmt.executeUpdate();
			con.commit();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	public int getDeptNo(String name) {
		String select = "select no from dept_info"
		+ " where name = ?";
		int no = -1; // 부서 번호가 저장될 변수 선언
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(uri);
			con = DriverManager.getConnection(uri,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) no = rs.getInt(1);
		}catch(Exception e) {
			
		}finally {
			
		}
		return no;
	}
	
	public ArrayList<String> getDeptNames(){
		String select = "select name from dept_info";
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(uri,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<EmpList> getEmps(){
		String select = "select e.id, e.name, d.name, d.address, d.phone"
				+ " from emps_info e, dept_info d"
				+ " where e.dept = d.no";
		ArrayList<EmpList> list = new ArrayList<EmpList>();
		EmpList emp = null;
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(uri,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();//조회
			while(rs.next()) {
				emp = new EmpList();
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setD_name(rs.getString(3));
				emp.setD_addr(rs.getString(4));
				emp.setD_phone(rs.getString(5));
				list.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
