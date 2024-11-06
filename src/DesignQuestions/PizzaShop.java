package DesignQuestions;

// Base Pizza interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Basic Pizza types implementing the Pizza interface
class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.0; // Base price
    }
}

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

// Concrete Decorators for different toppings
class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.0; // Extra cheese cost
    }
}

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
        // Create a Margherita with extra cheese
        Pizza pizza1 = new ExtraCheeseDecorator(new Margherita());
        System.out.println(pizza1.getDescription() + " Cost: ₹" + pizza1.getCost());

        // Create a Chicken Pizza with extra cheese and chicken
        Pizza pizza2 = new ExtraChickenDecorator(
                new ExtraCheeseDecorator(
                        new ChickenPizza()));
        System.out.println(pizza2.getDescription() + " Cost: ₹" + pizza2.getCost());

        // Create a Veg Pizza with extra cheese and veggies
        Pizza pizza3 = new ExtraVeggiesDecorator(
                new ExtraCheeseDecorator(
                        new VegPizza()));
        System.out.println(pizza3.getDescription() + " Cost: ₹" + pizza3.getCost());
    }
}