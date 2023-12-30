public class BMX extends Bike {
    private boolean breakController;
    private boolean seatHeight;
    private String tireColor;
    static int objects = 0;
    {
        objects++;
    }
    public BMX(double speed, double weight, String color, boolean breakController, boolean seatHeight, String tireColor) {
        super(speed, weight, color);
        this.breakController = breakController;
        this.seatHeight = seatHeight;
        this.tireColor = tireColor;
    }
    public BMX() {
        this (0, 0, "чёрный", false, false, "black");;
    }
    public boolean getBreakController() {
        return breakController;
    }
    public boolean getSeatHeight() {
        return seatHeight;
    }
    public String getTireColor() {
        return tireColor;
    }
    public void setBreakController(boolean breakController) {
        this.breakController = breakController;
    }
    public void setSeatHeight(boolean seatHeight) {
        this.seatHeight = seatHeight;
    }
    public void setTireColor(String tireColor) {
        this.tireColor = tireColor;
    }
    @Override
    protected String getValues() {
        System.out.println(super.getValues());
        return "Наличие регулятора тормоза: " + breakController + "\nНаличие настройки высоты сиденья: "
                + seatHeight + "\nЦвет шин: " + tireColor + "\nКоличество объектов BMX: " + objects;
    }
    public String isBreakController() {
        if (this.breakController)
            return "Используйте вовремя контроллер тормоза";
        else
            return "Крутите педали назад для торможения";
    }
    public String isSeatHeight() {
        if (this.seatHeight)
            return "Настройте сиденье для своего удобства";
        else
            return "Следите за осанкой спины";
    }
}