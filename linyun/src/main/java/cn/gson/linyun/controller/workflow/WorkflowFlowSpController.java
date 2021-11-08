package cn.gson.linyun.controller.workflow;

import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.Vo.WorkflowFlowSpVo;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import cn.gson.linyun.model.service.recruit.ArchivesEmpService;
import cn.gson.linyun.model.service.workflow.WorkflowApproveService;
import cn.gson.linyun.model.service.workflow.WorkflowFlowSpService;
import cn.gson.linyun.model.service.workflow.WorkflowNodeService;
import cn.gson.linyun.model.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sp")
public class WorkflowFlowSpController {

    @Autowired
    WorkflowFlowSpService workflowFlowSpService;
    @Autowired
    ArchivesEmpService archivesEmpService;
    @Autowired
    WorkflowApproveService approveService;
    @Autowired
    WorkflowNodeService nodeService;


    @PostMapping("updateemp")
    /**
     * 修改审批人
     */
    public MyResult UpdateEmp(@RequestParam("id") Integer id,
                              @RequestParam("emp") Integer emp){
        System.out.println(id);
        System.out.println(emp);
        Integer i= workflowFlowSpService.UpdateEmp(id, emp);
        if (i > 0) {
            return MyResult.SUCCESS;
        } else {
            return MyResult.FAILURE("修改失败！");
        }
    }

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
                           @RequestParam("appd") Integer appd,
                           @RequestParam("flowSpId") Integer flowSpId,
                           @RequestParam("flow") Integer flow,
                           @RequestParam("node") Integer node
                           ) {

        Timestamp timestamp = new Timestamp(new Date().getTime());
        try {
            Integer i =  workflowFlowSpService.Update(id, state, row,timestamp);

            //判断是否同意
            if(state==true){
               List<WorkflowNode> list=nodeService.SelectByFlow(flow);//查询该流程下节点
                for (WorkflowNode workflowNode : list) {
                    if(workflowNode.getNodeId()!=node && workflowNode.getNodeId()>node  ){
                        approveService.UpdateNode(appd,workflowNode.getNodeId() );//修改当前流程状态
                        WorkflowFlowSpVo vo=new WorkflowFlowSpVo();
                        vo.setWorkflowNode(workflowNode.getNodeId());
                        vo.setArchivesEmpsp(spr);
                        vo.setWorkflowApprove(appd);
                        workflowFlowSpService.Insert(vo);//创建下一个节点
                        break;
                    }
                }

                if(node==list.get(list.size()-1).getNodeId()){
                    //完结
                    approveService.Update(appd,1);
                }

            }else{
                    //被拒
                System.out.println("我拒绝了"+state);
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
