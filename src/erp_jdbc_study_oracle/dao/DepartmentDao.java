package erp_jdbc_study_oracle.dao;

import java.sql.Connection;
import java.util.List;

import erp_jdbc_study_oracle.dto.Department;

public interface DepartmentDao {
	Department selectDepartmentByNo(Connection con, Department dept);
	List<Department> selectDepartmentByAll(Connection con);
	
	int insertDepartment(Connection con, Department dept);
	int updateDepartment(Connection con, Department dept);
	int deleteDepartment(Connection con, Department dept);
}
