package decorator_design_pattern;
interface Motorcycle {
    void start();
    double getCost();
}
class BasicMotorcycle implements Motorcycle {
    @Override
    public void start() {
        System.out.println("Basic motorcycle started.");
    }

    @Override
    public double getCost() {
        return 10000.0;
    }
}
abstract class MotorcycleDecorator implements Motorcycle {
    protected Motorcycle decoratedMotorcycle;

    public MotorcycleDecorator(Motorcycle decoratedMotorcycle) {
        this.decoratedMotorcycle = decoratedMotorcycle;
    }

    @Override
    public void start() {
        decoratedMotorcycle.start();
    }

    @Override
    public double getCost() {
        return decoratedMotorcycle.getCost();
    }
}
class SportPackageDecorator extends MotorcycleDecorator {
    public SportPackageDecorator(Motorcycle decoratedMotorcycle) {
        super(decoratedMotorcycle);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Sport package added.");
    }

    @Override
    public double getCost() {
        return super.getCost() + 1500.0;
    }
}

class LuxuryPackageDecorator extends MotorcycleDecorator {
    public LuxuryPackageDecorator(Motorcycle decoratedMotorcycle) {
        super(decoratedMotorcycle);
    }
    @Override
    public void start() {
        super.start();
        System.out.println("Luxury package added.");
    }

    @Override
    public double getCost() {
        return super.getCost() + 3000.0;
    }
}
public class Main {
    public static void main(String[] args) {
        Motorcycle basicMotorcycle = new BasicMotorcycle();
        System.out.println("Basic Motorcycle Cost: $" + basicMotorcycle.getCost());

        Motorcycle sportMotorcycle = new SportPackageDecorator(new BasicMotorcycle());
        System.out.println("Sport Motorcycle Cost: $" + sportMotorcycle.getCost());

        Motorcycle luxuryMotorcycle = new LuxuryPackageDecorator(new BasicMotorcycle());
        System.out.println("Luxury Motorcycle Cost: $" + luxuryMotorcycle.getCost());
    }
}
