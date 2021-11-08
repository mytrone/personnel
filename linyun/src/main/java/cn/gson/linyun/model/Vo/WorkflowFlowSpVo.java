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

    public Integer getFlowSpId() {
        return flowSpId;
    }

    public void setFlowSpId(Integer flowSpId) {
        this.flowSpId = flowSpId;
    }

    public Timestamp getFlowSpTime() {
        return flowSpTime;
    }

    public void setFlowSpTime(Timestamp flowSpTime) {
        this.flowSpTime = flowSpTime;
    }

    public String getFlowSpRemarks() {
        return flowSpRemarks;
    }

    public void setFlowSpRemarks(String flowSpRemarks) {
        this.flowSpRemarks = flowSpRemarks;
    }

    public Integer getFlowSpState() {
        return flowSpState;
    }

    public void setFlowSpState(Integer flowSpState) {
        this.flowSpState = flowSpState;
    }

    public Integer getArchivesEmpsp() {
        return archivesEmpsp;
    }

    public void setArchivesEmpsp(Integer archivesEmpsp) {
        this.archivesEmpsp = archivesEmpsp;
    }

    public Integer getWorkflowApprove() {
        return workflowApprove;
    }

    public void setWorkflowApprove(Integer workflowApprove) {
        this.workflowApprove = workflowApprove;
    }

    public Integer getWorkflowNode() {
        return workflowNode;
    }

    public void setWorkflowNode(Integer workflowNode) {
        this.workflowNode = workflowNode;
    }
}
