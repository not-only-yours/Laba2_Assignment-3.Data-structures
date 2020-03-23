public class Main {
    public static void main(String[] args){

        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(22);
        //stack.pop();
        stack.push(33);

        System.out.print(stack.top());
    }
}
