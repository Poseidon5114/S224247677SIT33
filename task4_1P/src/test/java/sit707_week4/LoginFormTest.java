package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        String studentId = "224247677"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        String studentName = "Hitesh Bhatia"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test 
    public void testEmptyUsernameEmptyPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test 
    public void testEmptyUsernameWrongPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("", "wrong");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test 
    public void testEmptyUsernameCorrectPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test 
    public void testWrongUsernameEmptyPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("wronguser", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test 
    public void testWrongUsernameWrongPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("wronguser", "wrong");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test 
    public void testWrongUsernameCorrectPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("wronguser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test 
    public void testCorrectUsernameEmptyPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("ahsan", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test 
    public void testCorrectUsernameWrongPassword() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("ahsan", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test 
    public void testCorrectUsernameCorrectPasswordInvalidCodeEmpty() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode(""));
    }

    @Test
    public void testCorrectUsernameCorrectPasswordInvalidCodeWrong() {
    	System.out.println("	: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode("654321"));
    }

    @Test 
    public void testCorrectUsernameCorrectPasswordValidCode() {
    	System.out.println("Test-->: testCorrectUsernameCorrectPasswordValidCode");
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}
