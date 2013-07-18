package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Assemble;

public interface AssembleDAO {
	public void addAssemble(Assemble assemble) throws SQLException;

	public void updateAssemble(Long assemble_no, Assemble assemble) throws SQLException;

	public Assemble getAssembleById(Long assemble_id) throws SQLException;

	public Collection<Assemble> getAllAssembles() throws SQLException;

	public void deleteAssemble(Assemble assemble) throws SQLException;

	

	

}
