/**
 * Java Class from zybooks Chapter 10, section 1.
 */

public class ProduceItem extends GenericItem { // ProduceItem derived from GenericItem
   public void setExpiration(String newDate) {
      expirationDate = newDate;
   }

   public String getExpiration() {
      return expirationDate;
   }
  
// added for Lab 6
   public String toString() {
     // comment out the line below fill in your own code
     return (itemName + " " + itemQuantity + " " +expirationDate + " ");
   }
   
   private String expirationDate;

}