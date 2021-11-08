package cn.gson.linyun.model.pojos.clockingin;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.system.SystemDepartment;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;

import java.sql.Timestamp;
import java.util.Collection;

public class ClockinginBusiness {
  private Integer businessId;
  private SystemDepartment departmentId;
  private ArchivesEmp empId;
  private WorkflowFlow flowId;
  private String businessPlace;
  private Timestamp businessStart;
  private Timestamp businessFinish;
  private String businessName;
  private String businessReason;

  private Collection<ClockinginReimburse> clockinginReimburses;

  public Collection<ClockinginReimburse> getClockinginReimburses() {
    return clockinginReimburses;
  }

  public void setClockinginReimburses(Collection<ClockinginReimburse> clockinginReimburses) {
    this.clockinginReimburses = clockinginReimburses;
  }

  @Override
  public String toString() {
    return "ClockinginBusiness{" +
            "businessId=" + businessId +
            ", businessPlace='" + businessPlace + '\'' +
            ", businessStart=" + businessStart +
            ", businessFinish=" + businessFinish +
            ", businessName='" + businessName + '\'' +
            ", businessReason='" + businessReason + '\'' +
            '}';
  }

  public Integer getBusinessId() {
    return businessId;
  }

  public void setBusinessId(Integer businessId) {
    this.businessId = businessId;
  }

  public SystemDepartment getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(SystemDepartment departmentId) {
    this.departmentId = departmentId;
  }

  public ArchivesEmp getEmpId() {
    return empId;
  }

  public void setEmpId(ArchivesEmp empId) {
    this.empId = empId;
  }

  public WorkflowFlow getFlowId() {
    return flowId;
  }

  public void setFlowId(WorkflowFlow flowId) {
    this.flowId = flowId;
  }

  public String getBusinessPlace() {
    return businessPlace;
  }

  public void setBusinessPlace(String businessPlace) {
    this.businessPlace = businessPlace;
  }

  public Timestamp getBusinessStart() {
    return businessStart;
  }

  public void setBusinessStart(Timestamp businessStart) {
    this.businessStart = businessStart;
  }

  public Timestamp getBusinessFinish() {
    return businessFinish;
  }

  public void setBusinessFinish(Timestamp businessFinish) {
    this.businessFinish = businessFinish;
  }

  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public String getBusinessReason() {
    return businessReason;
  }

  public void setBusinessReason(String businessReason) {
    this.businessReason = businessReason;
  }
}



