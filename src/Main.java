public class Main {
    public static void main(String[] args) {

        ParseString parse = new ParseString();

        String s = "";
        for (String str : args)
            s += str;

        System.out.println(parse.infixToPostfix(s));

        /*System.out.println(parse.RPN);

        double ans = parse.getInfix();
        System.out.println(ans);*/
    }
}
