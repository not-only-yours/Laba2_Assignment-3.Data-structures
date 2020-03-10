import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ParseString {
    public static String RPN=new String();
    public static Stack<Character> stack=new Stack<>();
    public static String buff=new String();
    public static void parseString(){
        Scanner input = new Scanner(System.in);
                buff= input.nextLine().replaceAll(" ","");
                stack.add('0');
        while(!stack.isEmpty()) {
            stack.pop();
            for (int i = 0; i < buff.length(); i++) {
                if(Character.isDigit(buff.charAt(i))){
                    RPN+=buff.charAt(i);
                }
                if(stack.isEmpty()&&!Character.isDigit(buff.charAt(i))){
                    stack.push(buff.charAt(i));
                }
                if(!stack.isEmpty()) {
                  if (buff.charAt(i) == '*' || buff.charAt(i) == '/') {
                      if (stack.peek() == '-' || stack.peek() == '+') {
                          stack.add(buff.charAt(i));
                      }
                  }
                  if (stack.peek() == '*' || stack.peek() == '/') {
                      if (buff.charAt(i) == '+' || buff.charAt(i) == '-') {
                          do {
                              RPN += stack.peek();
                              stack.pop();
                          } while (stack.peek() != '+' || stack.peek() != '-' || stack.isEmpty());
                      }
                  }
              }
            }
            System.out.println(buff);
            System.out.println(stack);
            System.out.println(RPN);
            do{
                RPN+=stack.peek();
                stack.pop();
            }while (!stack.isEmpty());
        }
    }
}

