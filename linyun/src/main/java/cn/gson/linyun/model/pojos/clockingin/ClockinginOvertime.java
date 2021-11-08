package cn.gson.linyun.model.pojos.clockingin;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.pojos.system.SystemPost;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class ClockinginOvertime {/*加班申请表*/
    private Integer overtimeId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp overtimeStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp overtimeFinish;
    private BigDecimal overtimeDuration;
    private String overtimeReason;
    private ArchivesEmp archivesEmpByEmpId;
    private ArchivesEmp archivesEmpByArcEmpId;
    private Alinkey alinkeyByAlinkeyId;
    private WorkflowFlow workflowFlowByFlowId;
    private SystemPost systemPostBySystemPost;
    private SystemDepartment systemDepartmentByDepartmentId;
    private Integer overtimeState;

    public Integer getOvertimeState() {
        return overtimeState;
    }

    public void setOvertimeState(Integer overtimeState) {
        this.overtimeState = overtimeState;
    }

    public Integer getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(Integer overtimeId) {
        this.overtimeId = overtimeId;
    }

    public Timestamp getOvertimeStart() {
        return overtimeStart;
    }

    public void setOvertimeStart(Timestamp overtimeStart) {
        this.overtimeStart = overtimeStart;
    }

    public Timestamp getOvertimeFinish() {
        return overtimeFinish;
    }

    public void setOvertimeFinish(Timestamp overtimeFinish) {
        this.overtimeFinish = overtimeFinish;
    }

    public BigDecimal getOvertimeDuration() {
        return overtimeDuration;
    }

    public void setOvertimeDuration(BigDecimal overtimeDuration) {
        this.overtimeDuration = overtimeDuration;
    }

    public String getOvertimeReason() {
        return overtimeReason;
    }

    public void setOvertimeReason(String overtimeReason) {
        this.overtimeReason = overtimeReason;
    }

    public ArchivesEmp getArchivesEmpByEmpId() {
        return archivesEmpByEmpId;
    }

    public void setArchivesEmpByEmpId(ArchivesEmp archivesEmpByEmpId) {
        this.archivesEmpByEmpId = archivesEmpByEmpId;
    }

    public ArchivesEmp getArchivesEmpByArcEmpId() {
        return archivesEmpByArcEmpId;
    }

    public void setArchivesEmpByArcEmpId(ArchivesEmp archivesEmpByArcEmpId) {
        this.archivesEmpByArcEmpId = archivesEmpByArcEmpId;
    }

    public Alinkey getAlinkeyByAlinkeyId() {
        return alinkeyByAlinkeyId;
    }

    public void setAlinkeyByAlinkeyId(Alinkey alinkeyByAlinkeyId) {
        this.alinkeyByAlinkeyId = alinkeyByAlinkeyId;
    }

    @Override
    public String toString() {
        return "ClockinginOvertime{" +
                "overtimeId=" + overtimeId +
                ", overtimeStart=" + overtimeStart +
                ", overtimeFinish=" + overtimeFinish +
                ", overtimeDuration=" + overtimeDuration +
                ", overtimeReason='" + overtimeReason + '\'' +
                '}';
    }

    public WorkflowFlow getWorkflowFlowByFlowId() {
        return workflowFlowByFlowId;
    }

    public void setWorkflowFlowByFlowId(WorkflowFlow workflowFlowByFlowId) {
        this.workflowFlowByFlowId = workflowFlowByFlowId;
    }

    public SystemPost getSystemPostBySystemPost() {
        return systemPostBySystemPost;
    }

    public void setSystemPostBySystemPost(SystemPost systemPostBySystemPost) {
        this.systemPostBySystemPost = systemPostBySystemPost;
    }

    public SystemDepartment getSystemDepartmentByDepartmentId() {
        return systemDepartmentByDepartmentId;
    }

    public void setSystemDepartmentByDepartmentId(SystemDepartment systemDepartmentByDepartmentId) {
        this.systemDepartmentByDepartmentId = systemDepartmentByDepartmentId;
    }
}
