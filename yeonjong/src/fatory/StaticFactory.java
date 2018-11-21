package fatory;


class CarFactory {
    private final static String HYUNDAI = "HYUNDAI";

    public static HyundaiCar hyundaiCar;

    public static class HyundaiCar {
        String type;
        String name;
        String size;

        public HyundaiCar(String type, String name, String size) {
            this.type = type;
            this.name = name;
            this.size = size;
        }
    }

    public static HyundaiCar newHyundaiCar (String name, String size) {
        if (hyundaiCar == null) {
            hyundaiCar = new HyundaiCar(HYUNDAI, name, size);
        }
        return hyundaiCar;
    }
}

public class StaticFactory {
    private StaticFactory() {
        // Do not call me at outside.
    }

    public static StaticFactory newInstance() {
        return new StaticFactory();
    }
}

class B {
    public static void main(String[] args) {
        StaticFactory staticFactory = StaticFactory.newInstance();

        String s = "";
        for (int i = 0; i < 100; i++) {
            s += i;
        }
    }
}
