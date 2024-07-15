package top.hugongzi.entity;


public class Product {

  private long pid;
  private String productId;
  private String productName;
  private String productImg;
  private double productPrice;
  private long productType;
  private String productDescription;
  private String productTags;


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductImg() {
    return productImg;
  }

  public void setProductImg(String productImg) {
    this.productImg = productImg;
  }


  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }


  public long getProductType() {
    return productType;
  }

  public void setProductType(long productType) {
    this.productType = productType;
  }


  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }


  public String getProductTags() {
    return productTags;
  }

  public void setProductTags(String productTags) {
    this.productTags = productTags;
  }

}
