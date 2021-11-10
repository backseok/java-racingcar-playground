package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorUnitTest {

    StringAddCalculator calculator = new StringAddCalculator();

    @Test
    void textEmpty() throws Exception {
        boolean result1 = calculator.textEmpty("");
        boolean result2 = calculator.textEmpty(" ");
        boolean result3 = calculator.textEmpty(null);

        assertEquals(result1, true);
        assertEquals(result2, true);
        assertEquals(result3, true);
    }

    @Test
    void isOnlyNumber() throws Exception {
        boolean result1 = calculator.isOnlyNumber("123");
        boolean result2 = calculator.isOnlyNumber("123,456");

        assertEquals(result1, true);
        assertEquals(result2, false);
    }

    @Test
    void splitText() throws Exception {
        String[] result1 = calculator.splitText("1,2:3");
        String[] result2 = calculator.splitText("//o\n1o2o3");

        assertEquals(result1.length, 3);
        assertEquals(result2.length, 3);
        for (int i = 0; i < 3; i++) {
            assertEquals(result1[i], Integer.toString(i + 1));
            assertEquals(result2[i], Integer.toString(i + 1));
        }
    }

    @Test
    void getSum() throws Exception {
        String[] strings = new String[100];
        for (int i = 0; i < 100; i++) {
            strings[i] = Integer.toString(i + 1);
        }

        int sum = calculator.getSum(strings);

        assertEquals(sum, 5050);
    }
}