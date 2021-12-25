/***** Homework 4 Phase 3 *****/
/* Last Name:  
 * First Name:
 * Section:        (MOO1 / M004) 
 */
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
import java.util.*;
public class HW04P3 {
  
  // DO NOT CHANGE THE FOLLOWING THREE QUANTITY
  static final int NUM_PRODUCE = 4;
  static final int NUM_GENERIC = 4;
  static final int MAX_ORDER_SIZE = 5;
    
  public static void main(String[] args) { 
 
    // Load the produce items of SU-coffee
    ProduceItem [] pItem = loadProduceItem ();
    // load the generic items of SU-coffee
    GenericItem [] gItem = loadGenericItem ();
  
    // Phase 3 
    // Note: you may need to use the functions from phase 2 in each of the steps 
    // below.
    
    // 1. Create a qOrder, and DLList of orders and initialize it to an empty list.
    
    // Add your code here
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> qOrder = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
   
    
    // 2. Use the genAnOrder function (From Phase 2) to generate 50 orders,
    //    The number of items in an order is between 1 to MAX_ORDER_SIZE 
    //    (randomly generated). Insert (enqueue) them to the qOrder.
    for(int i = 0; i<50; i++){
		Pair<SLList<ProduceItem>,SLList<GenericItem>> order1 = genAnOrder(getRandomInt(1,MAX_ORDER_SIZE), gItem, pItem);
		qOrder.add(order1);
	
	
	}
    // Add your code here
    
    // 3. Prepare the variables to use computeStatistics and  
    //    apply the computeStatistics function to retreive the statistics data
    //    from qOrder
    
    // Add your code here
	Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
	Pair<SLList<ProduceItem>,SLList<GenericItem>>  minOrder = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
	 
    
    // 4. Display the following statistics data to the screen:
     double[] stats = computeStatistics(qOrder, maxOrder, minOrder);
		
		
	int maxOrderI = 0;
    int minOrderI = 0;
	for (int i = 0; i < 50; i++){
      if ((int)orderTotal(qOrder.get(i)) == (int)stats[0]){
        maxOrderI = i;
      }
      if ((int)orderTotal(qOrder.get(i)) == (int)stats[1]){
        minOrderI = i;
      }
    }
	
		
	//System.out.println(stats[0] + " " + stats[1] + " " + stats[2]);
    System.out.println("The maximum order is at position " + maxOrderI + " and totals $" + stats[0]);
	System.out.println("The minimum order is at position " + minOrderI + " and totals $" + stats[1]);
    System.out.println("Average Order Price: " + stats[2]);
	
    // 4.1. The order in the queue where the total is the maximum, and,  
    //      the total of that order (maxTotal).    
    
    // 4.2. The order in the queue where the total is the minimum. and,
    //      the total of that order (minTotal).
       
    // 4.3. The mean (average) of order totals among all orders in the queue qOrder.
    
    
    // Add your code here
    
    // 5. Prepare and initialize the parameters and 
    //    apply the enforcePriority function to divid the qOrder into three queues: 
    //    
    
    // Add your code here
    
    
    // 6. For each of the queues, say q1, q2 and q3 (classified by category)
    //    display the statistics data (as specified in 4.1, 4.2 and 4.3) to the screen:
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q1 = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q2 = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q3 = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
	
	enforcePriority(qOrder, q1, q2, q3);
	
	
	stats = computeStatistics(q1, maxOrder, minOrder);
	System.out.println("----------------------------------");
	System.out.println("Q1 Stats:");
    maxOrderI = 0;
    minOrderI = 0;
	for ( int i = 0; i < q1.size(); i++){
      if (orderTotal(q1.get(i)) == stats[0]){
        maxOrderI = i;
      }
      if ( orderTotal(q1.get(i)) == stats[1]){
        minOrderI = i;
      }
    }
    
    System.out.println("The maximum order is at position " + maxOrderI + " and totals $" + stats[0]);
	System.out.println("The minimum order is at position " + minOrderI + " and totals $" + stats[1]);
    System.out.println("Average Order Price: " + stats[2]);
	
  
    stats = computeStatistics(q2, maxOrder, minOrder);
	System.out.println("----------------------------------");
	System.out.println("Q2 Stats:");
    maxOrderI = 0;
    minOrderI = 0;
	for ( int t = 0; t < q2.size();t++){
      if (orderTotal(q2.get(t)) == stats[0]){
        maxOrderI = t;
      }
      if ( orderTotal(q2.get(t)) == stats[1]){
        minOrderI = t;
      }
    }
    
    System.out.println("The maximum order is at position " + maxOrderI + " and totals $" + stats[0]);
	System.out.println("The minimum order is at position " + minOrderI + " and totals $" + stats[1]);
    System.out.println("Average Order Price: " + stats[2]);
 

stats = computeStatistics(q3, maxOrder, minOrder);
	System.out.println("----------------------------------");
	System.out.println("q3 Stats:");
    maxOrderI = 0;
    minOrderI = 0;
	for ( int t = 0; t < q3.size();t++){
      if (orderTotal(q3.get(t)) == stats[0]){
        maxOrderI = t;
      }
      if ( orderTotal(q3.get(t)) == stats[1]){
        minOrderI = t;
      }
    }
    
    System.out.println("The maximum order is at position " + maxOrderI + " and totals $" + stats[0]);
	System.out.println("The minimum order is at position " + minOrderI + " and totals $" + stats[1]);
    System.out.println("Average Order Price: " + stats[2]);






 
  }
  

// ***********************************************************************
// Phase 3: put the function computeStatistics in the space provided below
  
  public static double[] computeStatistics(DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> qOrder, Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder, Pair<SLList<ProduceItem>,SLList<GenericItem>> minOrder)
	{
		double total = 0;
		double[] s = new double[3];
		double min = 9999;
		double max = 0;
		for (int v = 0; v <qOrder.size(); v++){
			if (orderTotal(qOrder.get(v)) > max){
				s[0] = orderTotal(qOrder.get(v));
				max = orderTotal(qOrder.get(v));
				maxOrder = qOrder.get(v);
				
			if (orderTotal(qOrder.get(v)) < min){
				s[1]  = orderTotal(qOrder.get(v));
				min = orderTotal(qOrder.get(v));
				minOrder = qOrder.get(v);
				}
			}
		total = total + orderTotal(qOrder.get(v));
		}	

		
		double avg = total / qOrder.size();
		s[2] = avg;
		return s;
	}
	
  
  
// End of function computeStatistics *************************************
  
  
// ***********************************************************************
// Phase 3: put the function enforcePriority in the space provided below  
  
  public static void enforcePriority(DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> qOrder, DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q1, DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q2, DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q3){

	  for (int i =0; i<50; i++){
		  //q1
		  if (qOrder.get(i).getX().size() != 0 && qOrder.get(i).getY().size() == 0){
			  q1.add(qOrder.get(i));
		  }
		  //q2
		  if (qOrder.get(i).getX().size() != 0 && qOrder.get(i).getY().size() != 0){
			  q2.add(qOrder.get(i));
			  
		  }
		  //q3
		  if (qOrder.get(i).getX().size() == 0 && qOrder.get(i).getY().size() != 0){
			q3.add(qOrder.get(i));
		}
	  
	  
	}
  
  }
  
 
// End of function enforcePriority ***************************************
  
  
// ***********************************************************************
// Put the functions you have developed from Phase 2 in the space below.
  
  public static void displayOrder (Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder) { 
		System.out.println("***** Display an order *****");
		System.out.println(anOrder.getX());
		System.out.println(anOrder.getY());
		System.out.println("*** An order is displayed ***\n");
  }
    public static double orderTotal (Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder) 
  { // comment out the return statement below and add your code 
  
	SLList<ProduceItem> tempp = new SLList<ProduceItem>();
    SLList<GenericItem> tempg = new SLList<GenericItem>();
	tempp = anOrder.getX();
	tempg = anOrder.getY();
	
	SLList<ProduceItem> tempp2 = new SLList<ProduceItem>();
    SLList<GenericItem> tempg2 = new SLList<GenericItem>();
	
	double total = 0.0;
	for (int i = 0; i<tempp.size(); i++){
		ProduceItem t = new ProduceItem();
		t = tempp.pop();
		tempp2.push(t);
		total = total + (t.getPrice());
	}
	for (int i = 0; i<tempg.size(); i++){
		GenericItem t2 = new GenericItem();
		t2 = tempg.pop();
		tempg2.push(t2);
		total = total + (t2.getPrice());
	}
	for (int i = 0; i<tempp2.size(); i++){
		ProduceItem t = new ProduceItem();
		t = tempp2.pop();
		tempp.push(t);
		
	}
	for (int i = 0; i<tempg2.size(); i++){
		GenericItem t2 = new GenericItem();
		t2 = tempg2.pop();
		tempg.push(t2);
	}
  
    return total;
   
  }
  public static  Pair<SLList<ProduceItem>,SLList<GenericItem>> genAnOrder (int orderSize, GenericItem [] gItem, ProduceItem [] pItem)       { 
	// comment out the return statement below and add your own code 
	  SLList<GenericItem> gen = new  SLList<GenericItem>();
	  SLList<ProduceItem> pro= new  SLList<ProduceItem>();
	  Pair<SLList<ProduceItem>,SLList<GenericItem>> order = new Pair<SLList<ProduceItem>,SLList<GenericItem>>(pro,gen);
	  for (int i = 0; i<orderSize; i++){
		  int t = getRandomInt(1,2);
		  int s = getRandomInt(0,3);
		  if (t == 1){
			  gen.add(gItem[s]);
		  }else{
			  pro.add(pItem[s]);
			  
		  }
	  }
	  
	  return order;
	  
	  
    }
  
// End of functions from Phase 2
// ***********************************************************************
    
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
      
   
  
}
