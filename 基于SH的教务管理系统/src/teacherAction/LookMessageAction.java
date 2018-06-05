package teacherAction;
import Dao.*;
import paging.GetPage;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import paging.PageBean;
public class LookMessageAction extends ActionSupport{
private GetPage get = new GetPage();
    
    private int page;
	public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    @Override
    public String execute() throws Exception
    {
        //表示每页显示5条记录，page表示当前网页
        PageBean pageBean = get.getPageBean(1, page);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("pageList", pageBean.getList());
        request.setAttribute("pageBean", pageBean);
        
        return SUCCESS;
    }

}
