package action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Diary;
import domain.User;

public class WriteDiaryAction extends ActionSupport {
	private DiaryService diaryService;
	private String content;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			return "input";
		}
		Diary diary = new Diary();
		diary.setContent(content);
		diary.setCreateTime(new Timestamp(new Date().getTime()));
		diary.setUser(user);
		diary.setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
		
		boolean flag = diaryService.addDiary(diary);
		if(flag){
			request.setAttribute("message", "添加日记成功！！");
			return SUCCESS;
		}
		request.setAttribute("message", "添加日记失败！！");
		return "false";
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public DiaryService getDiaryService() {
		return diaryService;
	}


	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}
}
