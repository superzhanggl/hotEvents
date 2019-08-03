package cn.hotEvents.dao.hotEvent;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.hotEvents.pojo.HotEvents;
import cn.hotEvents.tools.QueryHotEvents;

/**
 * 
 * @author 张国粮
 * 2019-7-16,上午10:09:07
 * sql映射器
 */
public interface HotEventsMapper {
	//获取热点事件列表
	public List<HotEvents> getHotEventsList(QueryHotEvents queryHotEvents);
	//根据ID查询详情
	public HotEvents getHotEventsListById(@Param("id")Integer id);
	//点击查询时,将搜索指数增加
	public int updateSearchByid(@Param("id")Integer id);
}
