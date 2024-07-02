package top.hugongzi.entity;

public class Admin {
  private long aid;
  private String adminId;
  private String adminName;
  private String adminPassword;
  private long adminType;
  private java.sql.Timestamp createtime;

  public Admin(String adminId, String adminPassword) {
    this.adminId = adminId;
    this.adminPassword = adminPassword;
  }

  public Admin() {

  }


  public long getAid() {
    return aid;
  }

  public void setAid(long aid) {
    this.aid = aid;
  }


  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }


  public long getAdminType() {
    return adminType;
  }

  public void setAdminType(long adminType) {
    this.adminType = adminType;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

}
