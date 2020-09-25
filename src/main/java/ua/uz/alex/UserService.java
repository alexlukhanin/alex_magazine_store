package ua.uz.alex;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> listOfUsers = new ArrayList<>();
    /*-------Pattern Singleton -----------*/
    private static ua.uz.alex.UserService userService;
    private UserService() {}
    public static ua.uz.alex.UserService getUserService() {
        if (userService == null) {
            userService = new ua.uz.alex.UserService();
        }
        return userService;
    }


    public List<User> getListOfUsers () {
        return listOfUsers;
    }

    public void saveUser(User user) {
        listOfUsers.add(user);
    }

    public User getUser(String email) {
        return listOfUsers.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }

}
