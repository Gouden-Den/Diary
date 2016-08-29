<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>register</title>
	</head>
	
	<body>
		<s:form action="register.action" method="post"> 
			<s:textfield label="用户名" name="username"/>
			<s:password label="密码" name="password"/>
			<s:password label="确认密码" name="repassword"/>
			<s:textfield label="真实姓名" name="name"/>
			<s:textfield label="手机号" name="phone"/>
			<s:textfield label="邮箱" name="email"/>
			<s:textarea label="家庭住址" name="address"/>
			<s:submit  type="submit" value="注册"/>
		</s:form>
	</body>
</html>