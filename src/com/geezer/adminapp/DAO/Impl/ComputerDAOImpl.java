package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.geezer.adminapp.DAO.ComputerDAO;
import com.geezer.adminapp.orm.Assemble;
import com.geezer.adminapp.orm.Computer;
import com.geezer.adminapp.orm.User;
import com.geezer.adminapp.util.HibernateUtil;

public class ComputerDAOImpl implements ComputerDAO {

	@Override
	public void addComputer(Computer computer) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(computer);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	@Override
	public void updateComputer(Long computer_id, Computer computer)
			throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(computer);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public Computer getComputerById(Long computer_id) throws SQLException {
		Session session = null;
	    Computer computer = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      computer = (Computer) session.load(Computer.class, computer_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return computer;
	}

	@Override
	public Collection<Computer> getAllComputers() throws SQLException {
		Session session = null;
	    List<Computer> computers = new ArrayList<Computer>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      computers =(List<Computer>) session.createCriteria(Computer.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return computers;
	}

	@Override
	public Collection<Computer> getComputersByUser(User user)
			throws SQLException {
		Session session = null;
	    List<Computer> computers = new ArrayList<Computer>();
	    try {
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();
	      Integer user_id = user.getUserId();
	      Query query = session.createQuery(
	          " select c "
	              + " from Computer c INNER JOIN c.user user"
	              + " where user.userID = :user_Id "
	      )
	          .setInteger("user_Id", user_id);
	      computers = (List<Computer>) query.list();
	      session.getTransaction().commit();

	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return computers;
	}

	@Override
	public void deleteComputer(Computer computer) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(computer);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

}
