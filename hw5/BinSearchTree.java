/***** Homework 6: BinSearchTree *****/

/* Last Name: Rose 
 * First Name: Daniel
 * Section: M001       (MOO1 / M004)
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
   
    
  public static int compare (Pair<Integer,String> Pair1, Pair<Integer,String> Pair2) 
  {
    // comment out the return statement below and put your code here
    return Pair1.getX().compareTo(Pair2.getX());
  }
    
  public long treeSize(){
    return BTNode.treeSize(this.root);
  }
      
  public long treeHeight(){
    return BTNode.treeHeight(this.root);
  }
  
  public boolean insert(Pair<Integer,String> aPair){  
    BTNode<Pair<Integer,String>> current = root;
    BTNode<Pair<Integer,String>> aNode = null;
    boolean inserted = false; 

    if(root == null){
      aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
      root = aNode;
    }else{
      while (current!=null && !inserted){
        int ans = compare(aPair, current.getData());
        if(ans<0){
          if(current.getLeft() == null){
            aNode = new BTNode<Pair<Integer,String>>(aPair, null, null);
            current.setLeft(aNode);
            inserted = true;
          }else{
            current = current.getLeft();
          }
        }
        if(ans>0){
          if(current.getLeft() == null){
            aNode = new BTNode<Pair<Integer,String>>(aPair, null, null);
            current.setRight(aNode);
            inserted = true;
          }else{
            current = current.getRight();
          }
        }
        if(ans==0){
          return false;
        }
      }
    }
    return inserted; // if the insert operation did insert aPair to the tree.
                  // otherwise, it will return false.
    // comment out the return statement and put your code here
  }
  
    
  public  BTNode<Pair<Integer,String>> 
    delete
    (BTNode<Pair<Integer,String>> aNode)
  {
    return null; // delete the data item with the given key
                 // if the delete operation fails, it will return null
    // comment out the return statement and put your code here
   
    }
    
  
  public BTNode<Pair<Integer,String>> search(Pair<Integer,String> aPair){
    BTNode<Pair<Integer,String>> current = root;
    BTNode<Pair<Integer,String>> aNode = null;
    Boolean found = false;
    if(root == null){
      found = false;
    }else{
      while(current != null && !found){
        int ans = compare(aPair,current.getData());
        if(ans<0){
          current = current.getLeft();
        }
        if(ans>0){
          current = current.getRight();
        }
        if(ans == 0){
          found = true;
        }
      }
    }
    return current; // return the value that correspond to the given key
                 // if search fails, it will return the string null    
    // comment out the return statement and put your code here
   
  }
    
   public void inorderPrint(){
    root.inorderPrint(); // return the value that correspond to the given key
                 // if search fails, it will return the string null        
  }

  public void rangeSearch (Integer a, Integer b){ // requires 0 <= a <= b
    // print all the data items (key, value) where a <= key <= b 
    // eg. for a BinSearchTree tree storing the data set Hash.csv, 
    // tree.rangeSearch(10000,10301) will print
    // (10001,NEW YORK)
    // (10301,STATEN ISLAND)
     
     // add your code here
     
   }
   
  public static void main(String[] args) { 
    /* ADD YOUR TEST CODE HERE */
  }      
}
