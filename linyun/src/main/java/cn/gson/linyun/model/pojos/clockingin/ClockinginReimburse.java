package cn.gson.linyun.model.pojos.clockingin;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

public class ClockinginReimburse {/*报销申请*/

  private Integer reimburseId;
  private Alinkey alinkeyId;
  private ArchivesEmp empId;
  private WorkflowFlow flowId;
  private Timestamp reimburseData;
  private ClockinginBusiness clockinginBusiness;
  private BigDecimal reimburseMoney;
  private Integer reimburseState;

private String reimburseTitle;

  @Override
  public String toString() {
    return "ClockinginReimburse{" +
            "reimburseId=" + reimburseId +
            ", reimburseData=" + reimburseData +
            ", reimburseMoney=" + reimburseMoney +
            ", reimburseState=" + reimburseState +
            ", reimburseTitle='" + reimburseTitle + '\'' +
            '}';
  }

  private Collection<ClockinginDetails> clockinginDetails;//报销详情

  public String getReimburseTitle() {
    return reimburseTitle;
  }

  public void setReimburseTitle(String reimburseTitle) {
    this.reimburseTitle = reimburseTitle;
  }

  public Integer getReimburseId() {
    return reimburseId;
  }

  public void setReimburseId(Integer reimburseId) {
    this.reimburseId = reimburseId;
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

  public WorkflowFlow getFlowId() {
    return flowId;
  }

  public void setFlowId(WorkflowFlow flowId) {
    this.flowId = flowId;
  }

  public Timestamp getReimburseData() {
    return reimburseData;
  }

  public void setReimburseData(Timestamp reimburseData) {
    this.reimburseData = reimburseData;
  }

  public ClockinginBusiness getClockinginBusiness() {
    return clockinginBusiness;
  }

  public void setClockinginBusiness(ClockinginBusiness reimburseSerial) {
    this.clockinginBusiness = reimburseSerial;
  }

  public BigDecimal getReimburseMoney() {
    return reimburseMoney;
  }

  public void setReimburseMoney(BigDecimal reimburseMoney) {
    this.reimburseMoney = reimburseMoney;
  }

  public Integer getReimburseState() {
    return reimburseState;
  }

  public void setReimburseState(Integer reimburseState) {
    this.reimburseState = reimburseState;
  }

  public Collection<ClockinginDetails> getClockinginDetails() {
    return clockinginDetails;
  }

  public void setClockinginDetails(Collection<ClockinginDetails> clockinginDetails) {
    this.clockinginDetails = clockinginDetails;
  }
}
