package action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class RegisterAction extends ActionSupport {
	private String username;
	private String password;
	private String repassword;
	private String name;
	private String phone;
	private String email;
	private String address;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		if(address != null){
			user.setAddress(address);
		}
		
		userService.register(user);
		session.setAttribute("user", user);
		return "success";
	}
	@Override
	public void validate() {
		
		if(!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{1,15}", username)){
			addFieldError("username", "�û�����ʹ��6-16λӢ�Ļ������֣�������ĸ��ͷ����");
		}
		if(!Pattern.matches("[a-zA-Z0-9]{6,16}", password)){
			addFieldError("password", "������ʹ��6-16λ���ֻ���ĸ����");
		}
		if(!repassword.equals(password)){
			addFieldError("repassword", "�������벻һ������");
		}
		if("".equals(name.trim())){
			addFieldError("name", "��ʵ��������Ϊ�գ���");
		}
		if("".equals(phone.trim())){
			addFieldError("name", "�ֻ����벻��Ϊ�գ���");
		}
		if("".equals(email.trim())){
			addFieldError("name", "���䲻��Ϊ�գ���");
		}
		boolean flag = false;
		flag = userService.ifUsernameExist(username);
		if(flag){
			addFieldError("username", "�û����Ѵ��ڣ���");
		}
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
