package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;

import com.opensymphony.xwork2.ActionSupport;

public class GetDiariesAction extends ActionSupport {
	private DiaryService diaryService;
	private List diaries;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int month = Integer.parseInt(request.getParameter("month"));
		diaries = diaryService.getDiaryByMonth(month);
		
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
