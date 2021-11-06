package cn.gson.linyun.model.pojos.flnance;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;



public class FinanceTemplate {

  private long templateId;//主键
  private long empId;//员工id
  private long alinkeyId;//类别id
  private String templateSerial;//模板编号
  private Timestamp templateDate;//创建时间
  private String templateName;//模板名
  private ArchivesEmp archivesEmpByEmpId;//用户对象
  private Alinkey alinkeyByAlinkeyId;//类别对象

  private Collection<Relationship34> relationship34sByTemplateId;//中间表新增
  private List<FinanceItem> financeItem;

  @OneToMany
  public List<FinanceItem> getFinanceItem() {
    return financeItem;
  }

  public void setFinanceItem(List<FinanceItem> financeItem) {
    this.financeItem = financeItem;
  }

  public long getTemplateId() {
    return templateId;
  }

  public void setTemplateId(int templateId) {
    this.templateId = templateId;
  }



  public long getEmpId() {
    return empId;
  }

  public void setEmpId(long empId) {
    this.empId = empId;
  }

  public long getAlinkeyId() {
    return alinkeyId;
  }

  public void setAlinkeyId(long alinkeyId) {
    this.alinkeyId = alinkeyId;
  }

  public String getTemplateSerial() {
    return templateSerial;
  }

  public void setTemplateSerial(String templateSerial) {
    this.templateSerial = templateSerial;
  }

  public Timestamp getTemplateDate() {
    return templateDate;
  }

  public void setTemplateDate(Timestamp templateDate) {
    this.templateDate = templateDate;
  }

  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  @ManyToOne
  @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
  public ArchivesEmp getArchivesEmpByEmpId() {
    return archivesEmpByEmpId;
  }

  public void setArchivesEmpByEmpId(ArchivesEmp archivesEmpByEmpId) {
    this.archivesEmpByEmpId = archivesEmpByEmpId;
  }

  @ManyToOne
  @JoinColumn(name = "alinkey_id", referencedColumnName = "alinkey_id")
  public Alinkey getAlinkeyByAlinkeyId() {
    return alinkeyByAlinkeyId;
  }

  public void setAlinkeyByAlinkeyId(Alinkey alinkeyByAlinkeyId) {
    this.alinkeyByAlinkeyId = alinkeyByAlinkeyId;
  }



  @OneToMany(mappedBy = "financeTemplateByTemplateId")
  public Collection<Relationship34> getRelationship34sByTemplateId() {
    return relationship34sByTemplateId;
  }

  public void setRelationship34sByTemplateId(Collection<Relationship34> relationship34sByTemplateId) {
    this.relationship34sByTemplateId = relationship34sByTemplateId;
  }
}
