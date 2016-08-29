<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>message</title>
	</head>
	
	<body>
		${session.user.name },${message }<br>
		<a href="index.jsp"><button>回到首页</button></a>
	</body>
</html>