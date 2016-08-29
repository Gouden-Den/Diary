<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>login</title>
	</head>
	
	<body>
		<s:form action="login.action">
			<s:textfield label="账号" name="username"/>
			<s:password label="密码" name="password"/>
			<s:submit type="submit" value="登录"/>
		</s:form>
	</body>
</html>