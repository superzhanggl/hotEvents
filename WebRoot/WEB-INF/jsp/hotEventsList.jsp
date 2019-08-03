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
    
    <title>My JSP 'hotEventsList.jsp' starting page</title>
    
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
  
 <!--  private int id;//热点事件id
	private String keyWord;//关键词
	private String hotContent;//热点事件内容
	private int searchSum ;//搜索指数
	private Date createDate; -->
    	 <table style="text-align:center;" width="60%" border="1px" cellpadding="0" cellspacing="0">
    	 		 <tr ><td colspan="3"><h1>热点事件</h1></td></tr>
    	 		 <tr ><td colspan="3">
    	 		 	<form action="${pageContext.request.contextPath }/hotEvents/list.html" method="get">
    	 		 		<input name="search" type="submit" value="搜索"/>
    	 		 		<input name="keyWord" type="text" value="${queryHotEvents.keyWord }">
    	 		 	</form>
    	 		 </td></tr>
                <tr >
                    <th width="10%">关键词</th>
                    <th width="5%">搜索指数</th>
                    <th width="10%">创建时间</th>
                </tr>
                   <c:forEach var="hotEvents" items="${hotEventsList }" varStatus="status">
					<tr>
						<td>
						<span><a href="${pageContext.request.contextPath }/hotEvents/detail/${hotEvents.id }">${hotEvents.keyWord }</a></span>
						</td>
						<td>
						<span>${hotEvents.searchSum }</span>
						</td>
						<td>
						<span>
							<fmt:formatDate value="${hotEvents.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
						</td>
					</tr>
				</c:forEach>
			</table>
  </body>
</html>
