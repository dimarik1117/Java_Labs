public class ChildBike extends Bike {
    private boolean thirdWheel;
    private boolean childBell;
    private boolean basket;
    public ChildBike(double speed, double weight, String color, boolean thirdWheel, boolean childBell, boolean basket) {
        super(speed, weight, color);
        this.thirdWheel = thirdWheel;
        this.childBell = childBell;
        this.basket = basket;
    }
    public ChildBike() {
        this (0, 0, "чёрный", false, false, false);
    }
    public boolean getThirdWheel() {
        return thirdWheel;
    }
    public boolean getChildBell() {
        return childBell;
    }
    public boolean getBasket() {
        return basket;
    }
    public void setThirdWheel(boolean thirdWheel) {
        this.thirdWheel = thirdWheel;
    }
    public void setChildBell(boolean childBell) {
        this.childBell = childBell;
    }
    public void setBasket(boolean basket) {
        this.basket = basket;
    }
    @Override
    protected String getValues() {
        System.out.println(super.getValues());
        return "Наличие третьего колеса: " + thirdWheel +
                "\nНаличие детского звонка: " + childBell + "\nНаличие корзинки: " + basket;
    }
    public String isThirdWheel() {
        if (this.thirdWheel)
            return "За устойчивость можно не беспокоиться";
        else
            return "Поставьте третье колесо для безопасности";
    }
    public String isChildBell() {
        if (this.childBell)
            return "Не забудьте звонить";
        else
            return "Поставьте звонок";
    }
}