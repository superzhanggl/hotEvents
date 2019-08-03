package cn.hotEvents.tools;
/**
 * 
 * @author 张国粮
 * 2019-7-16,上午10:57:06
 * 查询热点事件类
 */
public class QueryHotEvents {
	private String keyWord;//关键词
	private String search;
	

	/**
	 * @param keyWord
	 * @param search
	 */
	public QueryHotEvents(String keyWord, String search) {
		super();
		this.keyWord = keyWord;
		this.search = search;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * @param keyWord
	 */
	public QueryHotEvents(String keyWord) {
		super();
		this.keyWord = keyWord;
	}
	
	public QueryHotEvents(){}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
