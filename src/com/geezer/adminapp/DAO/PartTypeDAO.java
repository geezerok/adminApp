package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.PartType;

public interface PartTypeDAO {
	
	public void addPartType(PartType partType) throws SQLException;

	public void updatePartType(Long partType_id, PartType partType) throws SQLException;

	public PartType getPartTypeById(Long partType_id) throws SQLException;
	
	

	public Collection<PartType> getAllPartTypes() throws SQLException;
		
	public void deletePartType(PartType partType) throws SQLException;

}
