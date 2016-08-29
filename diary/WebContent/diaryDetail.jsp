<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>diaryDetail</title>
	</head>
	
	<body>
		<div style="margin-left:30%; margin-top:5%; font-size:16px">
			您好：${session.user.username }
			<a href="index.jsp"><button style="margin-left:48.5%" onclick="return confirm('确认返回首页？')">回到首页</button></a>
			<s:form action="updateDiary.action" method="post">
				<textarea style="font-size:16px" name="content" cols="100" rows="20"><s:property value="diary.content"/></textarea>
				<s:submit type="submit" value="确认修改"/>
				<br>
			</s:form>
		</div>
	</body>
</html>