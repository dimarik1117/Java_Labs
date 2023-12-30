public class Order {
    private String dish;
    private String price;
    private String time;

    public Order() {
        dish = null;
        price = null;
        time = null;
    }

    public Order(String orderDish, String orderPrice, String orderTime) {
        dish = orderDish;
        price = orderPrice;
        time = orderTime;
    }

    public String getDish() {
        return dish;
    }

    public String getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public void setDish(String orderDish) {
        dish = orderDish;
    }

    public void setPrice(String orderPrice) {
        price = orderPrice;
    }

    public void setTime(String orderTime) {
        time = orderTime;
    }
}