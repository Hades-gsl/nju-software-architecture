package com.hades;

import asciiPanel.AsciiPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    AsciiPanel panel = context.getBean("ascllPanel-talryth_15x15", AsciiPanel.class);
    panel.write("Test", 1, 1);
    System.out.println(panel.getAsciiFont().getFontFilename());
  }
}
