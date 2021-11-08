package cn.gson.linyun.model.pojos.clockingin;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.pojos.system.SystemPost;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class ClockinginLeave {
  private Integer leaveId;
  private Alinkey alinkeyId;
  private ArchivesEmp empId;
  private ArchivesEmp arcEmpId;
  private SystemPost postId;
  private WorkflowFlow flowId;
  private SystemDepartment departmentId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Timestamp leaveName;/*申请时间*/
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Timestamp leaveStart;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Timestamp leaveFinish;
  private String leaveReason;
  private Integer leaveDays;

  @Override
  public String toString() {
    return "ClockinginLeave{" +
            "leaveId=" + leaveId +
            ", leaveName=" + leaveName +
            ", leaveStart=" + leaveStart +
            ", leaveFinish=" + leaveFinish +
            ", leaveReason='" + leaveReason + '\'' +
            ", leaveDays=" + leaveDays +
            '}';
  }

  public Integer getLeaveDays() {
    return leaveDays;
  }

  public void setLeaveDays(Integer leaveDays) {
    this.leaveDays = leaveDays;
  }

  public Integer getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(Integer leaveId) {
    this.leaveId = leaveId;
  }

  public Alinkey getAlinkeyId() {
    return alinkeyId;
  }

  public void setAlinkeyId(Alinkey alinkeyId) {
    this.alinkeyId = alinkeyId;
  }

  public ArchivesEmp getEmpId() {
    return empId;
  }

  public void setEmpId(ArchivesEmp empId) {
    this.empId = empId;
  }

  public ArchivesEmp getArcEmpId() {
    return arcEmpId;
  }

  public void setArcEmpId(ArchivesEmp arcEmpId) {
    this.arcEmpId = arcEmpId;
  }

  public SystemPost getPostId() {
    return postId;
  }

  public void setPostId(SystemPost postId) {
    this.postId = postId;
  }

  public WorkflowFlow getFlowId() {
    return flowId;
  }

  public void setFlowId(WorkflowFlow flowId) {
    this.flowId = flowId;
  }

  public SystemDepartment getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(SystemDepartment departmentId) {
    this.departmentId = departmentId;
  }

  public Timestamp getLeaveName() {
    return leaveName;
  }

  public void setLeaveName(Timestamp leaveName) {
    this.leaveName = leaveName;
  }

  public Timestamp getLeaveStart() {
    return leaveStart;
  }

  public void setLeaveStart(Timestamp leaveStart) {
    this.leaveStart = leaveStart;
  }

  public Timestamp getLeaveFinish() {
    return leaveFinish;
  }

  public void setLeaveFinish(Timestamp leaveFinish) {
    this.leaveFinish = leaveFinish;
  }

  public String getLeaveReason() {
    return leaveReason;
  }

  public void setLeaveReason(String leaveReason) {
    this.leaveReason = leaveReason;
  }
}
