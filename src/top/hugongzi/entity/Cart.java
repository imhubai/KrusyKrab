package top.hugongzi.entity;

import java.util.Map;

public class Cart {

    private Map<String, productItem> items;
    private int count;
    private String price;
    private String action;

    public Map<String, productItem> getItems() {
        return items;
    }

    public void setItems(Map<String, productItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", count=" + count +
                ", price='" + price + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}