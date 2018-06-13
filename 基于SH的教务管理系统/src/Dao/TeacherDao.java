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
	 * 登录方法
	 * @param tea 封装了id和password属性的Teacher对象
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
				System.out.println("查询失败"+e);
				}
			}
		return false;
		}
	/**
	 * 保存成绩
	 * @param score Selclass对象
	 */
	public void saveScore(Selclass score) {
		try{
			session=HibernateSessionFactory.getSession();//获取session
			transaction=session.beginTransaction();//打开事务
			session.save(score);//对象持久化
			transaction.commit();//提交事务
			session.close();//关闭session
			}catch (Exception e) {
			if(session!=null){
				session.close();
				}
			message("saveScore.error:"+e);
			e.printStackTrace();
			}
		}
	/**
	 * 查询学生信息
	 * @param hql 查询语句
	 * @param offset 从第几条记录开始查询
	 * @param pageSize 页面最大记录条数
	 * @return 学生信息的list集合
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
	 * 查询总记录条数
	 * @param hql 查询语句
	 * @return 总记录条数
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
	 * 查询课程信息
	 * @param teaId 登录教师的id
	 * @return 课程信息的list集合
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
	 * 获取一条Teacher的记录
	 * @param teaId 要获取的id号
	 * @return Teacher对象
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
	 * 设置email
	 * @param teaId  教师id
	 * @param email  教师email
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
	 * 修改教师密码
	 * @param teaId 教师id
	 * @param password 新密码
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
	 * 查找成绩
	 * @param id 封装了学号和课程号的SelclassId对象
	 * @return List集合
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
	 * 更新成绩
	 * @param score 封装了成绩,学号,课程号的Selclass对象
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
	 * 报错提示
	 * @param mess 
	 */
	public static void message(String mess) {
		int type=JOptionPane.YES_NO_OPTION;
		String title ="提示信息";
		JOptionPane.showMessageDialog(null, mess,title,type);
		}
	}
