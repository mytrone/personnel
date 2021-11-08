package cn.gson.linyun.model.pojos.system;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;

public class SystemStaff {

  private long staffId;
  private long empId;
  private String staffAccount;
  private String staffCode;
  private long staffState;
  private SystemDepartment department;
  private ArchivesEmp archivesEmp;
  private SystemPost post;

  public long getStaffId() {
    return staffId;
  }

  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }


  public long getEmpId() {
    return empId;
  }

  public void setEmpId(long empId) {
    this.empId = empId;
  }


  public String getStaffAccount() {
    return staffAccount;
  }

  public void setStaffAccount(String staffAccount) {
    this.staffAccount = staffAccount;
  }


  public String getStaffCode() {
    return staffCode;
  }

  public void setStaffCode(String staffCode) {
    this.staffCode = staffCode;
  }

  public long getStaffState() {
    return staffState;
  }

  public void setStaffState(long staffState) {
    this.staffState = staffState;
  }

  public SystemDepartment getDepartment() {
    return department;
  }

  public void setDepartment(SystemDepartment department) {
    this.department = department;
  }

  public ArchivesEmp getArchivesEmp() {
    return archivesEmp;
  }

  public void setArchivesEmp(ArchivesEmp archivesEmp) {
    this.archivesEmp = archivesEmp;
  }

  public SystemPost getPost() {
    return post;
  }

  public void setPost(SystemPost post) {
    this.post = post;
  }

  @Override
  public String toString() {
    return "SystemStaff{" +
            "staffAccount='" + staffAccount + '\'' +
            ", staffCode='" + staffCode + '\'' +
            ", staffState=" + staffState +
            '}';
  }
}
