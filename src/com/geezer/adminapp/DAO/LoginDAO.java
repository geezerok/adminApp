package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Login;

public interface LoginDAO {
	
	public void addLogin(Login login) throws SQLException;

	public void updateLogin(Long login_id, Login login) throws SQLException;

	public Login getLoginById(Long login_id) throws SQLException;
	
	

	public Collection<Login> getAllLogins() throws SQLException;
		
	public void deleteLogin(Login login) throws SQLException;


}
