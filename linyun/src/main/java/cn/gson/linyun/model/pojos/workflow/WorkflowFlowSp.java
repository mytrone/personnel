package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 流程实例审批
 */
public class WorkflowFlowSp {
    private int flowSpId;//编号
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp flowSpTime;//审批时间
    private String flowSpRemarks;//意见
    private Integer flowSpState;//状态
    private ArchivesEmp archivesEmpsp;//审批人
    private WorkflowApprove workflowApprove;//流程实例
    private WorkflowNode workflowNode;//节点

}
