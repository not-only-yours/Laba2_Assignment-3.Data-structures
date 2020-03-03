import java.util.ArrayList;

public class MathMethods {

    public static void workWithNumbers(){
        ArrayList<Character> method= ParseString.setMethodsOfString();
        ArrayList<Integer> numbers = ParseString.setNumOfEllements();
        while(!method.isEmpty()){
        for(int i=0;i<method.size();i++){
            if(method.get(i)=='*'){
                int buff = numbers.get(i)*numbers.get(i-1);
                numbers.set(i,buff);
                numbers.remove(i-1);
            }
        }
        for(int i=0;i<method.size();i++){
            if(method.get(i)=='/'){
                int buff = numbers.get(i)/numbers.get(i-1);
                numbers.set(i,buff);
                numbers.remove(i-1);
            }
        }
        for(int i=0;i<method.size();i++){
            if(method.get(i)=='+'){
                int buff = numbers.get(i)+numbers.get(i-1);
                numbers.set(i,buff);
                numbers.remove(i-1);
            }
        }
        for(int i=0;i<method.size();i++){
            if(method.get(i)=='-'){
                int buff = numbers.get(i)-numbers.get(i-1);
                numbers.set(i,buff);
                numbers.remove(i-1);
            }
        }
    }
    }
}
