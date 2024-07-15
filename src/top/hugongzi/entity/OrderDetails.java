package top.hugongzi.entity;

public class OrderDetails {
    private long did;
    private long oid;
    private long pid;
    private long quantity;
    private double price;


    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }


    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
