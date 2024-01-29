package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

class Node{

    int data;
    Node next;

    Node(int data){

        this.data = data;
        this.next = null; //by default object references contain null

    }


}

public class LinkedList {

    Node head;


    LinkedList(){

        this.head = null;
    
    }


    //removes duplicate values from the linked list while maintaing original order
    public void removeDuplicates() {

        //creating an array list that will be used to sort and manipulate elemets of the linked list
        ArrayList<Integer> numbers = new ArrayList<>();
        //currentNode will be used to iterate through the linked list
        Node currentNode = this.head;

        //this if statement exits the method in the case the linked list is empty
        if (this.head == null){
            System.out.println("List is empty, nothing to remove.");
            return;
        }


        //appending all elements of the linked list to the arraylist
        while (currentNode != null){

            numbers.add(currentNode.data);
            currentNode = currentNode.next;

        }

        //sorting the arraylist in ascending order, all duplicates now appear consecutively
        Collections.sort(numbers);

        //iterating through the array list and only keeping duplicate values
        
        for (int i = 0; i < numbers.size()-1;) {

            System.out.println("i = " + i + ", Numbers = " + numbers);

            if (numbers.get(i) != numbers.get(i+1)){
                numbers.remove(i);
            }
            else{
                while(i+1 != numbers.size()-1 && numbers.get(i) == numbers.get(i+1)){
                    numbers.remove(i);
                }
                i++;
            }

        }

        numbers.remove(numbers.size()-1);
        System.out.println("Numbers = " + numbers);

        currentNode = this.head;

        for (Integer i : numbers) {
            
            int counter = 0;
            while (currentNode.next != null) {

                if (currentNode.data == i){
                    counter++;
                }
                if(currentNode.next.data == i)

            }

        }
        
    }

    public void insertElement(int number) {
        
        Node node = new Node(number);

        if (head == null){

            this.head = node;
        
        }
        else{

            Node currentNode = this.head;

            while (currentNode.next != null){
                currentNode = currentNode.next;
            }

            currentNode.next = node;
        
        }

    }

    public void print() {

        Node currentNode = this.head;

        System.out.print("[ ");
        while(currentNode != null){

            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;

        }
        System.out.println("]");

                
    }

    public boolean search(int number) {

        Node currentNode = this.head;

        while(currentNode != null){

            if(currentNode.data == number){
                return true;
            }
            
            currentNode = currentNode.next;
        }

        return false;

    }

    public void delete(int number) {

        //exits the method if the list is empty
        if (this.head == null){

            System.out.println("List is empty; nothing to delete.");
            return;

        }

        //currentNode will be used to traverse the list
        Node currentNode = this.head;

        //this loop executes while the currentNode is pointing to a valid node
        while(currentNode != null){

            System.out.println("CurrentNode is at element: " + currentNode.data);

            //this loop moves both head and current node forward until the first element of the list does not need to be deleted
            //once the first element of the list no longer needs to be deleted, this branch will never be executed again
            //this will ensure that this.head always points to the front of the list as it should, only moving forward in the case
            //that the first element happened to be such that it required deletion
            if(currentNode.data == number){

                this.head = currentNode.next;
                currentNode = currentNode.next;

            }
            //once the first element no longer needs to be deleted the next element will be checked before currentNode moves forward
            //this branch executes if the next node is not null and the element in the next node needs to be deleted 
            else if(currentNode.next != null && currentNode.next.data == number){

                //this while loop only executes if the next element in the list needs to be removed
                //it continues to remove consecutive elements from the list if they all match the value to be removed
                while(currentNode.next != null && currentNode.next.data == number){

                    currentNode.next = currentNode.next.next;

                }
                //the current node pointer will only move forward in the case that the next node does not require removal
                currentNode = currentNode.next;

            }
            //current node simply moves forward if the current node and the next node both do not need removal
            else {
                currentNode = currentNode.next;
            }

        }

        System.out.println("All relevant elements have been removed from the list");
    }

}

