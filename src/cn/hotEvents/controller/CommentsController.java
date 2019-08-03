package cn.hotEvents.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hotEvents.pojo.Comments;
import cn.hotEvents.service.comments.CommentsService;

/**
 * 
 * @author 张国粮
 * 2019-7-16,下午9:29:38
 *	评论类控制器
 */
@Controller
@RequestMapping("/comments")
public class CommentsController {
	
	@Resource(name="commentsService")
	private CommentsService commentsService;
	
	private Logger logger=Logger.getLogger(HotEventsController.class);
	/**
	 * 使用ajax技术,评论区内容提交后,操作数据comments表的对应字段列
	 * @param model
	 * @param hotEventsId
	 * @param content
	 * @return
	 */
	@RequestMapping("/addComments")
	@ResponseBody
	public String addComments(Model model,@RequestParam Integer hotEventsId,
			@RequestParam String content){
		//日志输出
		logger.info("welcome into comments addComments");
		logger.info("hotEventsId is==>>"+hotEventsId);
		logger.info("content is==>>"+content);
		//数据封装
		Comments comments=new Comments();
		comments.setContent(content);
		comments.setHotEventsId(hotEventsId);
		//调用service层方法
		boolean isAdd=commentsService.addCommentsByhotEventsId(comments);
		if(isAdd){
			return "success";
		}
		
		return "failed";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
