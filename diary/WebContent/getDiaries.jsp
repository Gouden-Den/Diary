<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>getDiaries</title>
		<script type="text/javascript">
			function con(){
				var message = confirm("确认删除吗？");
				if(message){
					return true;
				}else{
					return false;
				}
			}
		</script>
	</head>
	
	<body>
		<s:iterator value="diaries">
			<a href="getDetail.action?diaryid=<s:property value="diaryid"/>"><s:property value="createTime"/>时的日记</a>
			<a href="deleteDiary?diaryid=<s:property value="diaryid"/>"><button onclick="return con()">删除日记</button></a>
			<br><br>
		</s:iterator>
	</body>
</html>