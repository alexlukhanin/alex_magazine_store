package ua.uz.alex.service;

import ua.uz.alex.domain.User;

import java.util.ArrayList;
import java.util.List;

@Deprecated   // old version, that was working on early versions
public class UserFormService {
    private List<User> listOfUsers = new ArrayList<>();
    /*-------Pattern Singleton -----------*/
    private static UserFormService userFormService;
    private UserFormService() {}
    public static UserFormService getUserService() {
        if (userFormService == null) {
            userFormService = new UserFormService();
        }
        return userFormService;
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
