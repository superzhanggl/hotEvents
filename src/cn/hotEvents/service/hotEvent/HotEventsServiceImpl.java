package cn.hotEvents.service.hotEvent;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hotEvents.dao.hotEvent.HotEventsMapper;
import cn.hotEvents.pojo.HotEvents;
import cn.hotEvents.tools.QueryHotEvents;
@Service("hotEventsService")
public class HotEventsServiceImpl implements HotEventsService {
	@Resource(name="hotEventsMapper")
	private HotEventsMapper hotEventsMapper;
	
	
	//获取热点事件列表
	public List<HotEvents> getHotEventsList(QueryHotEvents queryHotEvents){
		return hotEventsMapper.getHotEventsList(queryHotEvents);
		
	}

	//根据ID查询详情
	public HotEvents getHotEventsListById(Integer id){
		return hotEventsMapper.getHotEventsListById(id);
	}
	
	//点击查询时,将搜索指数增加
	public boolean updateSearchByid(Integer id){
		int updateSearchRows=hotEventsMapper.updateSearchByid(id);
		if(updateSearchRows>0){
			return true;
		}
		return false;
	}

}
