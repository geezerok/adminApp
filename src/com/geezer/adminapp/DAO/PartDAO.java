package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Computer;
import com.geezer.adminapp.orm.Part;
import com.geezer.adminapp.orm.PartType;

public interface PartDAO {
	public void addPart(Part part) throws SQLException;

	public void updatePart(Long part_id, Part part) throws SQLException;

	public Part getPartById(Long part_id) throws SQLException;

	public Collection<Part> getAllParts() throws SQLException;
	
	public Collection<Part> getPartsByManufacturer(String manufacturer) throws SQLException;
	
	public Collection<Part> getPartsByPartType(PartType partType) throws SQLException;
	
	public Collection<Part> getPartsByComputer(Computer computer) throws SQLException;

	public void deletePart(Part part) throws SQLException;


}
