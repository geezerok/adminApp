package com.geezer.adminapp.DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.geezer.adminapp.DAO.DepartmentDAO;
import com.geezer.adminapp.orm.Department;
import com.geezer.adminapp.orm.Department;
import com.geezer.adminapp.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void addDepartment(Department department) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(department);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	@Override
	public void updateDepartment(Long department_id, Department department)
			throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(department);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public Department getDepartmentById(Long department_id) throws SQLException {
		Session session = null;
	    Department department = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      department = (Department) session.load(Department.class, department_id);
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return department;
	}

	@Override
	public Collection<Department> getAllDepartments() throws SQLException {
		Session session = null;
	    List<Department> departments = new ArrayList<Department>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      departments =(List<Department>) session.createCriteria(Department.class).list();
	    } catch (Exception e) {
	   
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return departments;
	}

	@Override
	public void deleteDepartment(Department department) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.delete(department);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }


	}

}
