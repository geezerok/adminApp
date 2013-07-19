package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.geezer.adminapp.DAO.PartDAO;
import com.geezer.adminapp.orm.Computer;
import com.geezer.adminapp.orm.Part;
import com.geezer.adminapp.orm.Part;
import com.geezer.adminapp.orm.PartType;
import com.geezer.adminapp.util.HibernateUtil;

public class PartDAOImpl implements PartDAO {

	@Override
	public void addPart(Part part) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(part);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }


	}

	@Override
	public void updatePart(Long part_id, Part part) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(part);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public Part getPartById(Long part_id) throws SQLException {
		Session session = null;
	    Part part = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      part = (Part) session.load(Part.class, part_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return part;
	}

	@Override
	public Collection<Part> getAllParts() throws SQLException {
		Session session = null;
	    List<Part> parts = new ArrayList<Part>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      parts =(List<Part>) session.createCriteria(Part.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return parts;
	}

	@Override
	public Collection<Part> getPartsByManufacturer(String manufacturer)
			throws SQLException {
		Session session = null;
	    List<Part> parts = new ArrayList<Part>();
	    try {
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      Query query = session.createQuery(
	          " select p "
	              + " from Part p"
	              + " where p.manufacturer = :manufacturer "
	      )
	          .setString("manufacturer", manufacturer);
	      parts = (List<Part>) query.list();
	      session.getTransaction().commit();

	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return parts;
	}

	@Override
	public Collection<Part> getPartsByPartType(PartType partType)
			throws SQLException {
		Session session = null;
	    List<Part> parts = new ArrayList<Part>();
	    try {
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Integer partType_id = partType.getTypeId();
	      session.beginTransaction();
	      Query query = session.createQuery(
	          " select p "
	              + " from Part p INNER JOIN p.partype parttype"
	              + " where parttype.typeId = :typeId "
	      )
	          .setInteger("typeId", partType_id);
	      parts = (List<Part>) query.list();
	      session.getTransaction().commit();

	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return parts;
	}

	@Override
	public Collection<Part> getPartsByComputer(Computer computer)
			throws SQLException {
		Session session = null;
	    List<Part> parts = new ArrayList<Part>();
	    try {
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Integer computer_id = computer.getComputerId();
	      session.beginTransaction();
	      Query query = session.createQuery(
	    		  " select p "
	    	              + " from Part p INNER JOIN p.computer computer"
	    	              + " where computer.computerId = :compId "
	      )
	          .setInteger("compId", computer_id);
	      parts = (List<Part>) query.list();
	      session.getTransaction().commit();

	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return parts;
	}

	@Override
	public void deletePart(Part part) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(part);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

}
