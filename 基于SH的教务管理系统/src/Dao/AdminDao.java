package Dao;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.*;
import addHibernateFile.*;

public class AdminDao {
	private Session session;
	private Transaction transaction;
	private Query query;
	/**
	 * ��¼����
	 * @param adm ��װ��id��password���Ե�Admin����
	 * @return boolean
	 */
	public boolean admLogin(Admin adm) {
		if(adm.getAdmId()!=null&&adm.getPassword()!=null){
			session=HibernateSessionFactory.getSession();
			try {
				String hql="from Admin as s where admId='"+adm.getAdmId()+"'and password='"+adm.getPassword()+"'";
				query=(Query)session.createQuery(hql);
				Admin s=(Admin)query.uniqueResult();		
				if(s!=null){
					session.close();
					return true;
					}
				} catch (Exception e) {
					if(session!=null){
						session.close();
						}
					e.printStackTrace();
					}
			}
		return false;
		}
	/**
	 * �޸Ĺ���Ա����
	 * @param admId ����Աid
	 * @param password ������
	 * @return Boolean
	 */
	public boolean changePwd(int admId,String password) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Admin adm=(Admin)session.get(Admin.class, admId);
			adm.setPassword(password);
			session.update(adm);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return false;
			}
		}
	/**
	 * ��ȡһ��Admin�ļ�¼
	 * @param admId Ҫ��ȡ��id��
	 * @return Admin����
	 */
	public Admin getAdmin(int admId) {
		try {
			session=HibernateSessionFactory.getSession();
			Admin admin=(Admin)session.get(Admin.class, admId);
			session.close();
			return admin;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * ���ѧ��
	 * @param stu ѧ��id
	 * @return Boolean
	 */
	public boolean saveStudent(Student stu) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			session.save(stu);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
				if(session!=null){
					session.close();
					}
				e.printStackTrace();
				}
		return false;
		}
	/**
	 * ����ָ��ѧ��
	 * @param stuId ѧ��id
	 * @return Student����
	 */
	public Student getStudent(int stuId) {
		try {
			String hql="from Student s where s.stuId="+stuId;
			session=HibernateSessionFactory.getSession();
			query=session.createQuery(hql);
			Student s=(Student)query.list().get(0);
			session.close();
			return s;			
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return null;
			}
	}
	/**
	 * �޸�ѧ��
	 * @param stu Student����
	 * @return Boolean
	 */
	public boolean updateStudent(Student stu) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			session.update(stu);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				return false;
				}
			e.printStackTrace();
			return false;
			}
	}
	/**
	 * ɾ��ѧ��
	 * @param stuId ѧ��id
	 */
	public void deleteStudent(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Student student=new Student();
			student=(Student)session.get(Student.class, stuId);
			session.delete(student);
			transaction.commit();
			session.close();		
		} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();		
		}
		
	}
	/**
	 * ��ӽ�ʦ
	 * @param tea ��ʦid
	 * @return Boolean
	 */
	public boolean saveTeacher(Teacher tea) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			session.save(tea);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
				if(session!=null){
					session.close();
					}
				e.printStackTrace();
				}
		return false;
		}
	/**
	 * ����ָ����ʦ
	 * @param teaId ��ʦid
	 * @return ��ʦ����
	 */
	public Teacher getTeacher(int teaId) {
		try {
			String hql="from Teacher t where t.teaId="+teaId;
			session=HibernateSessionFactory.getSession();
			query=session.createQuery(hql);
			Teacher s=(Teacher)query.list().get(0);
			session.close();
			return s;			
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return null;
			}
	}
	/**
	 * �޸Ľ�ʦ
	 * @param tea Teacher����
	 */
	public boolean updateTeacher(Teacher tea) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			session.update(tea);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				};
			e.printStackTrace();
			return false;
			}
	}
	/**
	 * ɾ����ʦ
	 * @param teaId ��ʦid
	 */
	public void deleteTeacher(int teaId) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Teacher teacher=new Teacher();
			teacher=(Teacher)session.get(Teacher.class, teaId);
			session.delete(teacher);
			transaction.commit();
			session.close();
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();		
			}
		}
	}
