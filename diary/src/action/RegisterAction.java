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
			addFieldError("username", "用户名请使用6-16位英文或者数字，且以字母开头！！");
		}
		if(!Pattern.matches("[a-zA-Z0-9]{6,16}", password)){
			addFieldError("password", "密码请使用6-16位数字或字母！！");
		}
		if(!repassword.equals(password)){
			addFieldError("repassword", "两次密码不一样！！");
		}
		if("".equals(name.trim())){
			addFieldError("name", "真实姓名不能为空！！");
		}
		if("".equals(phone.trim())){
			addFieldError("name", "手机号码不能为空！！");
		}
		if("".equals(email.trim())){
			addFieldError("name", "邮箱不能为空！！");
		}
		boolean flag = false;
		flag = userService.ifUsernameExist(username);
		if(flag){
			addFieldError("username", "用户名已存在！！");
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
