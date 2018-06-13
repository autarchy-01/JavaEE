package Dao;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.*;
import addHibernateFile.*;

public class TeacherDao {
	private Session session;
	private Transaction transaction;
	private Query query;
	/**
	 * ��¼����
	 * @param tea ��װ��id��password���Ե�Teacher����
	 * @return boolean
	 */
	public boolean teaLogin(Teacher tea) {
		if(tea.getTeaId()!=null&&tea.getPassword()!=null){
			session=HibernateSessionFactory.getSession();
			try {
				String hql="from Teacher as s where teaId='"+tea.getTeaId()+"'and password='"+tea.getPassword()+"'";
				Query query=(Query)session.createQuery(hql);
				Teacher s=(Teacher)query.uniqueResult();
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
	 * ����ɼ�
	 * @param score Selclass����
	 */
	public void saveScore(Selclass score) {
		try{
			session=HibernateSessionFactory.getSession();//��ȡsession
			transaction=session.beginTransaction();//������
			session.save(score);//����־û�
			transaction.commit();//�ύ����
			session.close();//�ر�session
			}catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("saveScore.error:"+e);
			e.printStackTrace();
			}
		}
	/**
	 * ��ѯѧ����Ϣ
	 * @param hql ��ѯ���
	 * @param offset �ӵڼ�����¼��ʼ��ѯ
	 * @param pageSize ҳ������¼����
	 * @return ѧ����Ϣ��list����
	 */
	public List queryByPage(String hql, int offset, int pageSize) {
		session=HibernateSessionFactory.getSession();
		List list = null;
		try{
			query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			list=query.list();
			session.close();
			}catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("findInfo.erro"+e);
			e.printStackTrace();
			return null;
			}
		return list;
		}
	/**
	 * ��ѯ�ܼ�¼����
	 * @param hql ��ѯ���
	 * @return �ܼ�¼����
	 */
	public int getAllRowCount(String hql) {
		int studentAmount=0;
		session=HibernateSessionFactory.getSession();
		int allRows = 0;
		try{
			query=session.createQuery(hql);
			allRows = query.list().size();
			session.close();
			}catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getStudentAmount.erro"+e);
			e.printStackTrace();
			return studentAmount;
			}
		return allRows;
		}
	/**
	 * ��ѯ�γ���Ϣ
	 * @param teaId ��¼��ʦ��id
	 * @return �γ���Ϣ��list����
	 */
	public List findCourse(int teaId) {
		session=HibernateSessionFactory.getSession();
		try{
			String queryString="select c.time,c.couName,c.room from Course c where c.teaId="+teaId;
			query=session.createQuery(queryString);
			List list=query.list();
			session.close();
			return list;
			}catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("findCourse.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * ��ȡһ��Teacher�ļ�¼
	 * @param teaId Ҫ��ȡ��id��
	 * @return Teacher����
	 */
	public Teacher getTeacher(int teaId) {
		try {
			session=HibernateSessionFactory.getSession();
			Teacher teacher=(Teacher)session.get(Teacher.class, teaId);
			session.close();
			return teacher;
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
	 * ����email
	 * @param teaId  ��ʦid
	 * @param email  ��ʦemail
	 * @return boolean
	 */
	public boolean setEmail(int teaId,String email) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Teacher tea=(Teacher)session.get(Teacher.class, teaId);
			tea.setEmail(email);
			session.update(tea);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("setEmail.erro"+e);
			e.printStackTrace();
			return false;
			}
		}
	/**
	 * �޸Ľ�ʦ����
	 * @param teaId ��ʦid
	 * @param password ������
	 * @return boolean
	 */
	public boolean changePwd(int teaId,String password) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Teacher tea=(Teacher)session.get(Teacher.class, teaId);
			tea.setPassword(password);
			session.update(tea);
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
	 * ���ҳɼ�
	 * @param id ��װ��ѧ�źͿγ̺ŵ�SelclassId����
	 * @return List����
	 */
	public Selclass getScore(SelclassId id) {
		try {
			String hql="from Selclass s where s.id.stuId="+id.getStuId()+"and s.id.couId="+id.getCouId();
			session=HibernateSessionFactory.getSession();
			query=session.createQuery(hql);
			Selclass s=(Selclass)query.list().get(0);
			session.close();
			return s;			
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("getScore.erro"+e);
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * ���³ɼ�
	 * @param score ��װ�˳ɼ�,ѧ��,�γ̺ŵ�Selclass����
	 * @return boolean
	 */
	public boolean updateScore(Selclass score) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			session.update(score);
			transaction.commit();
			session.close();
			return true;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("updateScore.erro"+e);
			e.printStackTrace();
			return false;
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
