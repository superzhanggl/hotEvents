package cn.hotEvents.pojo;

import java.util.Date;
/**
 * 
 * @author 张国粮
 * 2019-7-16,上午9:23:51
 *	热点事件评论基本类
 */
public class Comments {
	private int id;//热点评论id
	private int hotEventsId;//热点事件编号
	private Date commentDate;//创建时间
	private String content;//评论内容
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHotEventsId() {
		return hotEventsId;
	}
	public void setHotEventsId(int hotEventsId) {
		this.hotEventsId = hotEventsId;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @param id
	 * @param hotEventsId
	 * @param commentDatedate
	 * @param content
	 */
	public Comments(int id, int hotEventsId, Date commentDate,
			String content) {
		super();
		this.id = id;
		this.hotEventsId = hotEventsId;
		this.commentDate = commentDate;
		this.content = content;
	}
	
	public Comments(){}
	
	
}
