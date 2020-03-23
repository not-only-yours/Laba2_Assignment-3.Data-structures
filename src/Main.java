public class Main {
    public static void main(String[] args){

        ParseString parse = new ParseString();

        String s = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";

        parse.infixToPostfix(s);

        double adn = parse.getInfix();
        System.out.println("RESULT: " + adn);
    }
}
