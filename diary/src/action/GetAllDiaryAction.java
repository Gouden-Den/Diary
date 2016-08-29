package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class GetAllDiaryAction extends ActionSupport {
	private DiaryService diaryService;
	private List diaries;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		diaries = diaryService.getAllDiaryASC(user.getUserid());
		return "success";
	}

	public DiaryService getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	public List getDiaries() {
		return diaries;
	}

	public void setDiaries(List diaries) {
		this.diaries = diaries;
	}
}
