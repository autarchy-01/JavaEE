package pagingAction;
import Dao.*;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class LookMessageAction extends ActionSupport{
	private GetPage get = new GetPage();
    private HttpServletRequest request;
    private int page;
    private int a;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getPage()
    {
        return page;
    }
    public void setPage(int page)
    {
        this.page = page;
    }

    @Override
    public String execute() throws Exception{
    	HttpServletRequest request = ServletActionContext.getRequest();
    	if(Integer.parseInt(request.getParameter("a"))==1||getA()==1){
            //表示每页显示5条记录，page表示当前网页
            PageBean pageBean = get.getPageBean1(1, page);        
            request.getSession().setAttribute("pageList", pageBean.getList());
            request.setAttribute("pageBean", pageBean);
            return "tea";
            }
    	else {
                //表示每页显示5条记录，page表示当前网页
                PageBean pageBean = get.getPageBean(1, page);        
                request.getSession().setAttribute("pageList", pageBean.getList());
                request.setAttribute("pageBean", pageBean);
                HttpSession session=request.getSession();
                if ((Integer)session.getAttribute("radiobutton")==2){
                	return "teacher";
                }else if ((Integer)session.getAttribute("radiobutton")==3) {
        			return "admin";
        		}
                return INPUT;
    		}
    	}
    }
