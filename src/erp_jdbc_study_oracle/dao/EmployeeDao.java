package erp_jdbc_study_oracle.dao;

import java.sql.Connection;
import java.util.List;

import erp_jdbc_study_oracle.dto.Employee;

public interface EmployeeDao {
	Employee selectEmployeeByNo(Connection con, Employee emp);
	List<Employee> selectEmployeeByAll(Connection con);
	
	int insertEmployee(Connection con, Employee emp);
	int updateEmployee(Connection con, Employee emp);
	int deleteEmployee(Connection con, Employee emp);
	
	Employee loginProcess(Connection con, Employee emp);
}
