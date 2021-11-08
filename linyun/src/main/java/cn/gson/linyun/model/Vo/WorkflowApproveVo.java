package cn.gson.linyun.model.Vo;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
/**
 * 申请实例vo
 */
@Data
public class WorkflowApproveVo {

    private Integer approveId;//编号
    private Integer approveState;//状态
    private Timestamp approveTime;//创建时间
    private Integer approve_flow;//流程
    private Integer workflowNode;//节点
    private Integer approve_table;//申请编号
    private Integer archivesEmpsq;//申请人
    private Integer archivesEmpsp;//委托人
    private Integer spPeople;//审批人

    public Integer getApproveId() {
        return approveId;
    }

    public void setApproveId(Integer approveId) {
        this.approveId = approveId;
    }

    public Integer getApproveState() {
        return approveState;
    }

    public void setApproveState(Integer approveState) {
        this.approveState = approveState;
    }

    public Timestamp getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Timestamp approveTime) {
        this.approveTime = approveTime;
    }

    public Integer getApprove_flow() {
        return approve_flow;
    }

    public void setApprove_flow(Integer approve_flow) {
        this.approve_flow = approve_flow;
    }

    public Integer getWorkflowNode() {
        return workflowNode;
    }

    public void setWorkflowNode(Integer workflowNode) {
        this.workflowNode = workflowNode;
    }

    public Integer getApprove_table() {
        return approve_table;
    }

    public void setApprove_table(Integer approve_table) {
        this.approve_table = approve_table;
    }

    public Integer getArchivesEmpsq() {
        return archivesEmpsq;
    }

    public void setArchivesEmpsq(Integer archivesEmpsq) {
        this.archivesEmpsq = archivesEmpsq;
    }

    public Integer getArchivesEmpsp() {
        return archivesEmpsp;
    }

    public void setArchivesEmpsp(Integer archivesEmpsp) {
        this.archivesEmpsp = archivesEmpsp;
    }

    public Integer getSpPeople() {
        return spPeople;
    }

    public void setSpPeople(Integer spPeople) {
        this.spPeople = spPeople;
    }
}
