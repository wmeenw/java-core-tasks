package task4;

public class FixedIncrementStrategy implements CapacityStrategy {
    private final int increment;

    public FixedIncrementStrategy(int increment){
        this.increment = increment;
    }
    @Override
    public int calculateNewCapacity(int currentCapacity, int requiredCapacity) {
        int newCapacity = currentCapacity + increment;
        return Math.max(newCapacity, requiredCapacity);
    }
}
