package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String text) {
        if (textEmpty(text)) {
            return 0;
        }
        if (isOnlyNumber(text)) {
            return Integer.parseInt(text);
        }
        String[] numbers = splitText(text);
        return getSum(numbers);
    }

    public int getSum(String[] numbers) {
        int sum = 0;
        for (String numberString : numbers) {
            sum += validNumberAndParseInt(numberString);
        }
        return sum;
    }

    private int validNumberAndParseInt(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            ifNumberNegativeThrow(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private void ifNumberNegativeThrow(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }

    public String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public boolean isOnlyNumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean textEmpty(String text) {
        return text == null || text.isBlank();
    }
}
