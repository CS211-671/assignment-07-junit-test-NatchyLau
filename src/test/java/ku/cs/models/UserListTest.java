package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // Add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user01", "password01");
        userList.addUser("user02", "password02");
        userList.addUser("user03", "password03");

        // Find one of them
        User user = userList.findUserByUsername("user02");

        // Assert that UserList found User
        String expected = "user02";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // Add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user01", "password01");
        userList.addUser("user02", "password02");
        userList.addUser("user03", "password03");

        // Change password of one user
        boolean actual = userList.changePassword("user01", "password01", "newPassword01");

        // Assert that user can change password
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // Add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user01", "password01");
        userList.addUser("user02", "password02");
        userList.addUser("user03", "password03");

        // Call login() with correct username and password
        User user = userList.login("user02", "password02");

        // Assert that User object is found
        assertNotNull(user);
        String expected = "user02";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // Add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user01", "password01");
        userList.addUser("user02", "password02");
        userList.addUser("user03", "password03");

        // Call login() with incorrect username or incorrect password
        User user = userList.login("user02", "wrongPassword");

        // Assert that the method returns null
        assertNull(user);
    }

}
