package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.geezer.adminapp.DAO.PartTypeDAO;
import com.geezer.adminapp.orm.PartType;
import com.geezer.adminapp.orm.PartType;
import com.geezer.adminapp.util.HibernateUtil;

public class PartTypeDAOImpl implements PartTypeDAO {

	@Override
	public void addPartType(PartType partType) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(partType);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public void updatePartType(Long partType_id, PartType partType)
			throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(partType);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public PartType getPartTypeById(Long partType_id) throws SQLException {
		Session session = null;
	    PartType partType = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      partType = (PartType) session.load(PartType.class, partType_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return partType;
	}

	@Override
	public Collection<PartType> getAllPartTypes() throws SQLException {
		Session session = null;
	    List<PartType> partTypes = new ArrayList<PartType>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      partTypes =(List<PartType>) session.createCriteria(PartType.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return partTypes;
	}

	@Override
	public void deletePartType(PartType partType) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(partType);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

}
