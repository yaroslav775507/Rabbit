package yaroslav;

public class Carrot {
    private final int[] weight;

    private final int maxWeight;

    private final int walking;

    public Carrot(int[] weight, int maxWeight, int walking) {
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.walking = walking;
    }

    public int getWalking() {
        return walking;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int[] getWeight() {
        return weight;
    }
}
