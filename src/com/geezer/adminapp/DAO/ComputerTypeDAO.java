package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;


import com.geezer.adminapp.orm.ComputerType;

public interface ComputerTypeDAO {
	
	public void addComputerType(ComputerType computerType) throws SQLException;

	public void updateComputerType(Long computerType_id, ComputerType computerType) throws SQLException;

	public ComputerType getComputerTypeById(Long computerType_id) throws SQLException;

	public Collection<ComputerType> getAllComputerTypes() throws SQLException;
	
	public void deleteComputerType(ComputerType computerType) throws SQLException;


}
