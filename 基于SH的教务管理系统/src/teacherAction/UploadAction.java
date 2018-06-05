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
			int rows=sheet.getRows();//获取行数
			int clons=sheet.getColumns();//获取列数
			for(int i1=1;i1<rows;i1++){//把表中数据遍历出来存入字符串中
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
			String[] val = value.split(",");//把字符串转为一维数组
			String val2[][]=new String[rows-1][clons];
			for(int i1=0;i1<rows-1;i1++){//把一维数组转为二维数组
				for(int j=0;j<clons;j++){
					val2[i1][j]=val[i1*clons+j];
				}
			}
			for(int i=0;i<rows-1;i++){//把二维数组的值通过saveScore方法存入数据库
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
