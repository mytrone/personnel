package cn.gson.linyun.model.pojos.flnance;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.workflow.Alinkey;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

public class ClockinginReimburse {/*报销申请*/

  private Integer reimburseId;
  private Alinkey alinkeyId;//类型
  private ArchivesEmp empId;//申请人
  private WorkflowFlow flowId;
  private Timestamp reimburseData;//申请时间
  private String reimburseSerial;//标题
  private BigDecimal reimburseMoney;//总金额
  private Integer reimburseState;//状态
  private String reimburseTitle;

  public String getReimburseTitle() {
    return reimburseTitle;
  }

  public void setReimburseTitle(String reimburseTitle) {
    this.reimburseTitle = reimburseTitle;
  }

  private Collection<ClockinginDetails> clockinginDetails;//报销详情

  @Override
  public String toString() {
    return "ClockinginReimburse{" +
            "reimburseId=" + reimburseId +
            ", reimburseData=" + reimburseData +
            ", reimburseSerial='" + reimburseSerial + '\'' +
            ", reimburseMoney=" + reimburseMoney +
            ", reimburseState=" + reimburseState +
            '}';
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
@OneToOne
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

  public String getReimburseSerial() {
    return reimburseSerial;
  }

  public void setReimburseSerial(String reimburseSerial) {
    this.reimburseSerial = reimburseSerial;
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
