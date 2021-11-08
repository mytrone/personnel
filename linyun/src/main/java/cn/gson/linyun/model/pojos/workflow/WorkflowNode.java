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

    @Override
    public String toString() {
        return "WorkflowNode{" +
                "nodeId=" + nodeId +
                ", nodeLast=" + nodeLast +
                '}';
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeLast() {
        return nodeLast;
    }

    public void setNodeLast(Integer nodeLast) {
        this.nodeLast = nodeLast;
    }

    public WorkflowFlow getWorkflowFlow() {
        return workflowFlow;
    }

    public void setWorkflowFlow(WorkflowFlow workflowFlow) {
        this.workflowFlow = workflowFlow;
    }

    public Alinkey getAlinkey() {
        return alinkey;
    }

    public void setAlinkey(Alinkey alinkey) {
        this.alinkey = alinkey;
    }

    public SystemPost getPost() {
        return post;
    }

    public void setPost(SystemPost post) {
        this.post = post;
    }

    public Collection<ClockinginOvertime> getClockinginOvertimesByFlowId() {
        return clockinginOvertimesByFlowId;
    }

    public void setClockinginOvertimesByFlowId(Collection<ClockinginOvertime> clockinginOvertimesByFlowId) {
        this.clockinginOvertimesByFlowId = clockinginOvertimesByFlowId;
    }
}
