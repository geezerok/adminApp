package com.geezer.adminapp.hibernate;

// Generated Jul 9, 2013 3:22:56 PM by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Parttype.
 * @see com.geezer.adminapp.hibernate.Parttype
 * @author Hibernate Tools
 */
public class ParttypeHome {

	private static final Log log = LogFactory.getLog(ParttypeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Parttype transientInstance) {
		log.debug("persisting Parttype instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Parttype instance) {
		log.debug("attaching dirty Parttype instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Parttype instance) {
		log.debug("attaching clean Parttype instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Parttype persistentInstance) {
		log.debug("deleting Parttype instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Parttype merge(Parttype detachedInstance) {
		log.debug("merging Parttype instance");
		try {
			Parttype result = (Parttype) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Parttype findById(java.lang.Integer id) {
		log.debug("getting Parttype instance with id: " + id);
		try {
			Parttype instance = (Parttype) sessionFactory.getCurrentSession()
					.get("com.geezer.adminapp.hibernate.Parttype", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Parttype instance) {
		log.debug("finding Parttype instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.geezer.adminapp.hibernate.Parttype")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
