package Hash_Implementation;

/**
 * Hash
 */
public class HashMap {

    private int size;
    private Node[] table;

    HashMap(int size){
        this.size = size;
        this.table = new Node[size];
    }

    public void put(int key, int value) {

        int hash = key%this.size;
        Node node = this.table[hash];

        if (node == null){
            this.table[hash] = new Node(key, value);
        }
        else{

            while(node.getNext() != null && node.getKey() != key){
                node = node.getNext();
            }

            if(node.getKey() == key){
                node.setValue(value);
            }
            else{
                node.setNext(new Node(key, value));
            }

        }
        
    }

    public int get(int key) {

        int hash = key%this.size;
        Node node = this.table[hash];

        while(node != null){

            if (node.getKey() == key){
                return node.getValue();
            }

            node = node.getNext();
        
        }

        System.out.println("No value found for specified key in hash table.");
        return -1;
        
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            
            Node node = this.table[i];

            if(node == null){
                System.out.printf("Index %d: Null\n", i);
            }
            else{

                System.out.printf("Index %d: ", i);
                while(node != null){
                    System.out.printf("[Key: %d, Value: %d] -> ", node.getKey(), node.getValue());
                    node = node.getNext();
                }
                System.out.println("Null");

            }

        }
    }

}