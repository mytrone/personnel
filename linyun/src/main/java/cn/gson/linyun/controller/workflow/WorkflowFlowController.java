package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.Vo.PageName;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import cn.gson.linyun.model.service.workflow.AlinkeyService;
import cn.gson.linyun.model.service.workflow.WorkflowFlowService;
import cn.gson.linyun.model.service.workflow.WorkflowNodeService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("flow")
public class WorkflowFlowController {


    @Autowired
    WorkflowFlowService workflowFlowService;
    @Autowired
    WorkflowNodeService workflowNodeService;

    @PostMapping("all")
    /**
     * 查询所有流程
     * @param name 流程名
     * @return
     */
    public MyResult result(@RequestBody PageName page) {

        return MyResult.SUCCESS_Object(workflowFlowService.SelectAll(page.getNo(), page.getSize(), page.getName()));
    }


    /**
     * 修改流程
     *
     * @return
     */
    @PostMapping("update")
    public MyResult update(@RequestBody FlowVo flowVo) {
        System.out.println(flowVo.toString()+"333333333333");
        try {
            List<Integer> list=new ArrayList<>();
            for (Alinkey alinkey : flowVo.getJieduan()) {
                list.add(alinkey.getAlinkeyId());
            }
            Integer[] arr = list.toArray(new Integer[0]);
             workflowFlowService.UpdateFlow(flowVo);
             workflowNodeService.Delect(flowVo.getId());
              Integer i=workflowNodeService.Insert(flowVo,arr);
            if (i > 0) {
                return MyResult.SUCCESS;
            } else {
                return MyResult.FAILURE("修改流程失败!");
            }


        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.FAILURE("修改流程失败！");
        }

    }

    /**
     * 创建流程
     *
     * @return
     */
    @PostMapping("add")
    public MyResult Insert(@RequestBody FlowVo flowVo) {

        Timestamp timestamp = new Timestamp(new Date().getTime());
        flowVo.setTimestamp(timestamp);
        try {
            workflowFlowService.Insert(flowVo);
            List<Integer> list=new ArrayList<>();
            for (Alinkey alinkey : flowVo.getJieduan()) {
                list.add(alinkey.getAlinkeyId());
            }
            Integer[] arr = list.toArray(new Integer[0]);
            Integer i =  workflowNodeService.Insert(flowVo,arr);
            if (i > 0) {
                return MyResult.SUCCESS;
            } else {
                return MyResult.FAILURE("流程创建失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.FAILURE("流程创建失败！");
        }
    }


    /**
     * 删除流程
     *
     * @return
     */
    @PostMapping("delect")
    public MyResult Insert(@RequestParam(value = "id") Integer id) {

        try {
            workflowNodeService.Delect(id);
            Integer i = workflowFlowService.Delete(id);

            if (i > 0) {
                return MyResult.SUCCESS;
            } else {
                return MyResult.FAILURE("流程删除失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.FAILURE("流程删除失败！");
        }
    }


    /**
     * 修改流程状态
     *
     * @return
     */
    @PostMapping("updatezt")
    public MyResult updatezt(@RequestParam(value = "id") Integer id) {

        try {
            WorkflowFlow workflowFlow = workflowFlowService.SelectByid(id);
            Boolean bo = !workflowFlow.getFlowState();
            Integer i = workflowFlowService.Update(bo, workflowFlow.getFlowId());

            if (i > 0) {
                return MyResult.SUCCESS;
            } else {
                return MyResult.FAILURE("修改失败!");
            }


        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.FAILURE("修改失败！");
        }

    }




    @PostMapping("select")
    /**
     * 根据编号查询流程
     * @return
     */
    public MyResult select(@RequestParam("id")Integer id) {

        return MyResult.SUCCESS_Object(workflowFlowService.SelectByid(id));
    }



}
