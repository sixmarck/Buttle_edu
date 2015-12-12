package iotest;

import java.io.*;
public class aaa {

 public static void main(String[] args) {
  String input=" ";
     int a=0;
     BufferedReader   in = new BufferedReader(new InputStreamReader(System.in));
   
     System.out.print("Enter the String => ");
     
     try{
      input = in.readLine( );
     } catch (IOException  e) {
         System.out.println(e);
     }
     
     System.out.println("Your input is " + input );
     for(int i=0;i<input.length();i++) {
      char ch = input.charAt(i);
      System.out.println(i+"번째 글자 " + ch + ": " + (int)ch);
     } 
     char c = '가';
		String s = "가";
		System.out.println((int)s.charAt(0));
  }
}
