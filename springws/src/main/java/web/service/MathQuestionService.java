package web.service;

public class MathQuestionService {

    /**
     * Validates that the input string is a valid number.
     *
     * @param input the string to validate
     * @return true if valid, false otherwise
     */
    private static boolean isValidNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Safe addition for Q1.
     *
     * @param number1 first input string
     * @param number2 second input string
     * @return sum or null if invalid input
     */
    public static Double q1Addition(String number1, String number2) {
        if (!isValidNumber(number1) || !isValidNumber(number2)) {
            return null;
        }
        return Double.parseDouble(number1) + Double.parseDouble(number2);
    }

    /**
     * Safe subtraction for Q2.
     *
     * @param number1 first input string
     * @param number2 second input string
     * @return difference or null if invalid input
     */
    public static Double q2Subtraction(String number1, String number2) {
        if (!isValidNumber(number1) || !isValidNumber(number2)) {
            return null;
        }
        return Double.parseDouble(number1) - Double.parseDouble(number2);
    }

    /**
     * Safe multiplication for Q3.
     *
     * @param number1 first input string
     * @param number2 second input string
     * @return product or null if invalid input
     */
    public static Double q3Multiplication(String number1, String number2) {
        if (!isValidNumber(number1) || !isValidNumber(number2)) {
            return null;
        }
        return Double.parseDouble(number1) * Double.parseDouble(number2);
    }
}

