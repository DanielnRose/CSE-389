/**
 * For Lab07, 
 * Name: Rose, Daniel       // Format: Lastname, Firstname 
 * Section: M001     // Enter either M001/M004 
 */
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
public class Lab07 {

  public static void main(String[] args) { 
    // In this lab, we will practice the following: 
    // (1). manipulating an doubly linked list
    // (2). use the ChainedHashTable class to process data
    
    // Task 1. Create data as a pairs of Integers
    // and create a ChainHashTable for processing data

    // a. Generate each data randomly as a Pair
    //    Type Pair(x,y)
    //     where 
    //           x is of type Integer (the key
    //           y is also of type Integer (the value)
    //     We set the number of pairs to be inserted as BIGN
    //    BIGN = total number of data to be inserted 
    //      i : the index we will use in loops 
    //    key : we use it to stope key values created           
    
    // Initialize data
    // *********** fill in your code here
    Integer begin = new Integer(1000);
    Integer i = new Integer(0);
    Integer key = new Integer(1);
    
    ChainedHashTable<Pair<Integer,Integer>> htable = new ChainedHashTable<Pair<Integer,Integer>>();
    
    DLList<Pair<Integer,Integer>> toRemove = new DLList<Pair<Integer,Integer>>();
    
    // b. Create a ChainedHashTable htable
    
     // *********** fill in your code here
    
    
    
    
    // c. Prepare a DLList of Pairs to store the data generated for 
    //    our experiment
    
    // ********** fill in your code here
    
    
    
    
    // d. show the features the hashtable
      
    // *********** fill in your code here
  
    System.out.println("Size: "+htable.size());
    System.out.println("Dimension: "+htable.d);
    System.out.println("Underlying array Length: "+htable.t.length);
    System.out.println("Multiplier: "+htable.z);
    
    // 2. Add data to the the hashtable    
    // a. Insert BIGN randomly generated pairs to the hash table
  
    // *********** fill in your code here
    
    while(i<begin){
      Integer val = new Integer(getRandomInt(1,10000));
      Pair<Integer,Integer> p = new Pair<Integer,Integer>(key,val);
      htable.add(p);
      toRemove.add(p);
      key = key + 1;
      i++;
    }
    
    
    
    // b. show the features the hashtable
    
    // *********** fill in your code here
    
    System.out.println("Size: "+htable.size());
    System.out.println("Dimension: "+htable.d);
    System.out.println("Underlying array Length: "+htable.t.length);
    System.out.println("Multiplier: "+htable.z);
    
    // 3. Using the DLList to test the hash table
    // a. Pick an data item from DLList and check if they can be found in DLList 
   
    // *********** fill in your code here
   
    Pair<Integer,Integer> t = toRemove.get(getRandomInt(0,999));
    Pair<Integer,Integer> res = htable.find(t);
    
    if(res == null){
      System.out.println("Not found");
    }else{
      System.out.println("Found");
    }
    
    
    
  
      
   // b. Remove the data items one by one until the hash table is empty 
   // (optional practice, not part of the lab submission)
    
    // *********** fill in your code here
    /*
    Pair<Integer,Integer> r = new Pair<Integer,Integer>();
    int o = 0;
    while(toRemove.size()>0){
      r = htable.remove(toRemove.get(o));
      System.out.println("The data value removed is "+r.getX()+"," +r.getY());
      o++;
    }
    
    */
    
  }
  
  
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
// needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt

  
}
