package com.yeren.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yeren.dao.UserDao;
import com.yeren.mode.User;
@Repository
public class UserDaoImpl implements UserDao{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sf;
	
	
	public boolean save(User user) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean delete(Integer id) {
		Session session = sf.openSession();
		Transaction tx = null;
		int executeUpdate = 0;
		try {
			tx = session.beginTransaction();
			String hql = "delete from User where id=:id";
			org.hibernate.Query query = session.createQuery(hql);
			query.setInteger("id", id);
			executeUpdate = query.executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean update(User user) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public User findById(Integer id) {
		
		
		
		Session session = sf.openSession();
		List<User> list = null;
		try {
			String hql = "from User where id=:id";
			org.hibernate.Query query = session.createQuery(hql);
			query.setInteger("id", id);
			list = query.list();
			return list.get(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
