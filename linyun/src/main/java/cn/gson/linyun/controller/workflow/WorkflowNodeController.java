package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import cn.gson.linyun.model.service.workflow.WorkflowNodeService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("node")
public class WorkflowNodeController {

    @Autowired
    WorkflowNodeService workflowNodeService;

    /**
     * 查询流程节点
     * @param id
     * @return
     */
    @PostMapping("selectid")
    public MyResult selectID(@RequestParam("id")Integer id){
        return MyResult.SUCCESS_DATA(workflowNodeService.SelectByFlow(id));
    }

    /**
     * 根据职位层级查询已经设计好的流程节点
     * @param id
     * @return
     */
    @PostMapping("selectpo")
    public MyResult SelectByPosition(@RequestParam("id")Integer id){
        return MyResult.SUCCESS_DATA(workflowNodeService.SelectByPosition(id));
    }




}
