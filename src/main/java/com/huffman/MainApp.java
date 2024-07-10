package com.huffman;

import java.util.Scanner;

class MainApp {

  public static void main(String[] args) {
    String str;
   Huffman huffman=new Huffman("aaaaaa");
   str =huffman.encode();
    System.out.println(str);
   str=huffman.decode(str);
      System.out.println(str);

  }
}
