package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.Vo.PageName;
import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.service.workflow.WorkflowApproveService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("approve")
/**
 * 流程实例Controller
 */
public class WorkflowApproveController {

    @Autowired
    WorkflowApproveService workflowApproveService;

    /**
     * 创建流程
     *
     * @return
     */
    @PostMapping("add")
    public MyResult Insert(@RequestBody WorkflowApproveVo flowVo) {

        Timestamp timestamp = new Timestamp(new Date().getTime());
        flowVo.setApproveTime(timestamp);
        try {
            Integer i =  workflowApproveService.Insert(flowVo);
            if (i > 0) {
                return MyResult.SUCCESS;
            } else {
                return MyResult.FAILURE("创建失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.FAILURE("流程创建失败！");
        }
    }

    @PostMapping("all")
    /**
     * 查询所有申请流程
     * @param name 流程名
     * @return
     */
    public MyResult result(@RequestBody PageName page) {

        return MyResult.SUCCESS_Object(workflowApproveService.SelectAll(page.getNo(),
                page.getSize(),
                page.getName()));
    }

    @PostMapping("byid")
    /**
     * 查询emp id申请流程
     * @param name 流程名
     * @return
     */
    public MyResult SelectByEmp(@RequestBody PageName page) {

        return MyResult.SUCCESS_Object(workflowApproveService.SelectByEmp(page.getNo(),
                page.getSize(),
                page.getEmp(), page.getName()));
    }


    @PostMapping("byidsp")
    /**
     * 查询emp id申请流程  需要我办理的
     * @param name 流程名
     * @return
     */
    public MyResult SelectByEmpSp(@RequestBody PageName page) {

        return MyResult.SUCCESS_Object(workflowApproveService.
                SelectByEmpSp(page.getNo(),
                page.getSize(),
                page.getEmp(), page.getName()));
    }


    @PostMapping("selectid")
    /**
     * 查询历史审批记录 根据流程实例编号
     * @param id
     * @return
     */
    public MyResult select(@RequestParam(value = "id") Integer id) {
        return MyResult.SUCCESS_Object(workflowApproveService.SelectHistory(id));
    }

    @PostMapping("selectidappd")
    /**
     * 根据流程实例编号
     * @param id
     * @return
     */
    public MyResult SelectByApprove(@RequestParam(value = "id") Integer id) {
        return MyResult.SUCCESS_Object(workflowApproveService.SelectByApprove(id));
    }



}
