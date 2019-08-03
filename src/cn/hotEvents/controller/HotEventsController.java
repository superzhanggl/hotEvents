package cn.hotEvents.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hotEvents.pojo.HotEvents;
import cn.hotEvents.service.hotEvent.HotEventsService;
import cn.hotEvents.tools.QueryHotEvents;

/**
 * 
 * @author 张国粮
 * 2019-7-16,上午10:13:37
 *	hotEvents控制层
 */
@Controller
@RequestMapping("/hotEvents")
public class HotEventsController {
	@Resource(name="hotEventsService")
	private HotEventsService hotEventsService;
	private Logger logger=Logger.getLogger(HotEventsController.class);
	
	/**
	 * 查询列表，同时修改数据库的搜素指数基数，基数累加1
	 * @param model
	 * @param queryHotEvents
	 * @return
	 */
	
	@RequestMapping("/list.html")
	public String getHotEventList(Model model,QueryHotEvents queryHotEvents){
		logger.info("welcome into hotEventList.html ");
		List<HotEvents> hotEventsList=hotEventsService.getHotEventsList(queryHotEvents);
		
		//根据搜索情况,对响应的数据的搜索指数增加1,根据Id对应每一条数据进行累加
		for(HotEvents hotEvents:hotEventsList){
			Integer searchSumId=hotEvents.getId();
			//调用service的方法进行累加
			hotEventsService.updateSearchByid(searchSumId);
		}
		
		model.addAttribute("hotEventsList", hotEventsList);
		model.addAttribute("queryHotEvents", queryHotEvents);
		return "hotEventsList";
	}
	/**
	 * 根据id查询详情，同时修改数据库的搜素指数基数，基数累加1
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String getDetailById(Model model,@PathVariable Integer id){
		logger.info("welcome into detail id is ===>>"+id);
		//查询详情
		HotEvents hotEvents=hotEventsService.getHotEventsListById(id);
		//将搜索指数加一
		boolean updateSearchRowsFlag=hotEventsService.updateSearchByid(id);
		if(updateSearchRowsFlag){
			//搜索指数修改成功后，可以实现页面跳转
			model.addAttribute("hotEvents", hotEvents);
			return "detail";
		}else {
			//修改搜索指数失败,重定向请求，展示页面
			return "redirect:/hotEvents/list.html";
		}
		
	}
	
	
	
}
