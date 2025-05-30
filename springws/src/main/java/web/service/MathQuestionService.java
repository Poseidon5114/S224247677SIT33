package web.service;

public class MathQuestionService {

    private static boolean isValidNumber(String input) {
        if (input == null || input.trim().isEmpty()) return false;
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Double q1Addition(String number1, String number2) {
        if (!isValidNumber(number1) || !isValidNumber(number2)) return null;
        return Double.parseDouble(number1) + Double.parseDouble(number2);
    }

    public static Double q2Subtraction(String number1, String number2) {
        if (!isValidNumber(number1) || !isValidNumber(number2)) return null;
        return Double.parseDouble(number1) - Double.parseDouble(number2);
    }

    public static Double q3Multiplication(String number1, String number2) {
        if (!isValidNumber(number1) || !isValidNumber(number2)) return null;
        return Double.parseDouble(number1) * Double.parseDouble(number2);
    }
}
