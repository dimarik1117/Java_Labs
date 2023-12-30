public abstract class Bike {
    protected double speed;
    protected double weight;
    protected String color;
    public Bike(double speed, double weight, String color) {
        this.speed = speed;
        this.weight = weight;
        this.color = color;
    }
    public Bike() {
        this (0, 0, "чёрный");
    }
    public double getSpeed() {
        return speed;
    }
    public double getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setColor(String color) {
        this.color = color;
    }
    protected String getValues() {
        return "Скорость велосипеда: " + speed + " км/ч\nВес велосипеда: " + weight +
                " кг\nЦвет велосипеда: " + color;
    }
    public void speedUp(double speed) {
        this.speed += speed;
    }
    public void weightUp(double weight) {
        this.weight += weight;
    }
}