import java.util.ArrayList;
import java.util.Scanner;

public class ParseString {
    private static ArrayList<Integer> numOfEllements;
    private static ArrayList<Character> methodsOfString;

    public static void ParseString(){
        Scanner input = new Scanner(System.in);
        String buff = input.nextLine();
        int lastChar=0;
        for(int i=0;i<buff.length();i++) {
            char thiss=buff.charAt(i);
        if(!Character.isDigit(thiss)) {
            methodsOfString.add(thiss);
            lastChar=i;
        } else{
            String number = new String();
            for(int j=lastChar; j<i;j++){
                number+=buff.charAt(j);
            }
            numOfEllements.add(Integer.parseInt(number));
        }
        }
        }
}
