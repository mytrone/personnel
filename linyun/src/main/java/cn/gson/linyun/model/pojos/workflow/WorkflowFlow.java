package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 流程
 */
public class WorkflowFlow {
    private int flowId;
    private String flowName;
    private Boolean flowState;
    private String flowUrl;
    private Alinkey alinkey;//流程类型
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp flowTime;
    private Integer flowPosition;

    private Collection<ClockinginLeave> clockinginLeavesByFlow;

    public int getFlowId() {
        return flowId;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public Boolean getFlowState() {
        return flowState;
    }

    public void setFlowState(Boolean flowState) {
        this.flowState = flowState;
    }

    public String getFlowUrl() {
        return flowUrl;
    }

    public void setFlowUrl(String flowUrl) {
        this.flowUrl = flowUrl;
    }

    public Alinkey getAlinkey() {
        return alinkey;
    }

    public void setAlinkey(Alinkey alinkey) {
        this.alinkey = alinkey;
    }

    public Timestamp getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(Timestamp flowTime) {
        this.flowTime = flowTime;
    }

    public Integer getFlowPosition() {
        return flowPosition;
    }

    public void setFlowPosition(Integer flowPosition) {
        this.flowPosition = flowPosition;
    }

    public Collection<ClockinginLeave> getClockinginLeavesByFlow() {
        return clockinginLeavesByFlow;
    }

    public void setClockinginLeavesByFlow(Collection<ClockinginLeave> clockinginLeavesByFlow) {
        this.clockinginLeavesByFlow = clockinginLeavesByFlow;
    }
}
