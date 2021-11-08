package cn.gson.linyun.model.pojos.system;


import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;

import java.util.Collection;

public class SystemDepartment {

  private long departmentId;
  private String departmentName;


  private Collection<ClockinginOvertime> clockinginOvertimesByDepartmentId;

  private Collection<ClockinginLeave> clockinginLeavesByDepartment;

  public Collection<ClockinginLeave> getClockinginLeavesByDepartment() {
    return clockinginLeavesByDepartment;
  }

  public void setClockinginLeavesByDepartment(Collection<ClockinginLeave> clockinginLeavesByDepartment) {
    this.clockinginLeavesByDepartment = clockinginLeavesByDepartment;
  }

  public Collection<ClockinginOvertime> getClockinginOvertimesByDepartmentId() {
    return clockinginOvertimesByDepartmentId;
  }

  public void setClockinginOvertimesByDepartmentId(Collection<ClockinginOvertime> clockinginOvertimesByDepartmentId) {
    this.clockinginOvertimesByDepartmentId = clockinginOvertimesByDepartmentId;
  }

  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

}
