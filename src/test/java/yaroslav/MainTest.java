package yaroslav;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static yaroslav.Main.CarrotAlg;

class MainTest {

    @Test
    void testValidWeights() throws IOException {
        Carrot carrot = new Carrot(new int[]{5, 10, 15}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(12, result);
    }

    @Test
    void testZeroWeight() throws IOException {
        Carrot carrot = new Carrot(new int[]{0, 10, 15}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testNegativeWeight() throws IOException {
        Carrot carrot = new Carrot(new int[]{-5, 10, 15}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testEmptyWeights() throws IOException {
        Carrot carrot = new Carrot(new int[]{}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testGeneralCalculation() throws IOException {
        Carrot carrot = new Carrot(new int[]{1, 1, 1}, 3, 1);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(3, result);
    }
}