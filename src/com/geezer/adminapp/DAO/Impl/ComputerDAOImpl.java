package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.DAO.ComputerDAO;
import com.geezer.adminapp.orm.Computer;
import com.geezer.adminapp.orm.User;

public class ComputerDAOImpl implements ComputerDAO {

	@Override
	public void addComputer(Computer computer) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateComputer(Long computer_id, Computer computer)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Computer getComputerById(Long computer_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Computer> getAllComputers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Computer> getComputersByUser(User user)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComputer(Computer computer) throws SQLException {
		// TODO Auto-generated method stub

	}

}
