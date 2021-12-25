/**
 * Java Class from zybooks Ch.10, Section 1
 */

public class GenericItem {
   public void setName(String newName) {
      itemName = newName;
   }

   public void setQuantity(int newQty) {
      itemQuantity = newQty;
   }

   public void printItem() {
      System.out.println(itemName + " " + itemQuantity);
   }
   // added for Lab 6
   public String toString() {
   // comment out the line below fill in your own code
     return (itemName + " " + itemQuantity);
   }
   protected String itemName;
   protected int itemQuantity;
}

