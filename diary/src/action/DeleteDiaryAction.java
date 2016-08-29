package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.DiaryService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteDiaryAction extends ActionSupport {
	private DiaryService diaryService;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String diaryid = request.getParameter("diaryid");
		diaryService.deleteDiary(Integer.parseInt(diaryid));
		request.setAttribute("message", "É¾³ý³É¹¦ÁË£¡£¡");
		return "success";
	}

	public DiaryService getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}
}
