package collectors.orderrevenuesummary;

class Order {
    private String customerName;
    private double orderAmount;

    public Order(String customerName, double orderAmount) {
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}