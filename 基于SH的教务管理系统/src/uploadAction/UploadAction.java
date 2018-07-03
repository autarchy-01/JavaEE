package uploadAction;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jxl.*;
import Dao.*;
import PO.*;
public class UploadAction extends ActionSupport {
	private HttpServletRequest request;
	private String lujin;
	private int yema;
	public String getLujin() {
		return lujin;
	}
	public void setLujin(String lujin) {
		this.lujin = lujin;
	}
	public int getYema() {
		return yema;
	}
	public void setYema(int yema) {
		this.yema = yema;
	}
	public boolean execl(String url,int ym) {
		Sheet sheet;
		Workbook book;
		Cell cell;
		String value="";
		try{
			book=Workbook.getWorkbook(new File(url));
			sheet=book.getSheet(ym-1);
			int rows=sheet.getRows();//��ȡ����
			int clons=sheet.getColumns();//��ȡ����
			System.out.println(rows);
			System.out.println(clons);
			for(int i1=1;i1<rows;i1++){//�ѱ������ݱ������������ַ�����
				for (int j = 0; j < clons; j++) {
					cell = sheet.getCell(j, i1);
					if(j==clons-1&&i1==rows-1){
						value+=cell.getContents();
					}
					else{
						value+=cell.getContents()+",";
					}
				}
			
			}
			book.close();
			String[] val = value.split(",");//���ַ���תΪһά����
			String val2[][]=new String[rows-1][clons];
			for(int i1=0;i1<rows-1;i1++){//��һά����תΪ��ά����
				for(int j=0;j<clons;j++){
					val2[i1][j]=val[i1*clons+j];
				}
			}
			request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			if((Integer)session.getAttribute("radiobutton")==2){
				SelclassId id=null;
				Selclass cj=null;
				TeacherDao dao=null;
				for(int i=0;i<rows-1;i++){//�Ѷ�ά�����ֵͨ��saveScore�����������ݿ�
					id=new SelclassId(Integer.parseInt(val2[i][0]), Integer.parseInt(val2[i][1]));
					cj=new Selclass(id,Integer.parseInt(val2[i][2]));
					dao=new TeacherDao();
					dao.saveScore(cj);
					dao=null;
					id=null;
					cj=null;
					}
				}else if ((Integer)session.getAttribute("radiobutton")==3) {
					Student stu=null;
					AdminDao dao=null;
					for(int i=0;i<rows-1;i++){//�Ѷ�ά�����ֵͨ��saveScore�����������ݿ�
						stu=new Student(Integer.parseInt(val2[i][0]), val2[i][1], val2[i][2], val2[i][3], val2[i][4], val2[i][5], val2[i][6], val2[i][7], val2[i][8], Integer.parseInt(val2[i][9]));
						dao=new AdminDao();
						dao.saveStudent(stu);
						dao=null;
						stu=null;
						}
					
				}
			return true;
			}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public String execute() throws Exception{
		if(execl(getLujin(),getYema())){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	

}
