package cn.hotEvents.service.comments;

import cn.hotEvents.pojo.Comments;

public interface CommentsService {
	//根据hotEventsId添加评论
	public boolean addCommentsByhotEventsId(Comments comments);
}
