package Kurs1024kb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {


    @Test
    void isUserExistWhenExist() {
        String[] users = {"Ja", "Ty", "On"};
        UserService userService = new UserService(users);
        boolean result = userService.isUserExist("Ja");
        Assertions.assertTrue(result);
    }

    @Test
    void isUserExistWhenNoExist() {
        String[] users = {"Ja", "Ty", "On"};
        UserService userService = new UserService(users);
        boolean result = userService.isUserExist("My");
        Assertions.assertFalse(result);
    }

    @Test
    void getUserCountNorml() {
        String[] users = {"Ja", "Ty", "On"};
        UserService userService = new UserService(users);
        int result = userService.getUserCount();
        Assertions.assertEquals(3, result);
    }

    @Test
    void getUserCountWithZero() {
        String[] users = {};
        UserService userService = new UserService(users);
        int result = userService.getUserCount();
        Assertions.assertEquals(0, result);
    }

    @Test
    void getCountRepeatsByLoginWithRepeats (){
        String[] users = {"Ja", "Ty", "On","On","On"};
        UserService userService = new UserService(users);
        int result = userService.getCountRepeatsByLogin("On");
        Assertions.assertEquals(3,result);
    }

    @Test
    void getCountRepeatsByLoginWithZeroRepeats (){
        String[] users = {"Ja", "Ty", "On","On","On"};
        UserService userService = new UserService(users);
        int result = userService.getCountRepeatsByLogin("Wy");
        Assertions.assertEquals(0,result);
    }

}