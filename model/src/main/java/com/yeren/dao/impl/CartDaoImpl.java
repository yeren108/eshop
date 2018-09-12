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

import com.yeren.dao.CartDao;
import com.yeren.mode.Cart;
@Repository
public class CartDaoImpl implements CartDao{
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sf;
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);
	
	public boolean save(Cart cart) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(cart);
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
			String hql = "delete from Cart where id=:id";
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

	public boolean update(Cart cart) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(cart);
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

	public Cart findById(Integer id) {
		Session session = sf.openSession();
		List<Cart> list = null;
		try {
			String hql = "from Cart where id=:id";
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
