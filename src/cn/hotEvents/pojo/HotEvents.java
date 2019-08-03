package cn.hotEvents.pojo;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author 张国粮
 * 2019-7-16,上午9:28:03
 * 热点事件基本类
 */
public class HotEvents {
	
	private int id;//热点事件id
	private String keyWord;//关键词
	private String hotContent;//热点事件内容
	private int searchSum ;//搜索指数
	private Date createDate;
	
	private List<Comments> commentsList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getHotContent() {
		return hotContent;
	}
	public void setHotContent(String hotContent) {
		this.hotContent = hotContent;
	}
	public int getSearchSum() {
		return searchSum;
	}
	public void setSearchSum(int searchSum) {
		this.searchSum = searchSum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @param id
	 * @param keyWord
	 * @param hotContent
	 * @param searchSum
	 * @param createDate
	 */
	public HotEvents(int id, String keyWord, String hotContent, int searchSum,
			Date createDate) {
		super();
		this.id = id;
		this.keyWord = keyWord;
		this.hotContent = hotContent;
		this.searchSum = searchSum;
		this.createDate = createDate;
	}
	public HotEvents(){}
	public List<Comments> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}
	
	
	
}
