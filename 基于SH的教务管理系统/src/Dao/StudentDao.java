package Dao;
import java.util.List;

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
	/**
	 * ��¼����
	 * @param stu ��װ��id��password���Ե�Student����
	 * @return boolean
	 */
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
				if(session!=null){
					session.close();
					}
				System.out.println("��ѯʧ��"+e);
				}
			}
		return false;
		}
	/**
	 * ��ȡһ��Student��¼
	 * @param stuId Ҫ��ȡ��id��
	 * @return Student����
	 */
	public Student getStudent(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			Student student=(Student)session.get(Student.class, stuId);
			session.close();
			return student;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getTeacher.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * ���ر��޿γɼ�����Ϣ
	 * @param stuId ѧ��id
	 * @return list����
	 */
	public List getRequiredScore(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select c.couId,c.couName,t.username,c.mark,s.score from Course c,Teacher t,Selclass s where s.id.stuId="+stuId+"and s.id.couId=c.couId and t.teaId=c.teaId and c.typ='����'";
			query=session.createQuery(hql);
			List list=query.list();
			session.close();
			return list;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getTeacher.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * �޸�ѧ������
	 * @param stuId ѧ��id
	 * @param password ������
	 * @return boolean
	 */
	public boolean changePwd(int stuId,String password) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Student stu=(Student)session.get(Student.class, stuId);
			stu.setPassword(password);
			session.update(stu);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("changePwd.erro"+e);
			e.printStackTrace();
			return false;
			}
		}
	/**
	 * �������ѡ�޿μ�¼
	 * @return list
	 */
	public List getElective() {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select new Course(c.couId,c.couName,c.max) from Course c where typ='ѡ��'";
			query=session.createQuery(hql);
			List list=query.list();
			session.close();
			return list;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getElective.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * ��ȡ��ѡ�����ſε�����
	 * @param couId �γ̺�
	 * @return ����
	 */
	public int getNumber(int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="from Selclass s where s.id.couId="+couId;
			query=session.createQuery(hql);
			if(query.list()!=null){
				int count=query.list().size();
				return count;
				}
			return 0;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getNumber.erro"+e);
			e.printStackTrace();
			return 0;
			}
		}
	/**
	 * ����ѧ��ѡ��
	 * @param stuId ѧ��id
	 * @param couId �γ̺�
	 * @return boolean
	 */
	public boolean setElective(int stuId,int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			SelclassId id=new SelclassId(stuId, couId);
			Selclass sel=new Selclass(id);
			session.save(sel);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("setElective.erro"+e);
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ��ȡָ��ѧ����ѡ����Ϣ
	 * @param stuId ѧ��id
	 * @return list����
	 */
	public List lookElective(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select new Course(c.couId,c.couName,c.max,c.room,c.time) from Course c,Selclass s where typ='ѡ��' and s.id.couId=c.couId and s.id.stuId="+stuId;
			query=session.createQuery(hql);
			List list=query.list();
			return list;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("lookElective.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * �жϸ�ѧ���Ƿ�ѡ�����ſ�
	 * @param stuId ѧ��id
	 * @param couId �γ̺�
	 * @return boolean
	 */
	public boolean judgeElective(int stuId,int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="from Selclass s where s.id.stuId="+stuId+" and s.id.couId="+couId;
			query=session.createQuery(hql);
			List list=query.list();
			if(list.size()!=0){
				return true;
				}
			return false;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("lookElective.erro"+e);
			e.printStackTrace();
			return false;
			}
		}
	/**
	 * ����һ��Course��¼
	 * @param couId ָ���Ŀγ̺�
	 * @return Course����
	 */
	public Course getCourse(int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			Course cou=session.get(Course.class, couId);
			return cou;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getCourse.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * ���ظ�ѧ��ѡ����
	 * @param stuId ѧ��id
	 * @return int
	 */
	public int getElectiveNumber(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="from Selclass s,Course c where c.typ='ѡ��' and s.id.couId=c.couId and s.id.stuId="+stuId;
			query=session.createQuery(hql);
			if(query.list()!=null){
				int count=query.list().size();
				return count;
				}
			return 0;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getElectiveNumber.erro"+e);
			e.printStackTrace();
			return 0;
			}
		}
	/**
	 * ����ѡ�޿γɼ�
	 * @param stuId ѧ��id
	 * @return list
	 */
	public List getElectiveMessage(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select c.couId,c.couName,c.mark,s.score from Selclass s,Course c where c.typ='ѡ��' and s.id.couId=c.couId and s.id.stuId="+stuId;
			query=session.createQuery(hql);
			List list=query.list();
			return list;
		} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getElectiveNumber.erro"+e);
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
