package com.ds.java;

/**
 *Exception to indicate that LinkedList is empty.
 */
class LinkedListEmptyException extends RuntimeException{
       public LinkedListEmptyException(){
         super();
       }
      
     public LinkedListEmptyException(String message){
         super(message);
       }  
}
 
/**
 *Exception to indicate that Stack is empty.
 */
class StackEmptyException extends RuntimeException {
     
    public StackEmptyException(){
        super();
    }
    
    public StackEmptyException(String message){
        super(message);
    }
    
}
 
/**
 *Node class, which holds data and contains next which points to next Node.
 */
class Node3 {
    public int data; // data in Node.
    public Node3 next; // points to next Node in list.
 
    /**
     * Constructor
     */
    public Node3(int data){
           this.data = data;
    }
 
    /**
     * Display Node's data
     */
    public void displayNode() {
           System.out.print( data + " ");
    }
}
 
 
/**
 * LinkedList class
 */
class LinkedList3 {
    private Node3 first; // ref to first link on list
 
    /**
     * LinkedList constructor
     */
    public LinkedList3(){
           first = null;
    }
 
    /**
     * Insert New Node at first position
     */
    public void insertFirst(int data) {
           Node3 newNode = new Node3(data); //Creation of New Node.
           newNode.next = first;   //newLink ---> old first
           first = newNode;  //first ---> newNode
    }
 
    /**
     * Deletes first Node
     */
    public Node3 deleteFirst()
    {
           if(first==null){  //means LinkedList in empty, throw exception.              
                  throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
           }
           Node3 tempNode = first; // save reference to first Node in tempNode- so that we could return saved reference.
           first = first.next; // delete first Node (make first point to second node)
           return tempNode; // return tempNode (i.e. deleted Node)
    }
    
           
    /**
     * Display LinkedList
     */
    public void displayLinkedList() {
           Node3 tempDisplay = first; // start at the beginning of linkedList
           while (tempDisplay != null){ // Executes until we don't find end of list.
                  tempDisplay.displayNode();
                  tempDisplay = tempDisplay.next; // move to next Node
           }
           System.out.println();
           
    }
 
}
 
 
/**
 * For implementing stack using using LinkedList- This StackLinkedList
 * class internally maintains LinkedList reference in java.
 */
 
class StackLinkedList{
    
    LinkedList3 linkedList = new LinkedList3(); // creation of Linked List
    
    /**
     * Push items in stack, it will put items on top of Stack.
     */
    public void push(int value){
           linkedList.insertFirst(value);
    }
 
    /**
     * Pop items in stack, it will remove items from top of Stack.
     */
    public void pop() throws StackEmptyException {
           try{
           linkedList.deleteFirst();
           }catch(LinkedListEmptyException llee){
                  throw new StackEmptyException();
           }
    }
 
    /**
     * Display stack.
     */
    public void displayStack() {
           System.out.print("Displaying Stack >  Top to Bottom : ");
           linkedList.displayLinkedList();
    }
 
    
}
 
 
/**
 * Main class - To test Stack Implementation Using LinkedList in java
 */
public class StackImplementationUsingLinkedListExample {
    public static void main(String[] args) {
    
           StackLinkedList stackLinkedList=new StackLinkedList();
           System.out.println("INSERTING AT FIRST (TOP) IN STACK IMPLEMENTED USING LINKED LIST ");
           stackLinkedList.push(39);  //push node.
           stackLinkedList.displayStack(); // display STACK IMPLEMENTED USING LINKED LIST in java
           stackLinkedList.push(71);  //push node.
           stackLinkedList.displayStack(); // display STACK IMPLEMENTED USING LINKED LIST in java
           stackLinkedList.push(11);  //push node.
           stackLinkedList.displayStack(); // display STACK IMPLEMENTED USING LINKED LIST in java
           stackLinkedList.push(76);  //push node.
           stackLinkedList.displayStack(); // display STACK IMPLEMENTED USING LINKED LIST in java
 
           System.out.println("\nDELETING FROM FIRST (TOP) FROM STACK IMPLEMENTED USING LINKED LIST ");
 
           stackLinkedList.pop();  //pop Node
           stackLinkedList.displayStack();  // display STACK IMPLEMENTED USING LINKED LIST in java
           stackLinkedList.pop();  //pop Node
           stackLinkedList.displayStack();  // display STACK IMPLEMENTED USING LINKED LIST in java
           stackLinkedList.pop();  //pop Node
           stackLinkedList.displayStack();  // display STACK IMPLEMENTED USING LINKED LIST in java
           stackLinkedList.pop();  //pop Node
           stackLinkedList.displayStack();  // display STACK IMPLEMENTED USING LINKED LIST in java
           
           
 
    }
}
 
/*OUTPUT
 
INSERTING AT FIRST (TOP) IN STACK IMPLEMENTED USING LINKED LIST
Displaying Stack >  Top to Bottom : 39
Displaying Stack >  Top to Bottom : 71 39
Displaying Stack >  Top to Bottom : 11 71 39
Displaying Stack >  Top to Bottom : 76 11 71 39
 
DELETING FROM FIRST (TOP) FROM STACK IMPLEMENTED USING LINKED LIST
Displaying Stack >  Top to Bottom : 11 71 39
Displaying Stack >  Top to Bottom : 71 39
Displaying Stack >  Top to Bottom : 39
Displaying Stack >  Top to Bottom :
 
*/
