package project;

import java.io.Console;

public class Main {
  public static void main(String[] args) {
    Console console = System.console();
    AsciiView text = new AsciiView();
    text.menu();
    if (console == null) {
      GuiView controller = new GuiView();
      controller.draw();
    }
  }
}
