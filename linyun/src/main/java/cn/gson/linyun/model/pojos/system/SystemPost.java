package cn.gson.linyun.model.pojos.system;


import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;

import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;

import java.util.Collection;
import java.util.List;

public class SystemPost {

  private long postId;
  private long departmentId;
  private String postName;
  private long postParentId;
  private long postGrade;
  private SystemPost postFather;
  private SystemDepartment systemDepartment;
  private Integer PostGrade;

  public Integer getPostGrade() {
    return PostGrade;
  }

  public void setPostGrade(Integer postGrade) {
    PostGrade = postGrade;
  }

  private Collection<ClockinginOvertime> clockinginOvertimesBySystemPost;
  private Collection<ClockinginLeave> clockinginLeavesByPost;

  public Collection<ClockinginLeave> getClockinginLeavesByPost() {
    return clockinginLeavesByPost;
  }

  public void setClockinginLeavesByPost(Collection<ClockinginLeave> clockinginLeavesByPost) {
    this.clockinginLeavesByPost = clockinginLeavesByPost;
  }

  public Collection<ClockinginOvertime> getClockinginOvertimesBySystemPost() {
    return clockinginOvertimesBySystemPost;
  }

  public void setClockinginOvertimesBySystemPost(Collection<ClockinginOvertime> clockinginOvertimesBySystemPost) {
    this.clockinginOvertimesBySystemPost = clockinginOvertimesBySystemPost;
  }

  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
  }


  public long getPostParentId() {
    return postParentId;
  }

  public void setPostParentId(long postParentId) {
    this.postParentId = postParentId;
  }

  public void setPostGrade(long postGrade) {
    this.postGrade = postGrade;
  }

  public SystemPost getPostFather() {
    return postFather;
  }

  public void setPostFather(SystemPost postFather) {
    this.postFather = postFather;
  }

  public SystemDepartment getSystemDepartment() {
    return systemDepartment;
  }

  public void setSystemDepartment(SystemDepartment systemDepartment) {
    this.systemDepartment = systemDepartment;
  }
}
