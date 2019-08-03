package cn.hotEvents.service.comments;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hotEvents.dao.comments.CommentsMapper;
import cn.hotEvents.pojo.Comments;
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
	@Resource(name="commentsMapper")
	private CommentsMapper commentsMapper;
	
	
	//根据hotEventsId添加评论
	public boolean addCommentsByhotEventsId(Comments comments){
		int addrows=commentsMapper.addCommentsByhotEventsId(comments);
		if(addrows>0){
			return true;
		}
		return false;
	}

}
