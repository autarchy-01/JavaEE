package studentAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;

public class setElectiveAction extends ActionSupport{
	private HttpServletRequest request;
	private Integer radiobutton;
	public Integer getRadiobutton() {
		return radiobutton;
	}
	public void setRadiobutton(Integer radiobutton) {
		this.radiobutton = radiobutton;
	}
	public String execute() throws Exception{
		StudentDao dao=new StudentDao();
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		//�ж�ѡ�������Ƿ񳬹���ѡ�����ѡ������
		if(dao.getNumber(getRadiobutton())<dao.getCourse(getRadiobutton()).getMax()){
			//�жϸ�ѧ���Ƿ��Ѿ�ѡ���˸�ѡ�޿�
			if(!dao.judgeElective((Integer)session.getAttribute("id"), getRadiobutton())){
				//�жϸ�ѡ�μ�¼�Ƿ񱣴�ɹ�
				if(dao.setElective((Integer)session.getAttribute("id"), getRadiobutton())){
					return SUCCESS;
					}
				}			
		}
		return INPUT;
		}
	}
