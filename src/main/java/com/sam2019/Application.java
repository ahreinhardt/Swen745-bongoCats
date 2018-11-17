package com.sam2019;

import java.util.logging.Logger;

import com.sam2019.appl.GameCenter;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import com.sam2019.ui.WebServer;

public final class Application {
  private static final Logger LOG = Logger.getLogger(Application.class.getName());


  public static void main(String[] args) {


    final TemplateEngine templateEngine = new FreeMarkerEngine();
    final GameCenter gameCenter = new GameCenter();
    // inject the game center and freemarker engine into web server
    final WebServer webServer = new WebServer(templateEngine, gameCenter);

    // inject web server into application
    final Application app = new Application(webServer);

    // start the application up
    app.initialize();
  }


  private final WebServer webServer;


  private Application(final WebServer webServer) {
    this.webServer = webServer;
  }



  private void initialize() {
    LOG.fine("SAM 2019 is initializing.");

    // configure Spark and startup the Jetty web server
    webServer.initialize();

    // other applications might have additional services to configure

    LOG.fine("SAM 2019 initialization complete.");
  }

}