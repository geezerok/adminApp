package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.geezer.adminapp.DAO.LoginDAO;
import com.geezer.adminapp.orm.Login;
import com.geezer.adminapp.orm.Login;
import com.geezer.adminapp.util.HibernateUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public void addLogin(Login login) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(login);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public void updateLogin(Long login_id, Login login) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(login);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public Login getLoginById(Long login_id) throws SQLException {
		Session session = null;
	    Login login = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      login = (Login) session.load(Login.class, login_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return login;
	}

	@Override
	public Collection<Login> getAllLogins() throws SQLException {
		Session session = null;
	    List<Login> logins = new ArrayList<Login>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      logins =(List<Login>) session.createCriteria(Login.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return logins;
	}

	@Override
	public void deleteLogin(Login login) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(login);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

}
