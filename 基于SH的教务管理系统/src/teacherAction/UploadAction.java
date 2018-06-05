package teacherAction;
import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

import jxl.*;
import Dao.*;
import PO.*;
public class UploadAction extends ActionSupport {
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
		SelclassId id=null;
		Selclass cj=null;
		TeacherDao dao=null;
		Sheet sheet;
		Workbook book;
		Cell cell;
		String value="";
		try{
			book=Workbook.getWorkbook(new File(url));
			sheet=book.getSheet(ym-1);
			int rows=sheet.getRows();//��ȡ����
			int clons=sheet.getColumns();//��ȡ����
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
			for(int i=0;i<rows-1;i++){//�Ѷ�ά�����ֵͨ��saveScore�����������ݿ�
				id=new SelclassId(Integer.parseInt(val2[i][0]), Integer.parseInt(val2[i][1]));
				cj=new Selclass(id,Integer.parseInt(val2[i][2]));
				dao=new TeacherDao();
				dao.saveScore(cj);
				dao=null;
				id=null;
				cj=null;
				
			}
			return true;
		}
		catch (Exception e) {
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
