/****************** Lab 8   *****************/
/***** Practice using Homework 4 Part 2 *****/
/* Last Name: Rose 
 * First Name: Daniel
 * Section: M001       (MOO1 / M004)
 */
import java.util.Iterator;  // for the displayOrder function
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
public class HW4P2 {  
  // DO NOT CHANGE THE FOLLOWING THREE QUANTITY
  static final int NUM_PRODUCE = 4;
  static final int NUM_GENERIC = 4;
  static final int MAX_ORDER_SIZE = 5;
  
  public static void main(String[] args) { 
    // Load the produce items of SU-coffee
    ProduceItem [] pItem = loadProduceItem ();
    // load the generic items of SU-coffee
    GenericItem [] gItem = loadGenericItem ();
  

    // generate the total items, from the range [1,MAX_ORDER_SIZE], to be added  
    int noOfItems = getRandomInt(1,MAX_ORDER_SIZE);
      
    Pair<SLList<ProduceItem>,SLList<GenericItem>> 
      order1 = genAnOrder(noOfItems, gItem, pItem), 
      order2 = genAnOrder(noOfItems, gItem, pItem), 
      order3 = genAnOrder(noOfItems, gItem, pItem); 
      
    // System.out.println(order1);
    displayOrder(order1);
    displayOrder(order2);
    displayOrder(order3);
     
    System.out.println("Order Total for order1: " + orderTotal(order1));  
    System.out.println("Order Total for order2: " + orderTotal(order2));  
    System.out.println("Order Total for order3: " + orderTotal(order3));  
  }
  
  // function displayOrder
  // Let anOrder be (p, g), this function will display the list of produce items p, which 
  // is part of our order followed by the list of generic items q, which is also part of 
  // the order
  public static void displayOrder (Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder) 
  { 
    System.out.println("***** Display an order *****");
    // Add your code here
    SLList<ProduceItem> p = anOrder.getX();
    SLList<GenericItem> g = anOrder.getY();
    
    System.out.println("Produce Items: ");
    if(p.size() == 0){
      System.out.println("[]");
    }else{
      Iterator<ProduceItem> piter = p.iterator();
      while(piter.hasNext()){
        System.out.print(piter.next());
      }
    }
    
    System.out.println("Generic Items: ");
    if(g.size() == 0){
      System.out.println("[]");
    }else{
      Iterator<GenericItem> giter = g.iterator();
      while(giter.hasNext()){
        System.out.print(giter.next());
      }
    }
    
   
    System.out.println("*** An order is displayed ***\n");
  }
    
  // function orderTotal
  // Let anOrder be (p, g), this function will compute the total (price) for the produce items 
  // in p (i.e. tota(p), followed by the total (price) list for the generic items in g 
  // (i.e. totalg), and return the sum of them. That is, totalp + totalg 
     
  public static double orderTotal (Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder) 
  { // comment out the return statement below and add your code 
    //return 0.0;
    SLList<ProduceItem> p = new SLList<ProduceItem>();
    SLList<GenericItem> g = new SLList<GenericItem>();
    
    p = anOrder.getX();
    g = anOrder.getY();
    
    double total = 0.0;
  
    if(p.size() !=0){
      Iterator<ProduceItem> piter = p.iterator();
      while(piter.hasNext()){
        total += piter.next().getPrice();
      }
    }
    if(g.size() !=0){
      Iterator<GenericItem> giter = g.iterator();
      while(giter.hasNext()){
        total += giter.next().getPrice();
      }
    }
    
    return total;
  }
  
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
// needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt
  
    
  public static ProduceItem [] loadProduceItem () { 
    ProduceItem [] pItem = new ProduceItem[4];
    
    pItem [0] = new ProduceItem ();
    pItem [0].setId(1);
    pItem [0].setName("Sumatra");
    pItem [0].setQuantity(1);
    pItem [0].setExpiration("Dec 31, 2019");
    pItem [0].setPrice(10.0);
      
    pItem [1] = new ProduceItem ();
    pItem [1].setId(2);
    pItem [1].setName("Sumatra Capsules");
    pItem [1].setQuantity(12);
    pItem [1].setExpiration("Mar 31, 2020");
    pItem [1].setPrice(7.99);
    
    pItem [2] = new ProduceItem ();
    pItem [2].setId(3);
    pItem [2].setName("Kenya");
    pItem [2].setQuantity(1);
    pItem [2].setExpiration("Dec 15, 2019");
    pItem [2].setPrice(11.99);
    
    pItem [3] = new ProduceItem ();
    pItem [3].setId(4);
    pItem [3].setName("Kenya Capsules");
    pItem [3].setQuantity(18);
    pItem [3].setExpiration("April 1, 2020");
    pItem [3].setPrice(15.0);
    
    return pItem;
    
  }
   
    
  public static GenericItem [] loadGenericItem () { 
    GenericItem [] gItem = new GenericItem[4];;
    
    gItem [0] = new GenericItem ();
    gItem [0].setId(5);
    gItem [0].setName("Keurig K145");
    gItem [0].setQuantity(1);
    gItem [0].setPrice(89.99);
      
    gItem [1] = new GenericItem ();
    gItem [1].setId(6);
    gItem [1].setName("Mr. Coffee 12 cup");
    gItem [1].setQuantity(1);
    gItem [1].setPrice(26.99);
    
    gItem [2] = new GenericItem ();
    gItem [2].setId(7);
    gItem [2].setName("Melitta filter: 100 count");
    gItem [2].setQuantity(100);
    gItem [2].setPrice(1.49);
    
    gItem [3] = new GenericItem ();
    gItem [3].setId(8);
    gItem [3].setName("Melitta filter: 500 count");
    gItem [3].setQuantity(500);
    gItem [3].setPrice(4.99);
    
    return gItem;
  }
      
   
    /* function genAnOrder
     * A function that generate an order ordr =(p,g) of size orderSize 
     * where p is a list of produce items generated randomly and 
     * q is a list of generic items generated randomly
     * Assumes 1 <= orderSize <= MAX_ORDER_SIZE
    */
    public static  Pair<SLList<ProduceItem>,SLList<GenericItem>> genAnOrder 
      (int orderSize, 
       GenericItem [] gItem, 
       ProduceItem [] pItem
      )       
    { // comment out the return statement below and add your own code 
      int c = -1;
      SLList<ProduceItem> p = new SLList<ProduceItem>();
      SLList<GenericItem> g = new SLList<GenericItem>();
      for(int i=0; i<orderSize; ++i){
        c = getRandomInt(1,8);
        if(c<=4){
          p.add(pItem[c-1]);
        }else if(c<=8){
          g.add(gItem[c-5]);
        }else{
          System.out.println("Error");
        }
      }
      Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder = new Pair<SLList<ProduceItem>,SLList<GenericItem>>(p,g);
      return anOrder;
    } 
    
}
