package top.hugongzi.entity;


public class UserOrder {

  private long oid;
  private long uid;
  private long sid;
  private long number;
  private long tid;
  private double orderPrice;
  private String orderState;
  private java.sql.Timestamp orderTime;
  private java.sql.Timestamp orderOkTime;
  private String payment;
  private java.sql.Timestamp orderCancelTime;
  private String action;
  private String cartJson;


  public long getOid() {
    return oid;
  }

  public void setOid(long oid) {
    this.oid = oid;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }


  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }


  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }


  public String getOrderState() {
    return orderState;
  }

  public void setOrderState(String orderState) {
    this.orderState = orderState;
  }


  public java.sql.Timestamp getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(java.sql.Timestamp orderTime) {
    this.orderTime = orderTime;
  }


  public java.sql.Timestamp getOrderOkTime() {
    return orderOkTime;
  }

  public void setOrderOkTime(java.sql.Timestamp orderOkTime) {
    this.orderOkTime = orderOkTime;
  }


  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }


  public java.sql.Timestamp getOrderCancelTime() {
    return orderCancelTime;
  }

  public void setOrderCancelTime(java.sql.Timestamp orderCancelTime) {
    this.orderCancelTime = orderCancelTime;
  }


  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  public String getCartJson() {
    return cartJson;
  }

  public void setCartJson(String cartJson) {
    this.cartJson = cartJson;
  }

}
