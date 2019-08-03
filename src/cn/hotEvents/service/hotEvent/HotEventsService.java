package cn.hotEvents.service.hotEvent;

import java.util.List;
import cn.hotEvents.pojo.HotEvents;
import cn.hotEvents.tools.QueryHotEvents;

public interface HotEventsService {
	//获取热点事件列表
	public List<HotEvents> getHotEventsList(QueryHotEvents queryHotEvents);
	
	//根据ID查询详情
	public HotEvents getHotEventsListById(Integer id);
	
	//点击查询时,将搜索指数增加
	public boolean updateSearchByid(Integer id);
}
