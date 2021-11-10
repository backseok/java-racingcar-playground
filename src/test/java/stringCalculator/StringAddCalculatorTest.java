package stringCalculator;

import org.junit.jupiter.api.Test;
import stringCalculator.StringAddCalculator;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    StringAddCalculator calculator = new StringAddCalculator();

    @Test
    void splitAndSum_null_또는_빈문자열() throws Exception {
        int sum1 = calculator.splitAndSum("");
        int sum2 = calculator.splitAndSum(null);

        assertEquals(sum1, 0);
        assertEquals(sum2, 0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int value = 5;
        int sum = calculator.splitAndSum(Integer.toString(value));

        assertEquals(sum, value);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int sum1 = calculator.splitAndSum("1,2");
        int sum2 = calculator.splitAndSum("123,456");

        assertEquals(sum1, 3);
        assertEquals(sum2, 579);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론구분자() throws Exception {
        int sum = calculator.splitAndSum("1,2:3");

        assertEquals(sum, 6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int sum = calculator.splitAndSum("//;\n1;2;3");

        assertEquals(sum, 6);
    }

    @Test
    void splitAndSum_음수_입력_RuntimeException() throws Exception {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calculator.splitAndSum("-1"));
        assertEquals(e.getMessage(), "음수를 입력할 수 없습니다.");
    }

    @Test
    void splitAndSum_숫자_아님_RuntimeException() throws Exception {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calculator.splitAndSum("a123"));
        assertEquals(e.getMessage(), "숫자 이외의 값은 입력할 수 없습니다.");
    }
}