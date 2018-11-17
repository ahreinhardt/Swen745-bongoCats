package com.sam2019.ui;

import static spark.Spark.*;

import com.sam2019.appl.Constants;
import com.sam2019.appl.GameCenter;

import com.sam2019.ui.login.GetLogoutRoute;
import com.sam2019.ui.login.LoginController;
import com.sam2019.ui.login.LoginHandler;
import spark.TemplateEngine;



public class WebServer {



  private final TemplateEngine templateEngine;
  private final GameCenter gameCenter;


  public WebServer(
          final TemplateEngine templateEngine, GameCenter gameCenter) {
    this.templateEngine = templateEngine;
    this.gameCenter = gameCenter;
  }


  public void initialize() {

    staticFileLocation("/public");


    get(Constants.HOME_URL, new HomeController(gameCenter), templateEngine);
    get(Constants.LOGIN_URL, new LoginController(gameCenter), templateEngine);
    get(Constants.SIGNUP_URL, new SignUpController(gameCenter), templateEngine);
    get(Constants.LOGOUT_URL, new GetLogoutRoute(gameCenter), templateEngine);


    // Posts
    post(Constants.HOME_URL, new LoginHandler(gameCenter), templateEngine);


  }

}