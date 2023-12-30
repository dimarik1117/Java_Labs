public class MountBike extends Bike {
    private double wheelDiameter;
    private double tireWidth;
    private boolean speedController;
    public MountBike(double speed, double weight, String color, double wheelDiameter, double tireWidth, boolean speedController) {
        super(speed, weight, color);
        this.wheelDiameter = wheelDiameter;
        this.tireWidth = tireWidth;
        this.speedController = speedController;
    }
    public MountBike() {
        this (0, 0, "чёрный", 0, 0, false);
    }
    public double getWheelDiameter() {
        return wheelDiameter;
    }
    public double getTireWidth() {
        return tireWidth;
    }
    public boolean getSpeedController() {
        return speedController;
    }
    public void setWheelDiameter(double wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }
    public void setTireWidth(double tireWidth) {
        this.tireWidth = tireWidth;
    }
    public void setSpeedController(boolean speedController) {
        this.speedController = speedController;
    }
    @Override
    protected String getValues() {
        System.out.println(super.getValues());
        return "Диаметр колеса: " + wheelDiameter + " \"\nШирина шины: " +
                tireWidth + " мм\nНаличие регулятора скоростия: " + speedController;
    }
    public void wheelDiameterUp(double wheelDiameter) {
        this.wheelDiameter += wheelDiameter;
    }
    public void tireWidthUp(double tireWidth) {
        this.tireWidth += tireWidth;
    }
}