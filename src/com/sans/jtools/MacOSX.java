package com.sans.jtools;

import java.io.IOException;

public class MacOSX extends Archetechture {
  private Runtime runtime;

  private MacOSX(Runtime r) {
    runtime = r;
  }

  public static MacOSX getInstance() {
    return new MacOSX(Runtime.getRuntime());
  }

  public void alert() {
    try {
      runtime.exec("echo -e \"\\a\"");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
