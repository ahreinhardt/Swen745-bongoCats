package com.sam2019.ui;

import com.sam2019.appl.Constants;
import com.sam2019.appl.GameCenter;
import com.sam2019.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;


public class HomeController extends PostLoginRoute {

  public HomeController(GameCenter gameCenter) {
    super(gameCenter);
  }


  @Override
  public ModelAndView postHandle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put(Constants.TITLE_ATTR, "Welcome!");
    User user = request.session().attribute(Constants.SESSION_USER);
    vm.put(Constants.WELCOME_MESSAGE_ATTR, "Welcome back " + user.getUserName() + "!");


    return new ModelAndView(vm , Constants.HOME_VIEW);
  }


}