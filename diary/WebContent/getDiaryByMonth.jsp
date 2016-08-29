<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>getDiaryByMonth</title>
	</head>
	
	<body>
		下面是月份：<br/>
		<s:iterator value="months" var="month"> 
			<a href="getDiaries.action?month=<s:property value="month"/>"><s:property value="month"/>月份的日记</a><br/>
		</s:iterator>
	</body>
</html>