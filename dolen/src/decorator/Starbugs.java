package decorator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

abstract class Decorator {
    private int cost;
    private String name;
    private Decorator decorator;

    public Decorator getDecorator() {
        return decorator;
    }

    public Decorator setDecorator(Decorator decorator) {
        this.decorator = decorator;
        return this;
    }

    public void setDecorators (Decorator ...decorators) {
        for (Decorator decorator : decorators) {
            this.decorator = decorator.setDecorator(this.decorator);
        }
    }

    public int cost () {
        int cost = this.getCost();
        if (this.decorator == null) {
            return cost;
        }
        return this.innerCost();
    }

    abstract int innerCost();

    public abstract String getDescription();

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}


class HouseBlendedCoffee extends Decorator {
    private String name = "하우스 블랜딛으";

    @Override
    public String getDescription() {
        return this.name;
    }

    @Override
    int innerCost() {
        return 5000 + this.getDecorator().cost();
    }
}

class VanillaLatte extends Decorator {
    private String name = "밴일라 래때";

    @Override
    public String getDescription() {
        return this.name;
    }

    @Override
    int innerCost() {
        return 6500 + this.getDecorator().cost();
    }
}

class Whip extends Decorator {
    @Override
    public String getDescription() {
        return super.getName() + ", 휩힝클임";
    }

    @Override
    int innerCost() {
        return 500 + this.getDecorator().cost();
    }
}

class Sugar extends Decorator {
    @Override
    public String getDescription() {
        return super.getName() + ", 오슈가슈가";
    }

    @Override
    int innerCost() {
        return 100 + this.getDecorator().cost();
    }
}

class Run {
    public static void main(String[] args) {
        Decorator houseBlendedCoffee = new HouseBlendedCoffee();
        houseBlendedCoffee.setDecorators(new Whip(), new Sugar(), new Whip());
        System.out.println(houseBlendedCoffee.cost());

        Decorator vanillaLatte = new VanillaLatte();
        vanillaLatte.setDecorators(new Whip(), new Sugar(), new Sugar(), new Sugar());
        System.out.println(vanillaLatte.cost());
    }
}
