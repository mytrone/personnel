package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.Vo.WorkflowFlowSpVo;
import cn.gson.linyun.model.service.recruit.ArchivesEmpService;
import cn.gson.linyun.model.service.workflow.WorkflowApproveService;
import cn.gson.linyun.model.service.workflow.WorkflowFlowSpService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("sp")
public class WorkflowFlowSpController {

    @Autowired
    WorkflowFlowSpService workflowFlowSpService;
    @Autowired
    ArchivesEmpService archivesEmpService;
    @Autowired
    WorkflowApproveService approveService;

    /**
     * 审批子节点
     *
     * @return
     */
    @PostMapping("update")
    public MyResult Update(@RequestParam("id") Integer id,
                           @RequestParam("state") Boolean state,
                           @RequestParam("row") String row,
                           @RequestParam("spr") Integer spr,
                           @RequestParam("appd") Integer appd
                           ) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        try {
            Integer i =  workflowFlowSpService.Update(id, state, row,timestamp);

            if(state==true){
                approveService.UpdateNode(appd,112);
                WorkflowFlowSpVo vo=new WorkflowFlowSpVo();
                vo.setWorkflowNode(112);
                vo.setArchivesEmpsp(spr);
                vo.setWorkflowApprove(appd);
                workflowFlowSpService.Insert(vo);//创建下一个节点
            }else{
                     approveService.Update(appd,-1);
            }



            if (i > 0) {
                return MyResult.SUCCESS;
            } else {
                return MyResult.FAILURE("审批失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.FAILURE("审批失败！");
        }
    }

    @PostMapping("grade")
    /**
     * 职位层级查询员工
     */
    public MyResult PostGrade(@RequestParam(value = "id") Integer id ){
        return MyResult.SUCCESS_DATA(archivesEmpService.SelectByPostGrade(id));
    }

}
