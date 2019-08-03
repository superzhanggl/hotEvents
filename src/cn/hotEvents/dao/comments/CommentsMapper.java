package cn.hotEvents.dao.comments;

import cn.hotEvents.pojo.Comments;

/**
 * 
 * @author 张国粮
 * 2019-7-16,上午10:09:07
 * sql映射器
 */
public interface CommentsMapper {
	
	//根据hotEventsId添加评论
	public int addCommentsByhotEventsId(Comments comments);
}
