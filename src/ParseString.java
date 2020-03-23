import java.util.Scanner;
import java.util.Stack;

public class ParseString {
    private static String RPN = new String();
    private static MyStack<Character> stack = new MyStack<>();

    public static void infixToPostfix(String input) {
        String buff = input.replaceAll(" ","");
        String temp = "";

        for (int i = 0; i < buff.length(); i++) {
            int priority = getToken(buff.charAt(i));

            if (priority == 0 && i != buff.length() - 1) {
                temp += buff.charAt(i);
                continue;
            } else {
                if (i == buff.length() - 1 && priority == 0)
                    temp += buff.charAt(i);
                RPN += " " + temp;
                temp = "";
            }
            if (buff.charAt(i) == '-' && (i == 0 || (i > 0 && getToken(buff.charAt(i-1)) >= 1))) {
                temp += buff.charAt(i);
                continue;
            }
            if (priority == 1)
                stack.push(buff.charAt(i));
            if (priority > 1){
                while (!stack.isEmpty()) {
                    if (getToken(stack.peek()) >= priority) RPN += " " + stack.pop();
                    else break;
                }
                stack.push(buff.charAt(i));
            }
            if (priority==-1) {
                while (getToken(stack.top())!=1) {
                    RPN += " " + stack.pop();
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            RPN += " " + stack.pop();
        }
    }

    public double getInfix() {
        MyStack<Double> stack = new MyStack<>();
        String temp = "";

        for (int i=0; i<RPN.length(); i++) {
            char ch = RPN.charAt(i);

            if (ch == ' ') {
                if (!temp.equals(""))
                    stack.push(Double.valueOf(temp));
                temp = "";
                continue;
            }

            if (getToken(ch) == 0 || (ch == '-' && (i < RPN.length() - 1) && RPN.charAt(i+1) != ' ')) {
                temp += ch;
            } else {
                Double op1 = stack.top();
                stack.pop();
                Double op2 = stack.top();
                stack.pop();

                if (ch == '+')
                    stack.push(op2 + op1);
                if (ch == '-')
                    stack.push(op2 - op1);
                if (ch == '*')
                    stack.push(op2 * op1);
                if (ch == '/')
                    stack.push(op2 / op1);
                if (ch == '^')
                    stack.push(Math.pow(op2, op1) );
            }
        }

        return stack.top();
    }

    private static int getToken(char next) {
        if (next == '*' || next=='/')
            return 3;
        else if (next=='+' || next=='-')
            return 2;
        else if (next=='(')
            return 1;
        else if (next==')')
            return -1;
        else if (next=='^')
            return 4;
        else return 0;
    }

}
