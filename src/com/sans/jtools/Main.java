package com.sans.jtools;

import jline.Terminal;
import jline.TerminalFactory;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
  private static int wid = TerminalFactory.get().getWidth();
  private static int hei = TerminalFactory.get().getHeight();
  private static Terminal terminal = TerminalFactory.get();
  private static Archetechture a;
  private static final String OS = System.getProperty("os.name").toLowerCase();

  public static void main(String[] args) {
    assert terminal.isSupported();
    HashMap<String, FileReader> dialogs = new LinkedHashMap<>();
    try {
      readFileList(dialogs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert !args[0].equals("help") || args[1] != null;
    if(OS.equals("Windows")) a = Windows.getInstance();
    else MacOSX.getInstance();
  }

  private static void showDialog(@NotNull HashMap<String, FileReader> dialogs, String dialog) {
    BufferedReader br = new BufferedReader(dialogs.get(dialog));
    for (int i = 0; i < br.lines().count(); i++) {
      try {
        System.out.println(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void readFileList(HashMap<String, FileReader> mod) throws Exception {
    File f = new File("files.yaml");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    HashMap<String, FileReader> hashMap = new LinkedHashMap<>();
    for (int i = 0; i < br.lines().count(); i++) {
      String[] a = br.readLine().split(": ");
      hashMap.put(a[1], new FileReader(new File(a[2])));
    }
    mod = hashMap;
  }
}
