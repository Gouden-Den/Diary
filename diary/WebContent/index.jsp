<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>index</title>
	</head>
	
	<body>
		<s:if test="#session.user==null">
			<s:a href="register.jsp">注册</s:a>
			<s:a href="login.jsp">登陆</s:a>
		</s:if>
		<s:else>
			欢迎你：${session.user.username }
			<s:a href="writeDiary.jsp">写日记</s:a><br/>
			<s:a href="getAllDiary">得到所有日记</s:a><br/>
			<s:a href="getDiaryByMonth.action">按月份得到日记</s:a><br/>
		</s:else>
	</body>
</html>