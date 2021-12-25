/***** Homework 5 *****/
/* Last Name:  Rose
 * First Name:	Daniel
 * Section:     M001   (MOO1 / M004)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
public class HW05 {
    
  public static void main(String[] args) { 
    // ********************************************************************************
    // Load the zip code data  to myData (a doubly linked list of data pairs)
    // DO NOT MODIFY THE CODE IN THIS BLOCK
    // ********************************************************************************
        DLList<Pair<String,Integer>> myData = new DLList<Pair<String,Integer>>();
        String row;
         try {
            //Reading data from  CSV File 
            BufferedReader csvReader = new BufferedReader(new FileReader("Hash.csv"));            
            while ((row = csvReader.readLine()) != null) {
              Pair<String,Integer> item = new Pair<String,Integer>();
              String[] data = row.split(",");
              item.setX(data[0]);
              item.setY(Integer.valueOf(data[1]));  
              myData.add(item);
            }           
            csvReader.close();
         }
         catch(IOException e) {
            e.printStackTrace();
         } 
         System.out.println(myData.size() + " Zip code data has been loaded ");
    // ********************************************************************************
    //  Data are Loaded to myData
    // ********************************************************************************
  
    // **************************************************************************
    // Task 1: Verify your implementation of the dictionary operations
    // **************************************************************************     
         
    // a. Create a HTable h1 with table size 103 (a prime number) 
	
	
	HTable h1 = new HTable(103);
	
    // b. Insert the data from myData, one by one, to h1
	
	for (int i = 0; i < myData.size(); i++){
		Pair<String,Integer>  temp = myData.get(i);
		h1.insert(temp.getX(),temp.getY());
		
	}
	
    // c. Display the table size of h1 and noOfItems of h1 to the screen
	
	System.out.println("Table size: " + h1.getTableSize()+ " Nomber of items: " + h1.getNoOfItems());
    // d. Randomly select five distinct data from myData, say their keys are:
    //    k1, k2, k3, k4, k5
	Pair<String,Integer>  temp2 = myData.get(getRandomInt(0,1613));
	Pair<String,Integer>  temp3 = myData.get(getRandomInt(0,1613));
	Pair<String,Integer>  temp4 = myData.get(getRandomInt(0,1613));
	Pair<String,Integer>  temp5 = myData.get(getRandomInt(0,1613));
	Pair<String,Integer>  temp6 = myData.get(getRandomInt(0,1613));
	String k1 = temp2.getX();
	String k2 = temp3.getX();
	String k3 = temp4.getX();
	String k4 = temp5.getX();
	String k5 = temp6.getX();
	h1.delete(k1);
	h1.delete(k2);
	h1.delete(k3);
	h1.delete(k4);
	h1.delete(k5);
	System.out.println("Table size: " + h1.getTableSize()+ " Nomber of items: " + h1.getNoOfItems());
    //    delete the data with these keys from h1
    //    and then display the noOfItems of h1 to the screen 
         
    
         
         
    // **************************************************************************
    // Task 2: Load randomly chosen zip code data to a hash table and compute
    //         the maximum length among all the chains in the table 
    // **************************************************************************     
         
    // a. Create a HTable h2 with table size 311 (a prime number) 
	
	HTable h2 = new HTable(311);
	
    // b. Insert the 500 data, selectly randomly, from myData to h2
	
	for (int i = 0; i < 500; i++){
		Pair<String,Integer>  temp = myData.get(getRandomInt(0,1612));
		h2.insert(temp.getX(),temp.getY());
		
	}
	
    // c. Display the table size of h2 and noOfItems of h2 to the screen
	
	System.out.println("Table size: " + h2.getTableSize()+ " Nomber of items: " + h2.getNoOfItems());
	
    // d. Compute the maximum length among all the chains in h2 and call it d
    //    and display d to the screen      
     int d = h2.maxChainLength();
	System.out.println("Max Chain length of h2: " + d);
     
    // **************************************************************************
    // Task 3: Compare the performance of hashing using hash tables of
    //         different sizes     
    // **************************************************************************     
         
    // a. Create a HTable h3 with table size 257 (a prime number) 
    //    and Create a HTable h4 with table size 256 (= 2^8)       
	
		HTable h3 = new HTable(257);
		HTable h4 = new HTable(256);
	
    // b. Insert the data in myData, one by one, to h3
	
	for (int i = 0; i < myData.size(); i++){
		Pair<String,Integer>  temp = myData.get(i);
		h3.insert(temp.getX(),temp.getY());
		
	}
	
    // c. Insert the data in myData, one by one, to h4
	
	for (int i = 0; i < myData.size(); i++){
		Pair<String,Integer>  temp = myData.get(i);
		h4.insert(temp.getX(),temp.getY());
		
	}
	
    // d. Compute the maximum length among all the chains in h3, call it d3
    //    and display d3 to the screen   
	
	d = h3.maxChainLength();
	System.out.println("Max Chain length of h3: " + d);
	
    // e. Compute the maximum length among all the chains in h4, call it d4
    //    and display d4 to the screen   
    
    d = h4.maxChainLength();
	System.out.println("Max Chain length of h4: " + d);
         
         
         
    // **************************************************************************
    // Task 4: Retreive data from queries
    //              
    // **************************************************************************     
         
    // a. Divide myData into two lists myData1 (the first 800 data) and 
    //    myData2 (the remaining data) 
	
	 DLList<Pair<String,Integer>> myData1 = new DLList<Pair<String,Integer>>();
	 DLList<Pair<String,Integer>> myData2 = new DLList<Pair<String,Integer>>();
	 
	 for (int i = 0; i <= 800; i++){
		Pair<String,Integer> item = new Pair<String,Integer>();
        item.setX(myData.get(i).getX());
        item.setY(myData.get(i).getY());  
        myData1.add(item);
		 
	 }
	 
	  for (int i = 801; i < myData.size(); i++){
		Pair<String,Integer> item = new Pair<String,Integer>();
        item.setX(myData.get(i).getX());
        item.setY(myData.get(i).getY());  
        myData2.add(item);
		 
	 }
	
    //           
    // b. Create a HTable h5 by inserting all the data in myData1 to h5
	
	HTable h5 = new HTable(257);
	for (int i = 0; i < myData1.size(); i++){
		Pair<String,Integer>  temp = myData1.get(i);
		h5.insert(temp.getX(),temp.getY());
		
	}
	
	
	temp2 = myData1.get(getRandomInt(0,800));
	temp3 = myData1.get(getRandomInt(0,800));
	temp4 = myData1.get(getRandomInt(0,800));
	temp5 = myData1.get(getRandomInt(0,800));
	temp6 = myData1.get(getRandomInt(0,800));
	Pair<String,Integer> temp7 = myData2.get(getRandomInt(0,812));
	Pair<String,Integer> temp8 = myData2.get(getRandomInt(0,812));
	Pair<String,Integer> temp9 = myData2.get(getRandomInt(0,812));
	Pair<String,Integer> temp10 = myData2.get(getRandomInt(0,812));
	Pair<String,Integer> temp11 = myData2.get(getRandomInt(0,812));
	k1 = temp2.getX();
	k2 = temp3.getX();
	k3 = temp4.getX();
	k4 = temp5.getX();
	k5 = temp6.getX();
	String k6 = temp7.getX();
	String k7 = temp8.getX();
	String k8 = temp9.getX();
	String k9 = temp10.getX();
	String k10 = temp11.getX();
	
	
    // c. Randomly select 5 data from myData1, say their keys are:
    //    k1, k2, k3, k4, k5     
    // d. Randomly select 5 data from myData2, say their keys are:
    //    k6, k7, k8, k9, k10 
    // e. Apply the search function with the input k1, k2, .. , k10
    //    and display the results as a table to the screen.
    //    For example: a possible list may look like:
    //     
	
	System.out.println("-------------------------");
	System.out.println("key             value         ");
	System.out.println("-------------------------");
	if (h5.search(k1) == null)
		System.out.println(k1 + "    Not Found");
	else
		System.out.println(k1 + "  " + h5.search(k1));
	if (h5.search(k2) == null)
		System.out.println(k2 + "   Not Found");
	else
		System.out.println(k2 + "  " + h5.search(k2));
	if (h5.search(k3) == null)
		System.out.println(k3 + "   Not Found");
	else
		System.out.println(k3 + "  " + h5.search(k3));
	if (h5.search(k4) == null)
		System.out.println(k4 + "   Not Found");
	else
		System.out.println(k4 + "  " + h5.search(k4));
	if (h5.search(k5) == null)
		System.out.println(k5 + "   Not Found");
	else
		System.out.println(k5 + "  " + h5.search(k5));
	if (h5.search(k6) == null)
		System.out.println(k6 + "   Not Found");
	else
		System.out.println(k6 + "  " + h5.search(k6));
	if (h5.search(k7) == null)
		System.out.println(k7 + "   Not Found");
	else
		System.out.println(k7 + "  " + h5.search(k7));
	if (h5.search(k8) == null)
		System.out.println(k8 + "   Not Found");
	else
		System.out.println(k8 + "  " + h5.search(k8));
	if (h5.search(k9) == null)
		System.out.println(k9 + "   Not Found");
	else
		System.out.println(k9 + "  " + h5.search(k9));
	if (h5.search(k10) == null)
		System.out.println(k10 + "   Not Found");
	else
		System.out.println(k10 + "  " + h5.search(k10));
	
	
	
	
	
    //    -------------------------
    //    key                value
    //    ------------------------- 
    //    SHORTSVILLE         14548
    //    EDWARDS             13635
    //    HOLMES              12531
    //    EAST QUOGUE         11942
    //    CHESTERTOWN         12817
    //    HEMPSTEAD       Not found
    //    CANASERAGA      Not found
    //    MASSAPEQUA PARK Not found
    //    DELHI           Not found
    //    CAMBRIA HEIGHTS Not found
    //    ----------------------
    //
    //
    //
    //      
    //
    //
    //
    //
    //
    //    -----------------       
  } // end of main function
      
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s   
  // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt
  

// You may add any functions here to carry out the tasks above

  
  
  
} // end of HW05 class