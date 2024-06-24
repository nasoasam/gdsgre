package com.example.dbunitest;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class H2 {

  private org.h2.tools.Server webServer;

  private org.h2.tools.Server tcpServer;

  private org.h2.tools.Server pgServer;

  @EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
  public void start() throws java.sql.SQLException {
      this.webServer = org.h2.tools.Server.createWebServer("-webPort", "8083", "-tcpAllowOthers").start();
      this.tcpServer = org.h2.tools.Server.createTcpServer("-tcpPort", "9093", "-tcpAllowOthers").start();
      this.pgServer = org.h2.tools.Server.createPgServer("-pgPort", "4321", "-baseDir", "~", "-pgAllowOthers").start();
  }

  @EventListener(org.springframework.context.event.ContextClosedEvent.class)
  public void stop() {
      this.tcpServer.stop();
      this.webServer.stop();
      this.pgServer.stop();
  }

}
