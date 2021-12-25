/***** Homework 6 *****/
/* Last Name:  Rose	
 * First Name:	Daniel
 * Section:     M001   (MOO1 / M004)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
public class HW06 {
    
  public static void main(String[] args) { 
    // ********************************************************************************
    // Load the zip code data  to myData (a doubly linked list of data pairs)
    // DO NOT MODIFY THE CODE IN THIS BLOCK
    // ********************************************************************************
        DLList<Pair<Integer,String>> 
          myData = new DLList<Pair<Integer,String>>();
        String row;
         try {
            //Reading data from  CSV File 
            BufferedReader csvReader = new BufferedReader(new FileReader("Hash.csv"));            
            while ((row = csvReader.readLine()) != null) {
              Pair<Integer,String> item = new Pair<Integer,String>();
              String[] data = row.split(",");
              item.setX(Integer.valueOf(data[1]));  
              item.setY(data[0]);
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
  
    // ********************************************************************************
    // Task 1: Verify your implementation of insert/treeSize/treeHeight operations
    // ********************************************************************************     
   
         
    // a. Create a BinSearchTree tree1 and initialize it to an empty tree
    // b. Randomly select 10 data item from myData and insert them to the tree1
    // c. After each insert operation, display the item inserted, treeSize and treeHeight 
    //    of tree2 in the form of a table 
         BinSearchTree tree1 = new BinSearchTree();
		 for (int i = 0; i<10; i++){
		 Pair<Integer,String> temp  = myData.get(getRandomInt(0,1613));
		 tree1.insert(temp);
		 System.out.println(temp.getX() + " " + temp.getY() + "    Tree Size: " + tree1.treeSize() + "    Tree Height: " + tree1.treeHeight());
		 }
		 

         
         
    // **************************************************************************
    // Task 2: Study the average height of a binary search tree built by 
    //         inserting the data randomly to an empty tree
    // **************************************************************************     
      System.out.println();    
     System.out.println("Task 2");
	  System.out.println();
    // a. Create a BinSearchTree tree2 and initialize it to an empty tree
	
	double avg = 0;
	
	BinSearchTree tree2 = new BinSearchTree();
    // b. Use the randPermute function to create a random permutation P
	int[] p = (RandEx.randPermute(1613));
	for (int i = 0; i < p.length; i++){
		tree2.insert(myData.get(p[i]));
		}
	avg = avg + tree2.treeHeight();
    // c. Insert the data item following the order in the random permutation P to 
    //    tree2
	System.out.println("Tree Size: " + tree2.treeSize() + "    Tree Height: " + tree2.treeHeight());
	
    // c. Compute the treeSize of tree2 and treeHieght of tree2
    // d. Repeat step a, step b and step c 50 times. Compute average treeHeight,
    //    using the values you collected in step c.
    // e. Display the average treeHeight to the screen     
	
	
	for (int y = 0; y<50; y++){
		BinSearchTree tree22 = new BinSearchTree();
    // b. Use the randPermute function to create a random permutation P
		p = (RandEx.randPermute(1613));
		for (int i = 0; i < p.length; i++){
			tree22.insert(myData.get(p[i]));
			}
		avg = avg + tree22.treeHeight();
	}
	avg = avg / 50;
	System.out.println("Average Tree Height: " + avg);
     

         
         
         
     
    // **************************************************************************
    // Task 3: Testing the delete operation
    //            
    // **************************************************************************     
         
    // a. Create a BinSearchTree tree3 and initialize it to an empty tree
	  System.out.println();    
     System.out.println("Task 3");
	  System.out.println();
	BinSearchTree tree3 = new BinSearchTree();
	
	
    // b. Insert the data in myData, one by one, to tree3
	 for (int i = 0; i<1613; i++){
		 tree3.insert(myData.get(i));
		  }
	System.out.println("Tree Size: " + tree3.treeSize() + "    Tree Height: " + tree3.treeHeight());
    // c. Display the size and height of tree3
    // d. Randomly select 100 data items from myData
    // e. Delete the 100 data items selected from tree3
    // f. Display the size and height of tree3 
	
	int[] nums = new int[100];
	int tempi;
	for(int i = 0; i < 100; i++){
	
	tempi  = getRandomInt(1,1612);
	/*
	boolean tp = inList(num, tempi);
	while(tp == true){
		tempi  = getRandomInt(1,1613);
		tp = inList(nums, tempi);
	}
	nums[i] = tempi;
	*/
	
	Pair<Integer,String> temp = myData.get(tempi);
	BTNode<Pair<Integer,String>> bt = tree3.search(temp);
	try{
	tree3.delete(tree3.getRoot(), bt);
	}
	catch(NullPointerException e) {
		
	}
	//System.out.println("Tree Size: " + tree3.treeSize() + "    Tree Height: " + tree3.treeHeight());
    
	}
	System.out.println("Tree Size: " + tree3.treeSize() + "    Tree Height: " + tree3.treeHeight());
    

    // **************************************************************************
    // Task 4: Retreive data from queries
    //              
    // **************************************************************************     
         
    // a. Divide myData into two lists myData1 (the first 800 data) and 
    //    myData2 (the remaining data) 
    //           
	
	
	 System.out.println();    
     System.out.println("Task 4");
	 System.out.println();
	
	
	 DLList<Pair<Integer,String>> myData1 = new DLList<Pair<Integer,String>>();
	 DLList<Pair<Integer,String>> myData2 = new DLList<Pair<Integer,String>>();
	 
	 for (int i = 0; i <= 800; i++){
		Pair<Integer,String> item = new Pair<Integer,String>();
        item.setX(myData.get(i).getX());
        item.setY(myData.get(i).getY());  
        myData1.add(item);
		 
	 }
	 
	  for (int i = 801; i < myData.size(); i++){
		Pair<Integer,String> item = new Pair<Integer,String>();
        item.setX(myData.get(i).getX());
        item.setY(myData.get(i).getY());  
        myData2.add(item);
		 
	 }
	
	
	
	
	
    // b. Create a BinSearchTree tree4 by inserting all the data in myData1 to tree4
	
	BinSearchTree tree4 = new BinSearchTree();
	 for (int i = 0; i<800; i++){
		 tree4.insert(myData1.get(i));
		  }
	
    // c. Randomly select 5 data from myData1, say their keys are:
    //    k1, k2, k3, k4, k5     
	

    // d. Randomly select 5 data from myData2, say their keys are:
    //    k6, k7, k8, k9, k10 
	
		
	Pair<Integer,String> k1 = myData.get(getRandomInt(0,800));
	Pair<Integer,String> k2 = myData.get(getRandomInt(0,800));
	Pair<Integer,String> k3 = myData.get(getRandomInt(0,800));
	Pair<Integer,String> k4 = myData.get(getRandomInt(0,800));
	Pair<Integer,String> k5 = myData.get(getRandomInt(0,800));
	Pair<Integer,String> k6 = myData2.get(getRandomInt(0,812));
	Pair<Integer,String> k7 = myData2.get(getRandomInt(0,812));
	Pair<Integer,String> k8 = myData2.get(getRandomInt(0,812));
	Pair<Integer,String> k9 = myData2.get(getRandomInt(0,812));
	Pair<Integer,String> k10 = myData2.get(getRandomInt(0,812));
	
		System.out.println("---------------------");
	System.out.println("Key     Value         ");
	System.out.println("---------------------");
	if (tree4.search(k1) == null)
		System.out.println(k1.getX() + "   Not Found");
	else
		System.out.println(k1.getX() + "  " + k1.getY());
	if (tree4.search(k2) == null)
		System.out.println(k2.getX() + "  Not Found");
	else
		System.out.println(k2.getX() + "  " + k2.getY());
	if (tree4.search(k3) == null)
		System.out.println(k3.getX() + "  Not Found");
	else
		System.out.println(k3.getX() + "  " + k3.getY());
	if (tree4.search(k4) == null)
		System.out.println(k4.getX() + "  Not Found");
	else
		System.out.println(k4.getX() + "  " + k4.getY());
	if (tree4.search(k5) == null)
		System.out.println(k5.getX() + "  Not Found");
	else
		System.out.println(k5.getX() + "  " + k5.getY());
	if (tree4.search(k6) == null)
		System.out.println(k6.getX() + "  Not Found");
	else
		System.out.println(k6.getX() + "  " + k6.getY());
	if (tree4.search(k7) == null)
		System.out.println(k7.getX() + "  Not Found");
	else
		System.out.println(k7.getX() + "  " + k7.getY());
	if (tree4.search(k8) == null)
		System.out.println(k8.getX() + "  Not Found");
	else
		System.out.println(k8.getX() + "  " + k8.getY());
	if (tree4.search(k9) == null)
		System.out.println(k9.getX() + "  Not Found");
	else
		System.out.println(k9.getX() + "  " + k9.getY());
	if (tree4.search(k10) == null)
		System.out.println(k10.getX() + "  Not Found");
	else
		System.out.println(k10.getX() + "  " + k10.getY());
	System.out.println("---------------------");
	
    // e. Apply the search function with the input k1, k2, .. , k10
    //    and display the results as a table to the screen.
    //    For example: a possible list may look like:
    //     
    //    -------------------------
    //    key                 value
    //    ------------------------- 
    //    .....               .....
    //    .....               .....
    //    .....               .....
    //    .....               .....
    //    .....               ..... 
    //    .....           Not found
    //    .....           Not found
    //    .....           Not found
    //    .....           Not found
    //    .....           Not found
    //    -------------------------
              
         
    // **************************************************************************
    // Task 5: Range queries
    //              
    // **************************************************************************     
    
	
	System.out.println();    
    System.out.println("Task 5");
	System.out.println();
	
    // a. Create a BinSearchTree tree5 and initialize it to an empty tree
	
		BinSearchTree tree5 = new BinSearchTree();
	
    // b. Insert the data in myData, one by one, to tree5
	
	for (int i = 0; i<1613; i++){
		 Pair<Integer,String> temp  = myData.get(i);
		 tree5.insert(temp);
		 }
	
	
    // c. Display the size and height of tree5
         
		 System.out.println("Tree Size: " + tree5.treeSize() + "    Tree Height: " + tree5.treeHeight());
		 
		 
    // d. use the function rangeSearch (you developed in this file) to display the 
    //    following results from range search    
        System.out.println("---------------------");
        rangeSearch(tree5,1,10000);
		System.out.println("---------------------");
        rangeSearch(tree5,14801,14810);
		System.out.println("---------------------");
        rangeSearch(tree5,11000,11050);
         
  } // end of main function
      
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s   
  // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt
  
  // rangeSearch will take aTree, a and b (0 <= a <= b) as input
  // print the zipcode data (as tuples) where the zipcode is in the range [a,b]
  // For example,  rangeSearch(tree5,10000,10500) should print
  //
  // (10001, NEW YORK)
  // (10301, STATEN ISLAND)
  // (10451, BRONX)
  //  
  // to the screen
  
  public static void rangeSearch(BinSearchTree aTree,Integer a, Integer b){
    // requires 0 <= a <= b
	
	
	for(int i = a; i<b; i++){
		Pair<Integer,String> t = new Pair<Integer,String>();
		t.setX(i);
		BTNode<Pair<Integer,String>> result = aTree.search(t);
		if (result != null){
			System.out.println("(" + result.getData().getX() + ", " + result.getData().getY() + ")");
		}
		
	}
	
	
	
    
  }
  
  public boolean inList(int[] list, int num){
	  for (int i = 0; i < list.length; i++){
		  if (list[i] == num){
			  return true;
		  }
		  
	  }
	  return false;
  }

// You may add any functions here to carry out the tasks above

  
  
  
} // end of HW06 class