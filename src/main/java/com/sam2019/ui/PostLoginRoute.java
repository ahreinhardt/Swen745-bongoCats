package com.sam2019.ui;

import com.sam2019.appl.Constants;
import com.sam2019.appl.GameCenter;
import com.sam2019.model.User;
import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class ensures the user to be logged in before go to other pages
 */
public abstract class PostLoginRoute implements TemplateViewRoute {

    protected GameCenter gameCenter;

    public PostLoginRoute(GameCenter gameCenter) {

        this.gameCenter = gameCenter;
    }

    /**
     * Checks if there is a user in the session, if so, handles the response, else returns to login page
     * @param request - spark request
     * @param response - spark response
     * @return - The model and view for where to go next
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Session session = request.session();
        User user = session.attribute(Constants.SESSION_USER);
        if (user != null) {
            return this.postHandle(request, response);
        } else  {
            Map<String, Object> vm = new HashMap<>();
            vm.put(Constants.TITLE_ATTR, "Login");
            vm.put(Constants.FAILED_LOGIN_ATTR, true);
            vm.put(Constants.FAILED_LOGIN_MESSAGE_ATTR, "Error: You must be logged in to access this page.");
            return new ModelAndView(vm , Constants.LOGIN_VIEW);
        }

    }


    public abstract ModelAndView postHandle(Request request, Response response);
}
