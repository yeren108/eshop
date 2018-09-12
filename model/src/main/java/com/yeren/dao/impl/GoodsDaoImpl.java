package com.yeren.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yeren.dao.GoodsDao;
import com.yeren.mode.Goods;
@Repository
public class GoodsDaoImpl implements GoodsDao{
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sf;
	private static final Logger logger = LoggerFactory.getLogger(GoodsDaoImpl.class);
	
	public boolean save(Goods goods) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(goods);
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
	
	public boolean update(Goods goods){
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(goods);
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
	
	
	public Goods findById(Integer id){
		Session session = sf.openSession();
		List<Goods> list = null;
		try {
			String hql = "from Goods where id=:id";
			org.hibernate.Query query = session.createQuery(hql);
			query.setInteger("id", id);
			query.setLockMode("Goods",LockMode.PESSIMISTIC_READ); // 加锁
			list = query.list();
			return list.get(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}



	public boolean delete(Integer id) {
		Session session = sf.openSession();
		Transaction tx = null;
		int executeUpdate = 0;
		try {
			tx = session.beginTransaction();
			String hql = "delete from Goods where id=:id";
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


	/*public List<Goods> findAll() {
		Session session = sf.openSession();
		List<Goods> list = null;
		try {
			String hql = "from Goods";
			org.hibernate.Query query = session.createQuery(hql);
			query.setLockMode("Goods",LockMode.PESSIMISTIC_READ); // 加锁
			list = query.list();
			return list;
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}*/
	
	
}
