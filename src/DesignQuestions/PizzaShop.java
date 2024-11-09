package DesignQuestions;

// Base Pizza interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Basic Pizza types implementing the Pizza interface

class VegPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Vegetable Pizza";
    }

    @Override
    public double getCost() {
        return 250.0; // Base price
    }
}

class ChickenPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Chicken Pizza";
    }

    @Override
    public double getCost() {
        return 300.0; // Base price
    }
}

// Abstract Decorator class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// Size decorator
class SizeDecorator extends PizzaDecorator {
    private String size;  // e.g., "Base Size", "Extra Large"

    public SizeDecorator(Pizza pizza, String size) {
        super(pizza);
        this.size = size;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " (" + size + ")";
    }

    @Override
    public double getCost() {
        switch (size) {
            case "Extra Large":
                return pizza.getCost() + 100.0; // Extra cost for larger size
            case "Large":
                return pizza.getCost() + 50.0;  // Slightly less extra cost
            case "Base Size":
            default:
                return pizza.getCost(); // No extra cost for base size
        }
    }
}

// Additional Topping Decorators
class ExtraChickenDecorator extends PizzaDecorator {
    public ExtraChickenDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Extra Chicken";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 80.0; // Extra chicken cost
    }
}

class ExtraVeggiesDecorator extends PizzaDecorator {
    public ExtraVeggiesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Extra Veggies";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40.0; // Extra veggies cost
    }
}

// Example usage class
public class PizzaShop {
    public static void main(String[] args) {
        // Create a Chicken Pizza with extra chicken and large size
        Pizza pizza1 = new ExtraChickenDecorator(new SizeDecorator(new ChickenPizza(), "Large"));
        System.out.println(pizza1.getDescription() + " Cost: ₹" + pizza1.getCost());

        // Create a Veg Pizza with extra veggies and extra large size
        Pizza pizza2 = new ExtraVeggiesDecorator(new SizeDecorator(new VegPizza(), "Extra Large"));
        System.out.println(pizza2.getDescription() + " Cost: ₹" + pizza2.getCost());

        // Create a base size Chicken Pizza
        Pizza pizza3 = new SizeDecorator(new ChickenPizza(), "Base Size");
        System.out.println(pizza3.getDescription() + " Cost: ₹" + pizza3.getCost());
    }
}
