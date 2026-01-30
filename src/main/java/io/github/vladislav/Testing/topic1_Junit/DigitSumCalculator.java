package io.github.vladislav.Testing.topic1_Junit;

/**
 * Решение задачи для теста 6: Сумма цифр числа (учет отрицательного числа)
 * @author Владислав Степанов
 */
public class DigitSumCalculator {

    public static int sumDigits(int number) {
        String numStr = String.valueOf(number).trim();
        int sum = 0;
        boolean negative = false;
        int startIndex = 0;

        if (numStr.startsWith("-")) {
            negative = true;
            startIndex = 1;
        }

        for (int i = startIndex; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                if (i == startIndex && negative) {
                    sum -= digit;
                } else {
                    sum += digit;
                }
            }
        }

        return sum;
    }
}

