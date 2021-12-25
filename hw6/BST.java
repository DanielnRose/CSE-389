/***** Homework 6: BinSearchTree *****/

/* Last Name:  
 * First Name:
 * Section:        (MOO1 / M004)
 */

import java.util.*;
public class BinSearchTree {
  
  private BTNode<Pair<Integer,String>> root;
    
  public BinSearchTree() { 
    root = null;
  }
  
  public BinSearchTree(BTNode<Pair<Integer,String>> aNode){
     this.root = aNode; 
  }
  
  public BinSearchTree(Pair<Integer,String> aPair) { 
    this.root = new BTNode<Pair<Integer,String>>(aPair,null, null);
  }
   

//**************************************************************************
// Discussions for the lab session: compare function
//**************************************************************************
  
  public static int compare (Pair<Integer,String> Pair1, Pair<Integer,String> Pair2) 
  {
    return Pair1.getX().compareTo(Pair2.getX());
  }
    
  public long treeSize(){
    return BTNode.treeSize(this.root);
  }
      
  public long treeHeight(){
    return BTNode.treeHeight(this.root);
  }

//**************************************************************************
// Discussions for the lab session: insert function
//**************************************************************************
 
  
  public boolean insert(Pair<Integer,String> aPair){    
    // return false; // if the insert operation did insert aPair to the tree.
                  // otherwise, it will return false.
    BTNode<Pair<Integer,String>>
      current = root;
    
    BTNode<Pair<Integer,String>> 
      aNode = null;
    
    boolean inserted =false;
    
    if (root == null) {
      aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
        root = aNode;
    }
    else {
      while ((current != null) && !inserted) 
      { 
        int ans = compare(aPair, (current.getData()));
        if (ans < 0) {
          if (current.getLeft() == null) {
            aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
            current.setLeft(aNode);
            inserted = true;
          }
          else 
            current = current.getLeft();
        }
        
        if (ans > 0) {
          if (current.getRight() == null) {
            aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
            current.setRight(aNode);
            inserted = true;
          }
          else
            current = current.getRight();
        }
        
        if (ans == 0) {
          inserted = false;
          break; // leave the while loop
        }
      }
    }
    return (inserted);
  }

  
//**************************************************************************
// did not discuss in the lab session: delete function
// hints given below 
//**************************************************************************
 
// a helper function for the delete operation  
 private BTNode<Pair<Integer,String>> findReplacement
   (BTNode<Pair<Integer,String>> aNode) {
   while (aNode.getLeft() != null) aNode = aNode.getLeft();
   return aNode;
 }
  
    
  public  BTNode<Pair<Integer,String>> delete(BTNode<Pair<Integer,String>> root, Node<Pair<Integer,String>> aNode)
  {
    // return null; // delete the data item with the given key
                 // if the delete operation fails, it will return null
    
    // if the tree is null (empty), return null     
    if (root == null) return null; 
    else { // tree is not null
      
     //  Set a reference p at the root
    //  BTNode<Pair<Integer,String>> p = root;
   
    // find out which direction (left or right) to continue
      int ans = compare(aNode.getData(), (p.getData()));
      if (ans < 0) {  // apply recursion to the left subtree
       // fill in your code here
      }
      else if (ans > 0) { // apply recursion to the right subtree 
        
      }
      else if (p.getLeft() == null || p.getRight()== null)
      { // node to be deleted is found and   
        // it has 1 child only
        
      } else 
      {  // the node to be deleted is found and 
         // it has 2 children
         // may need to use the helper function findReplacement here 
               
      }
        // return the reference to the tree after deletion is done
        return p;
      
    }
  }


//**************************************************************************
// Discussions for the lab session: search function
//**************************************************************************
 
  
  public BTNode<Pair<Integer,String>> search(Pair<Integer,String> aPair){
    // return null; // return the value that correspond to the given key
                 // if search fails, it will return the string null    
     BTNode<Pair<Integer,String>>
      current = root;
    
    BTNode<Pair<Integer,String>> 
      aNode = null;
    
    boolean found =false;
    
    if (root == null) {
      found =false;
    }
    else {
      while ((current != null) && !found) 
      { 
        int ans = compare(aPair, (current.getData()));
        if (ans < 0) { 
            current = current.getLeft();
        }
        
        if (ans > 0) {         
            current = current.getRight();
        }
        
        if (ans == 0) {
          found = true;
        }
      }
    }
    return current;
  }

  
//**************************************************************************
// did not discuss in the lab session: rangeSearch function
// hints given below
//**************************************************************************
 
   
   public void rangeSearch (Integer a, Integer b){ // requires 0 <= a <= b
    // print all the data items (key, value) where a <= key <= b 
    // eg. for a BinSearchTree tree storing the data set Hash.csv, 
    // tree.rangeSearch(10000,10301) will print
    // (10001,NEW YORK)
    // (10301,STATEN ISLAND)
     
     // Step 1: extract an inorder listing (say, sortedLst) of 
     // the nodes in the tree
     
     BTNode<Pair<Integer,String>> sortedLst = root.inorder( );
     
     
     // Start the iteration at the beginning of the list
     BTNode<Pair<Integer,String>> itrA = sortedLst;
     
     // iterate through the list obtained and print the segment 
     // of nodes, if any, with their keys in the range [a,b]
       
     // Add your code here
     
   }
  
    
    public void inorderPrint(){
    root.inorderPrint(); // return the value that correspond to the given key
                 // if search fails, it will return the string null        
  }

    
//**************************************************************************
// Discussions for the lab session: may try out the implementation such as
// those list below, if time permits
//**************************************************************************
 
    
  public static void main(String[] args) { 
   
    // Create a tree tree1   
    Pair<Integer,String> Pair1 = new Pair<Integer,String> (10011,"NYC1");
    Pair<Integer,String> Pair2 = new Pair<Integer,String> (10012,"NYC2");
    Pair<Integer,String> Pair3 = new Pair<Integer,String> (10013,"NYC3");
    Pair<Integer,String> Pair4 = new Pair<Integer,String> (10004,"NYC4");
    Pair<Integer,String> Pair5 = new Pair<Integer,String> (10005,"NYC5");
    Pair<Integer,String> Pair6 = new Pair<Integer,String> (10006,"NYC6");
 
    BinSearchTree tree1 = new BinSearchTree();
 
    // Test insert   
    
    tree1.insert(Pair1);
    tree1.insert(Pair2);
    tree1.insert(Pair3);
    tree1.insert(Pair4);
    tree1.insert(Pair5);
    tree1.insert(Pair6);
    
    System.out.println(tree1.treeSize());
    System.out.println(tree1.treeHeight());
    tree1.inorderPrint();
    
    // test search and see if the node can be found   
    
    System.out.println(tree1.search(Pair1));
    System.out.println(tree1.search(Pair2));
    System.out.println(tree1.search(Pair3));
    System.out.println(tree1.search(Pair4));
    System.out.println(tree1.search(Pair5));
    System.out.println(tree1.search(Pair6));
   
     /* YOU MAY ADD YOUR OWN TEST CODE HERE */
    
  }
  
 
  
}
