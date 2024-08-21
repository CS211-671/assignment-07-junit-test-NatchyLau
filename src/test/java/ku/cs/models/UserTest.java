package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Username should match the given value")
    public void testIsUsername() {
        User user = new User("user01");
        assertTrue(user.isUsername("user01"));
        assertFalse(user.isUsername("wrongUser"));
    }

    @Test
    @DisplayName("Password should be hashed and stored securely")
    public void testSetPassword() {
        User user = new User("user01");
        user.setPassword("securePassword123");
        assertNotNull(user.getPassword());
    }

    @Test
    @DisplayName("Password validation should work correctly")
    public void testValidatePassword() {
        User user = new User("user01", "securePassword123");
        assertTrue(user.validatePassword("securePassword123"));
        assertFalse(user.validatePassword("wrongPassword"));
    }

    @Test
    @DisplayName("Username should be returned correctly")
    public void testGetUsername() {
        User user = new User("user01");
        assertEquals("user01", user.getUsername());
    }

    @Test
    @DisplayName("Hashed password should not be null")
    public void testGetPassword() {
        User user = new User("user01", "securePassword123");
        assertNotNull(user.getPassword());
    }
}