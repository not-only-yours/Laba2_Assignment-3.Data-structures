import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class ParseString {
    public static String RPN=new String();
    public static ArrayList<Character> stek=new ArrayList<>();
    public static String buff=new String();
    public static ArrayList<Pair<Integer,Character>> Multiply=new ArrayList<>();
    public static Pair<Integer,Character> First = new Pair<>(2,'+');
    public static Pair<Integer,Character> Second = new Pair<>(2,'-');
    public static Pair<Integer,Character> Third = new Pair<>(2,'*');
    public static Pair<Integer,Character> Fourth = new Pair<>(2,'/');
    public static Pair<Integer,Character> Fifth = new Pair<>(4,'^');
    public static void parseString(){

        Multiply.add(First);
        Multiply.add(Second);
        Multiply.add(Third);
        Multiply.add(Fourth);
        Multiply.add(Fifth);
        buff = new String();
        RPN = new String();
        stek = new ArrayList<>();
        Scanner input = new Scanner(System.in);
                buff= input.nextLine().replaceAll(" ","");
        for(int i=0;i<buff.length();i++) {
            if (!stek.isEmpty()) {
                for (Pair<Integer, Character> m : Multiply) {
                    int a = 0, b = 0;
                    if (stek.get(stek.size() - 1).equals(m.getValue())) a = m.getKey();
                    if (buff.charAt(i) == m.getValue()) b = m.getKey();
                    if (a > b) {
                        RPN += Character.toString(stek.get(stek.size() - 1));
                        stek.remove(stek.size() - 1);
                    }
                    if (a <= b) stek.add(buff.charAt(i));
                }
            }

            if (Character.isDigit(buff.charAt(i)))
                RPN += Character.toString(buff.charAt(i));
            else stek.add(buff.charAt(i));
        }
        for(int i=stek.size()-1;i>=0;i--)RPN+=Character.toString(stek.get(i));
        System.out.println(RPN);
       System.out.println(Multiply);
    }

}

