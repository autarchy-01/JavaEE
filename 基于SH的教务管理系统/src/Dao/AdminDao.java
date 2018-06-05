package Dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.*;
import addHibernateFile.*;

public class AdminDao {
	private Session session;
	private Transaction transaction;
	private Query query;
	public boolean admLogin(Admin adm) {
		if(adm.getAdmId()!=null&&adm.getPassword()!=null){
			session=HibernateSessionFactory.getSession();
			try {
				String hql="from Admin as s where admId='"+adm.getAdmId()+"'and password='"+adm.getPassword()+"'";
				Query query=(Query)session.createQuery(hql);
				Admin s=(Admin)query.uniqueResult();
				if(s!=null){
					session.close();
					return true;
				}
			} catch (Exception e) {
				System.out.println("≤È—Ø ß∞‹"+e);
			}
		}
		return false;
		
	}

}
