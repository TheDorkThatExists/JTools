package com.sans.jtools;

public class TextUtils {
  public static void slowPrint(String a) throws InterruptedException {
    for (int i = 0; i < a.length(); i++) {
      System.out.print(a.toCharArray()[i]);
      Thread.sleep(200);
    }
  }
}
