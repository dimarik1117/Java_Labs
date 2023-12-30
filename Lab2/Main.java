public class Main {
    public static void main(String[] args) {
        MountBike mount1 = new MountBike(25, 20, "серый", 28, 23, true);
        MountBike mount2 = new MountBike();
        System.out.println(mount1.getValues() + "\n");
        mount2.speedUp(5);
        mount2.weightUp(5);
        mount2.wheelDiameterUp(5);
        mount2.tireWidthUp(5);
        System.out.println(mount2.getSpeed());
        System.out.println(mount2.getWeight());
        System.out.println(mount2.getColor());
        System.out.println(mount2.getWheelDiameter());
        System.out.println(mount2.getTireWidth());
        System.out.println(mount2.getSpeedController() + "\n");

        ChildBike child = new ChildBike();
        child.setSpeed(6);
        child.setWeight(10);
        child.setColor("pink");
        child.setThirdWheel(true);
        child.setChildBell(false);
        child.setBasket(true);
        System.out.println(child.getValues());
        System.out.println(child.isThirdWheel());
        System.out.println(child.isChildBell() + "\n");

        BMX bmx1 = new BMX(30,21,"синий",true,false,"зелёный");
        System.out.println(bmx1.getValues());
        System.out.println(bmx1.isBreakController() + "\n");
        BMX bmx2 = new BMX(35,22,"красный",false,true,"жёлтый");
        System.out.println(bmx2.getValues());
        System.out.println(bmx2.isSeatHeight());
    }
}