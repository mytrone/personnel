package cn.gson.linyun.model.pojos.system;


import java.util.List;

public class SystemPost {

  private long postId;
  private long departmentId;
  private String postName;
  private long postParentId;
  private long postGrade;
  private SystemPost postFather;
  private SystemDepartment systemDepartment;

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

  public long getPostGrade() {
    return postGrade;
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
