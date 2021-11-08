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
    private Integer approveflow;//流程
    private Integer workflowNode;//节点
    private Integer approvetable;//申请编号
    private Integer archivesEmpsq;//申请人
    private Integer archivesEmpsp;//委托人
    private Integer spPeople;//审批人

}
