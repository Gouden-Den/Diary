package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class GetDiaryByMonthAction extends ActionSupport {
	private DiaryService diaryService;
	private List months;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		months = new ArrayList();
		for(int i = 1; i < 12; i++){
			List list = diaryService.getDiaryByMonth(i);
			if(list.size() > 0){
				months.add(String.valueOf(i));
			}
		}
		
		return "success";
	}

	public List getMonths() {
		return months;
	}

	public void setMonths(List months) {
		this.months = months;
	}

	public DiaryService getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

}
