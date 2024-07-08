package top.hugongzi.entity;


public class Shop {

  private long sid;
  private String shopId;
  private String shopName;
  private String shopAddress;
  private String shopType;
  private String shopPhone;
  private java.sql.Timestamp createtime;


  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public String getShopId() {
    return shopId;
  }

  public void setShopId(String shopId) {
    this.shopId = shopId;
  }


  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }


  public String getShopAddress() {
    return shopAddress;
  }

  public void setShopAddress(String shopAddress) {
    this.shopAddress = shopAddress;
  }


  public String getShopType() {
    return shopType;
  }

  public void setShopType(String shopType) {
    this.shopType = shopType;
  }


  public String getShopPhone() {
    return shopPhone;
  }

  public void setShopPhone(String shopPhone) {
    this.shopPhone = shopPhone;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

}
