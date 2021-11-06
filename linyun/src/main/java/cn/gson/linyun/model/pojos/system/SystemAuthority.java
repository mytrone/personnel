package cn.gson.linyun.model.pojos.system;


public class SystemAuthority {

  private long authorityId;
  private String authorityName;
  private String authorityAccess;
  private String authorityPath;
  private String authorityIoc;
  private long authorityParentId;


  public long getAuthorityId() {
    return authorityId;
  }

  public void setAuthorityId(long authorityId) {
    this.authorityId = authorityId;
  }


  public String getAuthorityName() {
    return authorityName;
  }

  public void setAuthorityName(String authorityName) {
    this.authorityName = authorityName;
  }


  public String getAuthorityAccess() {
    return authorityAccess;
  }

  public void setAuthorityAccess(String authorityAccess) {
    this.authorityAccess = authorityAccess;
  }


  public String getAuthorityPath() {
    return authorityPath;
  }

  public void setAuthorityPath(String authorityPath) {
    this.authorityPath = authorityPath;
  }


  public String getAuthorityIoc() {
    return authorityIoc;
  }

  public void setAuthorityIoc(String authorityIoc) {
    this.authorityIoc = authorityIoc;
  }


  public long getAuthorityParentId() {
    return authorityParentId;
  }

  public void setAuthorityParentId(long authorityParentId) {
    this.authorityParentId = authorityParentId;
  }

}
