package erp_jdbc_study_oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import erp_jdbc_study_oracle.dao.DepartmentDao;
import erp_jdbc_study_oracle.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();
	
	private DepartmentDaoImpl() {}
	
	public static DepartmentDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public Department selectDepartmentByNo(Connection con, Department dept) {
		String sql = "select dept_no, dept_name, floor from department where dept_no=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptNo());
			try(ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					 return getDepartment(rs);
				}
			}
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
		return null;
	}

	@Override
	public List<Department> selectDepartmentByAll(Connection con) {
		String sql = "select dept_no, dept_name, floor from department";
		try (PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Department> list = new ArrayList<>();
				do {
					list.add(getDepartment(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
		    throw new CustomSQLException(e);
		}
		return null;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("dept_no");
		String deptName = rs.getString("dept_name");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public int insertDepartment(Connection con,Department dept) {
		String sql = "insert into department values(?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		    throw new CustomSQLException(e);
		}
	}

	@Override
	public int updateDepartment(Connection con,Department dept) {
		String sql = "update department set dept_name=?, floor=? where dept_no = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getFloor());
			pstmt.setInt(3, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		    throw new CustomSQLException(e);
		}
	}

	@Override
	public int deleteDepartment(Connection con,Department dept) {
		String sql = "delete from department where dept_no = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		    throw new CustomSQLException(e);
		}
	}
}
