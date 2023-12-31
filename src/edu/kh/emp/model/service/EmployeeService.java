package edu.kh.emp.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static edu.kh.emp.common.JDBCTemplate.*;
import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();
	
	/** 전체 사원 정보 조회 서비스
	 * 
	 */
	public List<Employee> selectAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Employee> list = dao.selectAll(conn);
		
		close(conn);
		
		return list;
		
	}
	

	/** 사원 정보 추가 서비스
	 * @param emp
	 * @return result
	 */
	public int insertEmployee(Employee emp)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insertEmployee(conn, emp);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 사원 정보 조회
	 * @return
	 */
	public Employee selectEmpId(int empId) throws Exception {
		
		Connection conn = getConnection();
		
		Employee emp = dao.selectEmpId(conn, empId);
		
		close(conn);
		
		return emp;
	}


	/** 정보 수정
	 * @param emp
	 * @return
	 */
	public int updateEmployee(Employee emp) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateEmployee(conn, emp);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 정보 삭제
	 * @param emp
	 * @return
	 */
	public int deleteEmployee(int empId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmployee(conn, empId);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		
		return result;
	}


	/** 입력받은 부서와 같은 모든 사원 정보 조회
	 * @param empId
	 * @return
	 */
	public List<Employee> deptEmployee(String departmentTitle) throws Exception {
		
		Connection conn = getConnection();
		
		List<Employee> list = dao.deptEmployee(conn, departmentTitle);
		
		close(conn);
		
		
		return list;
	}


	public List<Employee> selectSalaryEmp(int salary) throws Exception {
		
		Connection conn = getConnection();
		
		List<Employee> list = dao.selectSalaryEmp(conn, salary);
		
		close(conn);
		

		return list;
	}


	public Map<String, Integer> sumSalaryEmp() throws Exception {
		
		Connection conn = getConnection();
		
		Map<String, Integer> map = dao.sumSalaryEmp(conn);
		
		close(conn);
		
		return map;
	}


	public Employee selectEmpNo(String empNo) throws Exception {
		
		Connection conn = getConnection();
		
		Employee emp = dao.selectEmpNo(conn, empNo);
		
		close(conn);
		
		return emp;
	}


	public Map<String, Double> jobNameEmp() throws Exception {
		
		Connection conn = getConnection();
		
		Map<String, Double> map = dao.jobNameEmp(conn);
		
		close(conn);
		
		return map;
	}
	
	

	
	
	
	
}
