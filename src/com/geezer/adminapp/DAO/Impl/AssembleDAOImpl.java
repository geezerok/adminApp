package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.geezer.adminapp.DAO.AssembleDAO;
import com.geezer.adminapp.orm.Assemble;
import com.geezer.adminapp.util.HibernateUtil;

public class AssembleDAOImpl implements AssembleDAO {

	@Override
	public void addAssemble(Assemble assemble) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(assemble);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
		

	}

	@Override
	public void updateAssemble(Long assemble_no, Assemble assemble)
			throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(assemble);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public Assemble getAssembleById(Long assemble_id) throws SQLException {
		Session session = null;
	    Assemble assemble = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      assemble = (Assemble) session.load(Assemble.class, assemble_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return assemble;
	}

	@Override
	public Collection<Assemble> getAllAssembles() throws SQLException {
		Session session = null;
	    List<Assemble> assembles = new ArrayList<Assemble>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      assembles =(List<Assemble>) session.createCriteria(Assemble.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return assembles;
	}

	@Override
	public void deleteAssemble(Assemble assemble) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(assemble);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

}
