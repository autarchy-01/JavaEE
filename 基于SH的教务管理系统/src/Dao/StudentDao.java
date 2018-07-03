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
	 * 登录方法
	 * @param stu 封装了id和password属性的Student对象
	 * @return boolean
	 */
	public boolean stuLogin(Student stu) {
		if(stu.getStuId()!=null&&stu.getPassword()!=null){
			session=HibernateSessionFactory.getSession();
			try {
				String hql="from Student as s where stuId='"+stu.getStuId()+"'and password='"+stu.getPassword()+"'";
				query=(Query)session.createQuery(hql);
				Student s=(Student)query.uniqueResult();
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
	 * 设置email
	 * @param stuId 学生id
	 * @param email 要设置的email
	 * @return boolean
	 */
	public boolean setEmail(int stuId,String email) {
		try {
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			Student stu=(Student)session.get(Student.class, stuId);
			stu.setEmail(email);
			session.update(stu);
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
	 * 获取一条Student记录
	 * @param stuId 要获取的id号
	 * @return Student对象
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
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * 返回必修课成绩等信息
	 * @param stuId 学生id
	 * @return list集合
	 */
	public List getRequiredScore(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select c.couId,c.couName,t.username,c.mark,s.score from Course c,Teacher t,Selclass s where s.id.stuId="+stuId+"and s.id.couId=c.couId and t.teaId=c.teaId and c.typ='必修'";
			query=session.createQuery(hql);
			List list=query.list();
			session.close();
			return list;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * 修改学生密码
	 * @param stuId 学生id
	 * @param password 新密码
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
			e.printStackTrace();
			return false;
			}
		}
	/**
	 * 获得所有选修课记录
	 * @return list
	 */
	public List getElective() {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select new Course(c.couId,c.couName,c.max) from Course c where typ='选修'";
			query=session.createQuery(hql);
			List list=query.list();
			session.close();
			return list;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * 获取已选修这门课的人数
	 * @param couId 课程号
	 * @return 人数
	 */
	public int getNumber(int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="from Selclass s where s.id.couId="+couId;
			query=session.createQuery(hql);
			if(query.list()!=null){
				int count=query.list().size();
				session.close();
				return count;
				}
			session.close();
			return 0;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return 0;
			}
		}
	/**
	 * 保存学生选课
	 * @param stuId 学生id
	 * @param couId 课程号
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
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 获取指定学生的选课信息
	 * @param stuId 学生id
	 * @return list集合
	 */
	public List lookElective(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select new Course(c.couId,c.couName,c.max,c.room,c.time) from Course c,Selclass s where typ='选修' and s.id.couId=c.couId and s.id.stuId="+stuId;
			query=session.createQuery(hql);
			List list=query.list();
			session.close();
			return list;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * 判断该学生是否选修这门课
	 * @param stuId 学生id
	 * @param couId 课程号
	 * @return boolean
	 */
	public boolean judgeElective(int stuId,int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="from Selclass s where s.id.stuId="+stuId+" and s.id.couId="+couId;
			query=session.createQuery(hql);
			List list=query.list();
			if(list.size()!=0){
				session.close();
				return true;
				}
			session.close();
			return false;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return false;
			}
		}
	/**
	 * 返回一条Course记录
	 * @param couId 指定的课程号
	 * @return Course对象
	 */
	public Course getCourse(int couId) {
		try {
			session=HibernateSessionFactory.getSession();
			Course cou=session.get(Course.class, couId);
			session.close();
			return cou;
			} catch (Exception e) {
			if(session!=null){
				session.close();
			}
			e.printStackTrace();
			return null;
			}
		}
	/**
	 * 返回该学生选课数
	 * @param stuId 学生id
	 * @return int
	 */
	public int getElectiveNumber(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="from Selclass s,Course c where c.typ='选修' and s.id.couId=c.couId and s.id.stuId="+stuId;
			query=session.createQuery(hql);
			if(query.list()!=null){
				int count=query.list().size();
				session.close();
				return count;
				}
			session.close();
			return 0;
			} catch (Exception e) {
			if(session!=null){
				session.close();
				}
			e.printStackTrace();
			return 0;
			}
		}
	/**
	 * 返回选修课成绩
	 * @param stuId 学生id
	 * @return list
	 */
	public List getElectiveMessage(int stuId) {
		try {
			session=HibernateSessionFactory.getSession();
			String hql="select c.couId,c.couName,c.mark,s.score from Selclass s,Course c where c.typ='选修' and s.id.couId=c.couId and s.id.stuId="+stuId;
			query=session.createQuery(hql);
			List list=query.list();
			session.close();
			return list;
			} catch (Exception e) {
				if(session!=null){
					session.close();
					}
				e.printStackTrace();
				return null;
				}
		}
	}
