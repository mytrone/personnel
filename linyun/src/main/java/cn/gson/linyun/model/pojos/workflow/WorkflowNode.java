package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.system.SystemPost;
import cn.gson.linyun.model.pojos.system.SystemStaff;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 流程节点
 */
public class WorkflowNode {
    private int nodeId;//主键
    private Integer nodeLast;//是否最后
    private WorkflowFlow workflowFlow;//流程
    private Alinkey alinkey;//审批节点
    private SystemPost post;//职位层级
    private Collection<ClockinginOvertime> clockinginOvertimesByFlowId;/*加班申请*/
}
