<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>writeDiary</title>
	</head>
	
	<body>
		<div style="margin-left:30%; margin-top:5%; font-size:16px">
		您好：${session.user.username }
			<s:form action="writeDiary" method="post">
				<s:textarea style="font-size:16px" name="content" cols="100" rows="20" font-size="51px"/>
				<s:submit onclick="return confirm('确认提交吗?')" type="submit" value="提交"/>
			</s:form>
		</div>
	</body>
</html>