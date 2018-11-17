package com.sam2019.appl;
import com.sam2019.model.User;
import spark.Session;
import java.util.HashMap;
import java.util.Map;

public class GameCenter {

    Map<String, User> currentUsers;


    public GameCenter() {

        this.currentUsers = new HashMap<>();
    }

    public boolean login(String userName, Session session) {

        if (currentUsers.containsKey(userName)) {
            return false;
        } else {
            User user = new User(userName);
            this.currentUsers.put(userName, user);
            session.attribute(Constants.SESSION_USER, user);
            return true;
        }
    }

    public void logout(Session session) {

        currentUsers.remove(Constants.SESSION_USER);
        session.removeAttribute(Constants.SESSION_USER);
    }




}
