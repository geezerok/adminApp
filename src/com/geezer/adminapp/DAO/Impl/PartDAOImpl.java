package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.DAO.PartDAO;
import com.geezer.adminapp.orm.Computer;
import com.geezer.adminapp.orm.Part;
import com.geezer.adminapp.orm.PartType;

public class PartDAOImpl implements PartDAO {

	@Override
	public void addPart(Part part) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePart(Long part_id, Part part) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Part getPartById(Long part_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Part> getAllParts() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Part> getPartsByManufacturer(String manufacturer)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Part> getPartsByPartType(PartType partType)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Part> getPartsByComputer(Computer computer)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePart(Part part) throws SQLException {
		// TODO Auto-generated method stub

	}

}
