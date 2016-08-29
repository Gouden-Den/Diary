package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Diary;

public class UpdateDiaryAction extends ActionSupport {
	private DiaryService diaryService;
	private String content;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Diary diary = (Diary) session.getAttribute("diary");
		if(diary==null){
			System.out.println("1");
		}
		diary.setContent(content);
		diaryService.updateDiary(diary);
		request.setAttribute("message", "更新日记成功！！");
		return "success";
	}
	
	public DiaryService getDiaryService() {
		return diaryService;
	}
	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
