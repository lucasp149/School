package classes.customlLinkedList;

public class Node<T> {
    private T data;
    private Node<T> nextNode;

    // constructor
    public Node (T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nexNode) {
        this.nextNode = nexNode;
    }
}

