package com.sam2019.ui.login;

import com.sam2019.appl.Constants;
import com.sam2019.appl.GameCenter;
import com.sam2019.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class LoginController implements TemplateViewRoute {

    private GameCenter gameCenter;

    public LoginController(GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    /**
     * Handles get for the /login page
     * @param request - spark request
     * @param response - spark response
     * @return The login page if no user, the home page if a logged in user tries to login again
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        User user = request.session().attribute(Constants.SESSION_USER);
        if (user == null) {
            return new ModelAndView(Constants.DEFAULT_LOGIN_VM , Constants.LOGIN_VIEW);
        } else {
            Map<String, Object> vm = new HashMap<>();
            vm.put(Constants.TITLE_ATTR, "Welcome!");
            vm.put(Constants.WELCOME_MESSAGE_ATTR, "Welcome back " + user.getUserName() + "!");


            return new ModelAndView(vm, Constants.HOME_VIEW);
        }
    }

}
