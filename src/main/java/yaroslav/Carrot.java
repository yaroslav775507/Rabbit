package yaroslav;

public class Carrot {
    private int[] weight;

    private int maxWeight;

    private int walking;

    public Carrot(int[] weight, int maxWeight, int walking) {
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.walking = walking;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getWalking() {
        return walking;
    }

    public void setWalking(int walking) {
        this.walking = walking;
    }

    public int[] getWeight() {
        return weight;
    }

    public void setWeight(int[] weight) {
        this.weight = weight;
    }

    public void print() {
        for (int i = 0; i < weight.length; i++) {
            System.out.println(i);
        }
    }

}
