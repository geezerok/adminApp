package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.geezer.adminapp.DAO.ComputerTypeDAO;
import com.geezer.adminapp.orm.ComputerType;
import com.geezer.adminapp.orm.ComputerType;
import com.geezer.adminapp.util.HibernateUtil;

public class ComputerTypeDAOImpl implements ComputerTypeDAO {

	@Override
	public void addComputerType(ComputerType computerType) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(computerType);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	@Override
	public void updateComputerType(Long computerType_id,
			ComputerType computerType) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(computerType);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public ComputerType getComputerTypeById(Long computerType_id)
			throws SQLException {
		Session session = null;
	    ComputerType computerType = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      computerType = (ComputerType) session.load(ComputerType.class, computerType_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return computerType;
	}

	@Override
	public Collection<ComputerType> getAllComputerTypes() throws SQLException {
		Session session = null;
	    List<ComputerType> computerTypes = new ArrayList<ComputerType>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      computerTypes =(List<ComputerType>) session.createCriteria(ComputerType.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return computerTypes;
	}

	@Override
	public void deleteComputerType(ComputerType computerType)
			throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(computerType);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

}
