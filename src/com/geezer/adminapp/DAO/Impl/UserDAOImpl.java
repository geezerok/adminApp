package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.DAO.UserDAO;
import com.geezer.adminapp.orm.Department;
import com.geezer.adminapp.orm.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(Long user_id, User user) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(Long user_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getUsersByDepartment(Department department)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByAliasName(String aliasname) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub

	}

}
