package Hash_Implementation;

/**
 * Node
 */
public class Node {

    private int key;
    private int value;
    private Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    //getters
    public int getKey() {
        return this.key;
    }
    public Node getNext() {
        return this.next;
    }
    public int getValue() {
        return this.value;
    }

    //setters
    public void setValue(int value) {
        this.value = value;
    }
    public void setNext(Node next) {
        this.next = next;
    }

}