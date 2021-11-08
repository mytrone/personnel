package cn.gson.linyun.model.Vo;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.workflow.WorkflowApprove;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 流程审批vo
 */
public class WorkflowFlowSpVo {


    private Integer  flowSpId;//编号
    private Timestamp flowSpTime;//审批时间
    private String flowSpRemarks;//意见
    private Integer flowSpState;//状态
    private Integer archivesEmpsp;//审批人
    private Integer workflowApprove;//流程实例
    private Integer workflowNode;//节点

}
