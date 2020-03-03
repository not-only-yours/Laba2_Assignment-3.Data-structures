import java.util.ArrayList;
import java.util.Scanner;

public class ParseString {
    private static ArrayList<Integer> numOfEllements;
    private static ArrayList<Character> methodsOfString;

    public static void parseString(){
        Scanner input = new Scanner(System.in);
        String buff = input.nextLine().replaceAll(" ","");
        String number = new String();
        methodsOfString = new ArrayList<>();
        numOfEllements = new ArrayList<>();
            for(int i=0;i<buff.length();i++)
        {
            int j=i-1;
            char thiss=buff.charAt(i);
        if(!Character.isDigit(thiss)) {
            methodsOfString.add(thiss);
            number="";
            do {
                number=buff.charAt(j)+number;
                if(j==1)number=buff.charAt(0)+number;
                j--;
            }while(Character.isDigit(buff.charAt(j))&&j>0);
            if(!number.isEmpty())numOfEllements.add(Integer.parseInt(number));
        }
        if(i+1==buff.length()){
            number="";
            j=i;
            do {
                number=buff.charAt(j)+number;
                j--;
            }while(Character.isDigit(buff.charAt(j)));
            numOfEllements.add(Integer.parseInt(number));
        }
        }
            System.out.println(numOfEllements);
            System.out.println(methodsOfString);
        }

        public static ArrayList<Integer> setNumOfEllements(){
        return numOfEllements;
    }
    public static ArrayList<Character> setMethodsOfString(){
        return methodsOfString;
    }
}