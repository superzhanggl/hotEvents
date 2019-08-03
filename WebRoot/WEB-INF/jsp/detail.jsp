<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
    	<h1>${hotEvents.keyWord}</h1>
    	<div>
    		创建于：<fmt:formatDate value="${hotEvents.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>			
    	</div>
    	<div>
    		${hotEvents.hotContent}
    		<input name="hotEventsId" value="${hotEvents.id}" type="hidden"/>
    	</div>
    	
	    	评论：
	    	<div name="commentsList">
	    	 <c:forEach var="commentsList" items="${hotEvents.commentsList }" varStatus="status">
	    	 	<c:if test="${commentsList.content != null}">
	    	 		<div>
							评论时间:<fmt:formatDate value="${commentsList.commentDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</div>
					<div>
							${commentsList.content}
					</div>
	    	 	</c:if>
				<c:if test="${commentsList.content == null}">
					暂时无人评论
				</c:if>	
						<br/>
			</c:forEach>
			</div>
		
		<div>
					<span>评论:</span><br/>
					<textarea name="comments" value="" cols="30" rows="5" placeholder="输入题干信息"></textarea>
					<br/><input name="search" type="submit" value="提交"/> <a href="${pageContext.request.contextPath }/hotEvents/list.html">返回首页</a>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>
		<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/detail.js"></script> --%>
  	 <script>
  	 $(document).ready(function(){
		$("input[name='search']").click(function(){
				var content=$("textarea[name='comments']").val();
				
				var hotEventsId=$("input[name='hotEventsId']").val();
				var $commentsList=$("div[name='commentsList']");
				
				//获取当前时间
				var myDate = new Date();
				//获取当前年
				var year=myDate.getFullYear();
				//获取当前月
				var month=myDate.getMonth()+1;
				//获取当前日
				var date=myDate.getDate(); 
				var h=myDate.getHours();       //获取当前小时数(0-23)
				var m=myDate.getMinutes();     //获取当前分钟数(0-59)
				var s=myDate.getSeconds();  
				
				var now=year+"-"+month+"-"+date+" "+h+":"+m+":"+s;
				
				$.ajax({
					"url":"${pageContext.request.contextPath}/comments/addComments",
					"type":"GET",
					"data":{"content":content,"hotEventsId":hotEventsId},
					"dataType":"text",
					"success":ifSuccess
				})
				function ifSuccess(data){
					if(data=="success"){
						var $children=$("<div >评论时间:"+now+"</div><div>"+content+"</div><br/>")
						$("div[name='commentsList']").prepend($children),
						//将评论区清空
						$("textarea[name='comments']").val("")
					}else if(data=="failed"){
						alert("评论失败")
					}
					
				}
				
			})
			

	
})
  </script>
  </body>
</html>
