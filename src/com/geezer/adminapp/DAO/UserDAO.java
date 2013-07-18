package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Department;
import com.geezer.adminapp.orm.User;

public interface UserDAO {
	public void addUser(User user) throws SQLException;

	public void updateUser(Long user_id, User user) throws SQLException;

	public User getUserById(Long user_id) throws SQLException;
	
	public Collection<User> getUsersByDepartment(Department department) throws SQLException;
	
	public User getUserByAliasName(String aliasname) throws SQLException;
	
	public Collection<User> getAllUsers() throws SQLException;
		
	public void deleteUser(User user) throws SQLException;

}
