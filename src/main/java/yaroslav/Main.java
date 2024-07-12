package yaroslav;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final int[] carrotWeight = {1, 2, 3, 4, 5};
        final int maxWeight = 5;
        final int walking = 10;
        Carrot carrot = new Carrot(carrotWeight, maxWeight, walking);
        int result = CarrotAlg(carrot);
        System.out.println(result);
    }

    public static int CarrotAlg(Carrot carrot) throws IOException {
        int general = 0;
        try {
            int[] weights = carrot.getWeight();
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] <= 0) {
                    throw new IllegalArgumentException("Есть нулевой/отрицательный элемент");
                }
            }
            int min = weights[0];
            for (int i = 1; i < weights.length; i++) {
                if (weights[i] < min) {
                    min = weights[i];
                }
            }
            if (min > 0) {
                general = carrot.getMaxWeight() / min;
            } else {
                throw new ArithmeticException("Есть нулевой/отрицательный элемент");
            }

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return general * carrot.getWalking();
    }
}