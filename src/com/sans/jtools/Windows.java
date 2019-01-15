package com.sans.jtools;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Windows extends Archetechture {
  private Runtime runtime;

  private Windows(Runtime r) {
    runtime = r;
  }

  @NotNull
  @Contract(" -> new")
  public static Windows getInstance() {
    return new Windows(Runtime.getRuntime());
  }
}
