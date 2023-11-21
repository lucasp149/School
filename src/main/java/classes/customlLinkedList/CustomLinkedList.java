package classes.customlLinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T extends Comparable<T>> {

   private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
   private Node<T> head;

   // constructor
   public CustomLinkedList (){
   }
   public void addElement (T element) {
      // first create the node that will be inserted
      Node<T> newNode = new Node<>(element);

      // If it is the first element
         if(this.head == null){ head = newNode;}

         else {
         // creates a node to iterate finding the last one, starting from head
            Node<T> thisNode = head;
            while(thisNode.getNextNode() != null){
               thisNode = thisNode.getNextNode();
            }
               thisNode.setNextNode(newNode);
         }
         }
   public void insertElement (T element, int index) {

      Node<T> newNode = new Node<>(element);
      Node<T> thisNode = head;

      if(index == 0){
         newNode.setNextNode(thisNode);
         head = newNode;
         return;
      }

      for(int i=1; i < index; i++){
         thisNode = thisNode.getNextNode();
      }
      newNode.setNextNode(thisNode.getNextNode());
      thisNode.setNextNode(newNode);
   }
   public void removeElement(T element) {
      Node<T> thisNode = head;
      Node<T> nextNode;

     while(thisNode.getNextNode() != null){
        if(thisNode.getNextNode().getData().equals(element)){
           nextNode = thisNode.getNextNode().getNextNode();
           thisNode.setNextNode(nextNode);
           return;
        }
        thisNode = thisNode.getNextNode();
     }
   }
   public void removeIndex(int index) {

      Node<T> thisNode = head;
      Node<T> nextNode;
      int counter = 1;

      if(index == 0) {
         head = head.getNextNode();
         return;
      }

      while(thisNode.getNextNode() != null){
         if(counter == index) {
            nextNode = thisNode.getNextNode().getNextNode();
            thisNode.setNextNode(nextNode);
            return;
         }
         thisNode = thisNode.getNextNode();
         counter++;
      }
   }
   public boolean contains(T element) {
      Node<T> thisNode = head;

      if(head.getData().equals(element)) return true;

      while(thisNode.getNextNode() != null){
         if(thisNode.getNextNode().getData().equals(element)){
            return true;
         }
         thisNode = thisNode.getNextNode();
      }

      return false;
   }
   public int size(){
      Node<T> thisNode = head;
      int counter = 1;
      while (thisNode.getNextNode() != null){
         thisNode = thisNode.getNextNode();
         counter++;
      }
      return counter;
   }
   public void clear() {
      head = null;
   }
   public boolean isEmpty() {
       return head.getData() == null;
   }
   public void showAll() {
      if(head == null) {
         LOGGER.info("The Custom Linked List is EMPTY");
         return;
      }
      else {
         Node<T> newNode;

         if(head.getNextNode() == null){
            LOGGER.info("Node --->  " + head.getData());
            return;
         }
         else {
            newNode = head.getNextNode();
            LOGGER.info("Node --->  " + head.getData());
            while(newNode.getNextNode() != null) {
               LOGGER.info("Node --->  " + newNode.getData());
               newNode = newNode.getNextNode();
            }
            LOGGER.info("Node --->  " + newNode.getData());
         }

       
      }

   }

   // Sorting
   public void bubbleSort(){
      boolean sorted = false;
      int i=0;
      Node<T> curr;
      while(!sorted){
         sorted = true;
         curr = head;
         i=0;
         while(i<size()-1){
            if(curr.getData().compareTo(curr.getNextNode().getData()) > 0){
               sorted = false;
               swap(curr);
            }
            curr = curr.getNextNode();
            i++;
         }
      }
   }

   public void swap(Node<T> curr){
      T temp = curr.getData();
      curr.setData(curr.getNextNode().getData());
      curr.getNextNode().setData(temp);
   }
}
