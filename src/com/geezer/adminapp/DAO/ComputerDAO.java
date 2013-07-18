package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Computer;
import com.geezer.adminapp.orm.User;

public interface ComputerDAO {

	public void addComputer(Computer computer) throws SQLException;

	public void updateComputer(Long computer_id, Computer computer) throws SQLException;

	public Computer getComputerById(Long computer_id) throws SQLException;

	public Collection<Computer> getAllComputers() throws SQLException;
	
	public Collection<Computer> getComputersByUser(User user) throws SQLException;
	
//	public Collection<Computer> getComputersByComputerType() throws SQLException;

	public void deleteComputer(Computer computer) throws SQLException;

}
