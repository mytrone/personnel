package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 流程实例
 */
public class WorkflowApprove {
    private Integer approveId;//编号
    private Integer approveState;//状态
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp approveTime;//创建时间
    private WorkflowFlow approve_flow;//流程
    private WorkflowNode workflowNode;//节点
    private RecruitRecruitapply recruitapply;//申请编号
    private ArchivesEmp archivesEmpsq;//申请人
    private ArchivesEmp archivesEmpsp;//委托人
    private Integer approve_table;//申请表
    private String name;//申请名称
    private List<WorkflowFlowSp> spList;//审批节点




}
