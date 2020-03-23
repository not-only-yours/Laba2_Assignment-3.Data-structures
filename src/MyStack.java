public class MyStack<T> {
    static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T val) {
            this.value = val;
            this.next = null;
        }

        public Node() {
            this.value = null;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
   }

    private Node<T> top;
    private int size = 0;

    public MyStack() {
        top = new Node<T>();
        size = 0;
    }

    public void push(T val) {
        Node<T> newNode = new Node<T>(val);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T top() {
        if(size == 0 || top.getNext() == null) {
            throw new java.util.NoSuchElementException();
        }

        return top.getValue();
    }

    public void pop() {
        if(size == 0 || top.getNext() == null) {
            throw new java.util.NoSuchElementException();
        }

        top = top.getNext();
        size--;
    }

    public void clear() {
        top.setNext(null);
        size = 0;
    }

    public int getSize() {
        return size;
    }
}
