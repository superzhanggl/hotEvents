 $(document).ready(function(){
	
	
	$("input[name='search']").click(function(){
		var comments=$("textarea[name='comments']").val();
		var hotEventsId=$("input[name='hotEventsId']").val();
		var $commentsList=$("div[name='commentsList']");
		
		$.ajax({
			"url":"${pageContext.request.contextPath}/hotEvents/addComments",
			"type":"GET",
			"data":"hotEventsId="+hotEventsId,
			"dataType":"JSON",
			"success":ifSuccess
		})
		function ifSuccess(data){
			$("div[name='commentsList']").prepend("<div >评论时间:<fmt:formatDate value='${data.commentDate}' pattern='yyyy-MM-dd HH:mm:ss'/></div><div>${data.content}</div><br/>")
		}
		
	})
	

	
})