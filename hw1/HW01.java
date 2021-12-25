/**
 * Name:        // Format: Lastname, Firstname 
 * Section:     // Enter either M001/M004 
 */
import java.util.concurrent.ThreadLocalRandom; // required for getRandomInt
public class HW01 {
  
  public static void main(String[] args) { 
  testtask(1);
  testtask(2);
  testtask(3);
  testtask(4);
  testtask(5);
  }
  
  public static void testtask(int i){
  System.out.println("Testing Task "+i+"\n");
  switch (i) {
            case 1:  task1();
                     break;
            case 2:  task2();
                     break;
            case 3:  task3();
                     break;
            case 4:  task4();
                     break;
            case 5:  task5();
                     break;           
            default: System.out.println("Invalid task number");
                     break;   
  } // end switch
  }
  public static void task1() {
  // print a table of the recursively defined sequence Leo
  System.out.println("n     leo(n)");
  System.out.println("-------------");
  int x = 0;
  while (x < 10){
	if (x<6){
  System.out.println(x + "       " + leo(x));
	}
	else{
		System.out.println(x + "      " + leo(x));
	}
  ++x;
  // Write code to print the required leo numbers in the form of
  // a table (see the homework description) in the space below.
  }
  }
  public static void task2() {
    // testing the function count 
    // Show the results of the tests below:
    char[] chararray = {'s', 'y', 'r', 'a', 'c', 'u', 's', 'e'};
	System.out.println(count('a',chararray));
    // test 2.1: count 'a' ['s', 'y', 'r', 'a', 'c', 'u', 's', 'e']
    
    // test 2.2: count 'a' ['A',' ', 'O', 'R', 'A', 'N', 'G', 'E']
	char[] chararray2 = {'A',' ', 'O', 'R', 'A', 'N', 'G', 'E'};
	System.out.println(count('a',chararray2));
    // test 2.3: count 'a' empty array
	char[] chararray3 = {};
	System.out.println(count('a',chararray3));
  }
  public static void task3() {
    // test permute(p,a)
    // Show the results of the tests below:
    // test 3.1: 
    int[] p = {0,4,3,2,1}; 
	int[] a = {10,9,8,7,6};
	permute(p,a,5);
    // test 3.2: p = [1,4,2,0,3,5] ; a = [7,6,10,8,5,9]
	int[] p2 = {1,4,2,0,3,5}; 
	int[] a2 = {7,6,10,8,5,9};
	permute(p2,a2,6);
    // test 3.3: p = [9,8,7,6,5,4,3,2,1,0] ; a = [0,2,4,6,8,10,12,14,16,18]
	int[] p3 = {9,8,7,6,5,4,3,2,1,0}; 
	int[] a3 = {0,2,4,6,8,10,12,14,16,18};
	permute(p3,a3,10);    
  }
  public static void task4() {
    // print the results of leftShift (r, a) 
    // test 4.1: r = 5,  a = [1,2,3,4,5,6]
	char[] a = {1,2,3,4,5,6};
	shift(a, 5);
    // test 4.2: r = -3, a = [1,2,3,4,5,6]
	char[] a2 = {1,2,3,4,5,6};
	shift(a2, -3);
    // test 4.3: r = 3,  a = [1,2,3,4,5,6] 
	char[] a3 = {1,2,3,4,5,6};
	shift(a3, 3);	
  }
  public static void task5() {
    // print the results of shuffle (a, l)
    // where
    // test 5.1: a = [1,2,3,4,5] l=5
  int[] ai1 = {1,2,3,4,5};
	shuffle(ai1, 5);
    // test 5.2: a = [1,2,3,4,5,6,7,8,9,10] l=10
	int[] ai2 = {1,2,3,4,5,6,7,8,9,10};
	shuffle(ai2, 10);
    // test 5.3: a = [1,3,5,7,9,2,4,6,8,10],l=10 
	int[] ai3 = {1,3,5,7,9,2,4,6,8,10};
	shuffle(ai3, 10);
  }
  // function(s) for task 1
  public static int leo(int n) {
    if(n == 0 || n == 1){
	  return 1;
	} 
	else {
	return leo(n-1)+(leo(n-2)/2)+1;
	}
  }
  // function(s) for task 2
  public static int count(char c, char[] a) {
	  int occur = 0;
	  c = Character.toLowerCase(c);
	  for (int i = 0; i < a.length; ++i){
		  a[i] = Character.toLowerCase(a[i]);
		  if (a[i] == c){
			  ++occur;
		  }
		  
	  }
	  
    // comment out the following line and then add your own code
    return occur;   
  }
  
  // function(s) for task 3
  
  public static void permute(int[] p, int[] A, int len) {
    // add your own code for the function
	int[] R = new int[len];
	for (int j =0; j<len; j++){
		R[j] = A[p[j]];
	}
	for (int i = 0; i < len; ++i){
	System.out.print(R[i]);
	}
	System.out.println();
  }
  
  // function(s) for task 4
  
  public static void shift(char [] c, int k){
  // add your code for this function
  int[] c2 = new int[c.length];
	if (k>0){
		for (int n = 0; n < c.length; ++n){
			if ((n+k) < c.length){ 
				c2[n+k] = c[n];
			}
			else{
				c2[n+k-c.length] = c[n];  
			}
		}
	}
	else{
		for (int n = 0; n < c.length; ++n){
			if ((n+k) >= 0){
				c2[n+k] = c[n];
			}
			else{
				c2[c.length+(n+k)] = c[n];
			}
		}
		
	} 
	for (int n = 0; n < c2.length; ++n){
		 System.out.print(c2[n]);
	}
	System.out.println();
  }
  
  public static void shuffle (int[] a, int len) {
	  // add your code for this function
	  int[] sa = new int[len];
	  int[] use = new int[len];
	  for (int h = 0; h < use.length; ++h){
		  use[h] = -1;
	  }
	  
	  int i = 0;
	  while (i < len){
		  int r = getRandomInt(0, len-1);
		  if (rin(r,use)){
			sa[i] = a[r];
			use[i] = r;
			i++;
		  }
			
	  }
		for (int n = 0; n < sa.length; n++){
			System.out.print(sa[n]);
		}
		System.out.println();
	  }
 
  // I added a search function for int because it was the easiest way to see if r has been used in shuffle
  // When it returns false r is in the function and it will need to find a new r value
  public static boolean rin(int r, int[] use){
	  for (int u = 0; u < use.length; ++u){
		  if (r == use[u]){
			  return false;
		  }
	  }
	return true;  
  }
  
  
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
  // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomIndex
}
