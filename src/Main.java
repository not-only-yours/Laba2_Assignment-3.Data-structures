public class Main {
    public static void main(String[] args){

        ParseString parse = new ParseString();

        String s = "";
        for (String str : args)
            s += str;

        parse.infixToPostfix(s);

        double ans = parse.getInfix();
        System.out.println(ans);
    }
}
