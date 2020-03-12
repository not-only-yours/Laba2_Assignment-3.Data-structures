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
            for (int i = 0; i < buff.length(); i++) {
            int priority = getToken(buff.charAt(i));
            if(priority==0)RPN+=buff.charAt(i);
            if(priority==1)stack.push(buff.charAt(i));
            if(priority>1){
                while(!stack.isEmpty()) {
                    if (getToken(stack.peek()) >= priority) RPN += stack.pop();
                    else break;
                }
                stack.push(buff.charAt(i));
                }
            if(priority==-1){
                while (getToken(stack.peek())!=1){
                    RPN+=stack.pop();
                }
                stack.pop();
            }
            if(priority==4){
                RPN+=stack.pop();
            }
            }
            while (!stack.empty()){
                RPN+=stack.pop();
            }
            System.out.println(RPN);
        }


    private static int getToken(char next){
        if(next == '*'||next=='/') return 3;
        else if(next=='+'||next=='-')return 2;
        else if(next=='(') return 1;
            else if(next==')')return -1;
            else if(next=='^')return 4;
            else return 0;
    }

}

