package Dao;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.*;
import addHibernateFile.*;

public class StudentDao {
	private Session session;
	private Transaction transaction;
	private Query query;
	public boolean stuLogin(Student stu) {
		if(stu.getStuId()!=null&&stu.getPassword()!=null){
			session=HibernateSessionFactory.getSession();
			try {
				String hql="from Student as s where stuId='"+stu.getStuId()+"'and password='"+stu.getPassword()+"'";
				Query query=(Query)session.createQuery(hql);
				Student s=(Student)query.uniqueResult();
				if(s!=null){
					session.close();
					return true;
				}
			} catch (Exception e) {
				System.out.println("��ѯʧ��"+e);
			}
		}
		return false;
		
	}
	public Student getStudent(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			Student student=(Student)session.get(Student.class, stuId);
			session.close();
			return student;
		} catch (Exception e) {
			message("getTeacher.erro"+e);
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * ������ʾ
	 * @param mess 
	 */
	public static void message(String mess) {
		int type=JOptionPane.YES_NO_OPTION;
		String title ="��ʾ��Ϣ";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
}
