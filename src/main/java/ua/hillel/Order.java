package ua.hillel;

public class Order {
    private int orderNum;
    private String guestName;

    public Order(int orderNum, String guestName) {
        this.orderNum = orderNum;
        this.guestName = guestName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
            this.guestName = guestName;
    }

    @Override
    public String toString() {
        return orderNum + " | " + guestName;
    }
}
