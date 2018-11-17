package com.sam2019.ui;
import com.sam2019.appl.Constants;
import com.sam2019.appl.GameCenter;
import com.sam2019.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class SignUpController implements TemplateViewRoute{
    private GameCenter gameCenter;

    public SignUpController(GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }



    @Override
    public ModelAndView handle(Request request, Response response) {
        User user = request.session().attribute(Constants.SESSION_USER);
        if (user == null) {
            return new ModelAndView(Constants.DEFAULT_LOGIN_VM , Constants.SIGNUP_VIEW);
        } else {
            Map<String, Object> vm = new HashMap<>();
            vm.put(Constants.TITLE_ATTR, "Welcome!");



            return new ModelAndView(vm, Constants.LOGIN_VIEW);
        }
    }
}
