package IteratorsAndComparatorsExercise.StackIterator;

import java.util.Iterator;

public class Stack implements Iterable<Integer> {
    private Node top;
    private int size;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int element = current.element;
                current = current.prev;
                return element;
            }
        };
    }

    private static class Node {
        private int element;
        private Node prev;

        public Node(int element, Node prev) {
            this.element = element;
            this.prev = prev;
        }
    }

    public Stack() {
    }

    public void push(String... elements) {
        for (String element : elements) {
            int number = Integer.parseInt(element);
            Node newNode = new Node(number, this.top);
            this.top = newNode;
            this.size++;
        }
    }

    public int pop() {
        checkNotEmpty();
        int element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    public int peek() {
        checkNotEmpty();
        return this.top.element;
    }

    public int size() {
        return this.size;
    }

    private void checkNotEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("No elements");
        }
    }

    public static void print(Stack stack) {
        for (Integer number : stack) {
            System.out.println(number);
        }
    }
}
