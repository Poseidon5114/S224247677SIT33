package web.service;

import static org.junit.Assert.*;
import org.junit.Test;
import web.service.MathQuestionService;

public class TestMathQuestionService {

    // Addition

    @Test
    public void testQ1Addition_validIntegers() {
        assertEquals(9.0, MathQuestionService.q1Addition("4", "5"), 0.001);
    }

    @Test
    public void testQ1Addition_validDecimals() {
        assertEquals(5.5, MathQuestionService.q1Addition("2.0", "3.5"), 0.001);
    }

    @Test
    public void testQ1Addition_withNegative() {
        assertEquals(-1.0, MathQuestionService.q1Addition("4", "-5"), 0.001);
    }

    @Test
    public void testQ1Addition_withZero() {
        assertEquals(4.0, MathQuestionService.q1Addition("4", "0"), 0.001);
    }

    @Test
    public void testQ1Addition_scientificNotation() {
        assertEquals(1100.0, MathQuestionService.q1Addition("1e3", "1e2"), 0.001);
    }

    @Test
    public void testQ1Addition_invalidInput() {
        assertNull(MathQuestionService.q1Addition("abc", "2"));
    }

    @Test
    public void testQ1Addition_nullInput() {
        assertNull(MathQuestionService.q1Addition(null, "5"));
    }

    @Test
    public void testQ1Addition_emptyInput() {
        assertNull(MathQuestionService.q1Addition(" ", "3"));
    }

    // Subtraction

    @Test
    public void testQ2Subtraction_validIntegers() {
        assertEquals(5.0, MathQuestionService.q2Subtraction("10", "5"), 0.001);
    }

    @Test
    public void testQ2Subtraction_validDecimals() {
        assertEquals(1.4, MathQuestionService.q2Subtraction("3.9", "2.5"), 0.001);
    }

    @Test
    public void testQ2Subtraction_withNegative() {
        assertEquals(10.0, MathQuestionService.q2Subtraction("5", "-5"), 0.001);
    }

    @Test
    public void testQ2Subtraction_zeroResult() {
        assertEquals(0.0, MathQuestionService.q2Subtraction("0", "0"), 0.001);
    }

    @Test
    public void testQ2Subtraction_invalidInput() {
        assertNull(MathQuestionService.q2Subtraction("x", "1"));
    }

    @Test
    public void testQ2Subtraction_nullInput() {
        assertNull(MathQuestionService.q2Subtraction("1", null));
    }

    @Test
    public void testQ2Subtraction_emptyInput() {
        assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    // Multiplication

    @Test
    public void testQ3Multiplication_validIntegers() {
        assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0.001);
    }

    @Test
    public void testQ3Multiplication_validDecimals() {
        assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3.0"), 0.001);
    }

    @Test
    public void testQ3Multiplication_withNegative() {
        assertEquals(-8.0, MathQuestionService.q3Multiplication("-2", "4"), 0.001);
    }

    @Test
    public void testQ3Multiplication_withZero() {
        assertEquals(0.0, MathQuestionService.q3Multiplication("0", "1000"), 0.001);
    }

    @Test
    public void testQ3Multiplication_scientificNotation() {
        assertEquals(1.0e6, MathQuestionService.q3Multiplication("1e3", "1e3"), 0.001);
    }

    @Test
    public void testQ3Multiplication_invalidInput() {
        assertNull(MathQuestionService.q3Multiplication("2", "bad"));
    }

    @Test
    public void testQ3Multiplication_nullInput() {
        assertNull(MathQuestionService.q3Multiplication(null, "3"));
    }

    @Test
    public void testQ3Multiplication_emptyInput() {
        assertNull(MathQuestionService.q3Multiplication("", "5"));
    }
}
