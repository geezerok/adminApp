package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.geezer.adminapp.DAO.UserDAO;

import com.geezer.adminapp.orm.Department;
import com.geezer.adminapp.orm.User;
import com.geezer.adminapp.orm.User;
import com.geezer.adminapp.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(user);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public void updateUser(Long user_id, User user) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(user);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public User getUserById(Long user_id) throws SQLException {
		Session session = null;
	    User user = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      user = (User) session.load(User.class, user_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return user;
	}

	@Override
	public Collection<User> getUsersByDepartment(Department department)
			throws SQLException {
		Session session = null;
	    List<User> users = new ArrayList<User>();
	    try {
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Integer department_id = department.getDepartmentId();
	      session.beginTransaction();
	      Query query = session.createQuery(
	          " select u "
	              + " from User u INNER JOIN u.department department"
	              + " where department.departmentId = :depId "
	      )
	          .setInteger("depId", department_id);
	      users = (List<User>) query.list();
	      session.getTransaction().commit();

	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return users;
	}

	@Override
	public User getUserByAliasName(String aliasname) throws SQLException {
		Session session = null;
	    User user = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      user = (User) session.load(User.class, aliasname);

	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return user;
	}

	@Override
	public Collection<User> getAllUsers() throws SQLException {
		Session session = null;
	    List<User> users = new ArrayList<User>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      users =(List<User>) session.createCriteria(User.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return users;
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(user);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }


	}

}
