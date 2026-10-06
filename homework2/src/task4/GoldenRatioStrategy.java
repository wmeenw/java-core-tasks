package task4;

public class GoldenRatioStrategy implements CapacityStrategy {
    private static final double golden = 1.618;
    @Override
    public int calculateNewCapacity(int currentCapacity, int requiredCapacity) {
        int newCapacity = (int)(currentCapacity * golden);
        return Math.max(newCapacity, requiredCapacity);
    }
}
