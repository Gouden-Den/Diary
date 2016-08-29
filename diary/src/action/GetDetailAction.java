package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Diary;
import domain.User;

public class GetDetailAction extends ActionSupport {
	private DiaryService diaryService;
	private Diary diary;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int diaryid = Integer.parseInt(request.getParameter("diaryid"));
		diary = diaryService.getDiary(diaryid);
		session.setAttribute("diary", diary);
		return "success";
	}

	public DiaryService getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}

	public Diary getDiary() {
		return diary;
	}

	public void setDiary(Diary diary) {
		this.diary = diary;
	}
}
