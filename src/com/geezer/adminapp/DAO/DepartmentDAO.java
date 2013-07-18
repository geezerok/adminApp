package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Department;

public interface DepartmentDAO {
	public void addDepartment(Department department) throws SQLException;

	public void updateDepartment(Long department_id, Department department) throws SQLException;

	public Department getDepartmentById(Long department_id) throws SQLException;

	public Collection<Department> getAllDepartments() throws SQLException;
		
	public void deleteDepartment(Department department) throws SQLException;


}
