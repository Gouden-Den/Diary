<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>getAllDiary</title>
	</head>
	
	<body>
		<s:iterator value="diaries" id="id">
			<a href="getDetail.action?diaryid=<s:property value="diaryid"/>"><s:property value="createTime"/>时的日记</a>
			<a href="deleteDiary?diaryid=<s:property value="diaryid"/>"><button  onclick="if(confirm( '确定删除吗？ ')==false)  return false; ">删除日记</button></a>
			<br>
		</s:iterator>
	</body>
</html>