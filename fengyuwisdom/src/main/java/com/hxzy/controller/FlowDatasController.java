package com.hxzy.controller;

import com.hxzy.entity.FlowDatas;
import com.hxzy.service.FirstPageDatasService;
import com.hxzy.service.FirstPageUtilService;
import com.hxzy.service.GetDatesService;
import com.hxzy.service.impl.FirstPageDatasServiceImpl;
import com.hxzy.util.RUtil;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/firstPage")
public class FlowDatasController {
    @Autowired
    FirstPageDatasService firstPageDatasService;
    @Autowired
    FirstPageUtilService firstPageUtil;
    @Autowired
    GetDatesService getDatesService;
    @RequestMapping("/flow")
    @ResponseBody
    public R getdatas(){

        //全部包装到实体类中
        FlowDatas flowDatas = new FlowDatas();
        flowDatas.setClicks(firstPageUtil.getTiles());
        flowDatas.setTimes(getDatesService.getDates());
        flowDatas.setMapData(firstPageDatasService.getAttributes());
        return RUtil.ok(flowDatas);
    }
}
