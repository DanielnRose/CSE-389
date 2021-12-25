// package ods;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

/**
 * An implementation of a FIFO Queue as a singly-linked list.
 * This also includes the stack operations push and pop, which
 * operate on the head of the queue
 * @author morin
 *
 * @param <T> the class of objects stored in the queue
 */
public class SLList<T> extends AbstractQueue<T> {
 class Node {
  T x;
  Node next;
 }
 
 /**
  * Front of the queue
  */
 Node head;
 
 /**
  * Tail of the queue
  */
 Node tail;
 
 /**
  * The number of elements in the queue
  */
 int n;
 
 public Iterator<T> iterator() {
  class SLIterator implements Iterator<T> {
   protected Node p;

   public SLIterator() {
    p = head;
   }
   public boolean hasNext() {
    return p != null;
   }
   public T next() {
    T x = p.x;
    p = p.next;
    return x;
   }
   public void remove() {
    throw new UnsupportedOperationException();
   }
  }
  return new SLIterator();
 }

 @Override
 public int size() {
  // TODO Auto-generated method stub
  return n;
 }

 public boolean add(T x) {
  Node u = new Node();
  u.x = x;
  if (n == 0) {
   head = u;
  } else {
   tail.next = u;
  }
  tail = u;
  n++;
  return true;
 }
 
 public boolean offer(T x) {
  return add(x);
 }

 @Override
 public T peek() {
  return head.x;
 }

 public T poll() {
  if (n == 0)
   return null;
  T x = head.x;
  head = head.next;
  if (--n == 0)
   tail = null;
  return x;
 }
 
 /**
  * Stack push operation - push x onto the head of the list
  * @param x the element to push onto the stack
  * @return x
  */
 public T push(T x) {
  Node u = new Node();
  u.x = x;
  u.next = head;
  head = u;
  if (n == 0)
   tail = u;
  n++;
  return x;
 }
 
 protected void deleteNext(Node u) {
  if (u.next == tail)
   tail = u;
  u.next = u.next.next;
 }
 
 protected void addAfter(Node u, Node v) {
  v = u.next.next;
  u.next = v;
  if (u == tail) 
   tail = v;
 }
 
 protected Node getNode(int i) {
  Node u = head;
  for (int j = 0; j < i; j++)
   u = u.next;
  return u;
 }

 /**
  * Stack pop operation - pop off the head of the list
  * @return the element popped off 
  */
 public T remove() {
  if (n == 0) return null;
  T x = head.x;
  head = head.next;
  if (--n == 0) tail = null;
  return x;
 } 
 
 public T pop() {
  if (n == 0) return null;
  T x = head.x;
  head = head.next;
  if (--n == 0) tail = null;
  return x;
 } 

/**
 * For Lab6, Part 1
 * Name:   Rose, Daniel     // Format: Lastname, Firstname 
 * Section:   M001  // Enter either M001/M004 
 */
 
 public static void main(String[] args) {
   // Task 0: Prepare data
   // 0.1. Prepare 5 generic items g1, g2, g3, g4 and g5
   // 0.2. Prepare 5 produce items p1, p2, p3, p4 and p5
   
   GenericItem g1 = new GenericItem();
   
   g1.setName("Item 1");
   g1.setQuantity(1);
      
   GenericItem g2 = new GenericItem();
   
   g2.setName("Item 2");
   g2.setQuantity(2);
   
   GenericItem g3 = new GenericItem();
   
   g3.setName("Item 3");
   g3.setQuantity(3);
   
   GenericItem g4 = new GenericItem();
   
   g4.setName("Item 4");
   g4.setQuantity(4);
   
   GenericItem g5 = new GenericItem();
   
   g5.setName("Item 5");
   g5.setQuantity(5);
   
   ProduceItem p1 = new ProduceItem();
   
   p1.setName("Item 6");
   p1.setQuantity(6);
   p1.setExpiration("Oct 24, 2019");
      
   ProduceItem p2 = new ProduceItem();
   
   p2.setName("Item 7");
   p2.setQuantity(7);
   p2.setExpiration("Oct 25, 2019");
   
   ProduceItem p3 = new ProduceItem();
   
   p3.setName("Item 8");
   p3.setQuantity(8);
   p3.setExpiration("Oct 26, 2019");
   
   ProduceItem p4 = new ProduceItem();
   
   p4.setName("Item 9");
   p4.setQuantity(9);
   p4.setExpiration("Oct 27, 2019");
   
   ProduceItem p5 = new ProduceItem();
   
   p5.setName("Item 10");
   p5.setQuantity(10);
   p5.setExpiration("Oct 28, 2019");
         
   
   // Task 1: Create a SLList slist1, slist2
   System.out.println("***** Task 1 *****");
   // t1.1 Create a SLList slist1 of 5 generic items,
   // using g1, .., g5 as data
   
   // ****** ADD YOUR CODE HERE ******
   SLList<GenericItem> slist1 = new SLList<GenericItem>();
   
   slist1.add(g1);
   slist1.add(g2);
   slist1.add(g3);
   slist1.add(g4);
   slist1.add(g5);
   
   // t1.2 Create a SLList slist2 of produce items
   SLList<ProduceItem> slist2 = new SLList<ProduceItem>();
   
   slist2.add(p1);
   slist2.add(p2);
   slist2.add(p3);
   slist2.add(p4);
   slist2.add(p5);
   
   
    // ****** ADD YOUR CODE HERE ******
   
   // t1.2 Display slist1, slist2 to the sreen  

   
   
   System.out.println("*** Task 1, part 2: printing the results ***");


	System.out.println(slist1);
  
   
	System.out.println(slist2);
    // ****** ADD YOUR CODE HERE ******
    
   // Task 2: Use the functions add and remove 
   // to manipulate slist1
   System.out.println("***** Task 2 *****");
  
   // t2.1 Remove two items from slist1 by applying
   // the remove method two times
   GenericItem r1 =  slist1.remove();
   GenericItem r2 = slist1.remove();
   // Name (and store) the items removed as r1, r2
 
     // ****** ADD YOUR CODE HERE ******
   
     System.out.println(slist1);
   // t2.2 Display the resulting list: slist1 
   
 
    // ****** ADD YOUR CODE HERE ******
   
   // t2.3 Add the two items r1, r2 to slist1 now
   slist1.add(r1);
   slist1.add(r2);
   // ****** ADD YOUR CODE HERE ******
   
   // t2.4 Display the resulting list: slist1
   System.out.println(slist1);
    // ****** ADD YOUR CODE HERE ******
    
   // Task 3: Use the functions push and pop to 
   // manipluate slist2
   
   
   System.out.println("***** Task 3 *****");
   
   // t3.1 Remove two items from slist2 by applying
   // the pop method two times
   ProduceItem r3 = slist2.pop();
   ProduceItem r4 = slist2.pop();
   // Name (and store) the items popped as r3, r4
   
    // ****** ADD YOUR CODE HERE ******
   
   // t3.2 Display the resulting list: slist2
   	System.out.println(slist2);
    // ****** ADD YOUR CODE HERE ******
   
   // t3.3 Push the two items r3, r4 to slist2 now
   slist2.push(r4);
   slist2.push(r3);
   
   // ****** ADD YOUR CODE HERE ******
   
   // t3.4 Display the resulting list: slist2
   System.out.println(slist2);
   // ****** ADD YOUR CODE HERE ******
   
  /*
  Queue<Integer> q = new SLList<Integer>();
  for (int i = 0; i < 100; i++) {
   q.add(i);
  }
  System.out.println(q);
  for (int i = 0; i < 50; i++) {
   q.remove();
  }
  System.out.println(q);
  for (int i = 100; i < 200; i++) {
   q.add(i);
  }
  System.out.println(q);
  for (int i = 0; i < 50; i++) {
   q.remove();
  }
  System.out.println(q);
  while (!q.isEmpty()) {
   q.remove();
  }
  System.out.println(q);
  */
 }
}
