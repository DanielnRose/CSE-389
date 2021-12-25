/**
 * Name:    Daniel Rose    // Format: Lastname, Firstname 
 * Section:   M001  // Enter either M001/M004 
 */

// A stack of type Point; 
// Stack size is the fixed constant STACK_SIZE
// Stack size will not be changed once the size is initialized 
public class PtStack {
  
  // constant 
  static final int STACK_SIZE = 10;

  // data
  private Point [] data; // a stack of points
  private int noOfItems; // no of points in the stack
  
  // constructors  
  public PtStack() { 
    noOfItems = 0;
    data = new Point[STACK_SIZE];
  }
  
  // this constructor should create this stack
  // to be of size s if s > 0
  // otherwise, it will create an empty stack
  public PtStack(int s) { 
  // Add your code here
  } 
   
  // this constructor should create a separate copy
  // of aStack to this stack
  public PtStack(PtStack aStack){
   // Add your code here
	for (int i = 0; i< STACK_SIZE; i++){
	   data[i] = aStack.data[i];
	   
	}
   }
  

  // getter function
  
  // return the noOfItems
  public int getNoOfItems () {
    // Comment out the line below and add your code
    return noOfItems;
  }
  
  // Basic stack operations
  
  // Push aPt to this stack if it is not full
  // otherwise, do nothing and print a message
  // to indicate that the stack is full
  public void push(Point aPt) {
	  if (noOfItems == STACK_SIZE){
		  System.out.println("Stack is full");
	  }
	  else{
		  data[noOfItems] = aPt;
			  noOfItems = noOfItems + 1;
	  }
    // Add your code here
    } 
  
  // Pop this stack if it is not empty
  // otherwise, do nothing and print a message
  // to indicate that the stack is empty
  public Point pop(){
	  if (noOfItems >= 0){
		    noOfItems = noOfItems - 1;
			return data[noOfItems];
		}
	  else{
		 // Point n = new Point(0,0);
			return null;
	  }
  }
  
  // test if this stack is empty
  public boolean isEmpty() {
    // Comment out the line below and add your code 
    return true;
  }
  
  // test if this stack is full
  public boolean isFull () {
   // Comment out the line below and add your code 
    return true;
  }
  
  // display this stack to the screen
  public void display () {
    // Add your code here
  }
  
  // reverse the element of this stack 
  public void reverse () {
   // Add your code here 
  }
    
  public static void main(String[] args) {
    // Create two array of points for the test cases 
	Point[] pts1 = new Point[10];
	for (int i = 0; i<10; i++){
		pts1[i] = new Point(i,i);
	}
    // pts1: [(0,0), ... , (9,9)]
    // pts2: [(0,1),(1,2),(2,3),(3,4),(4,5)]
    Point[] pts2 = new Point[5];
	for (int i = 0; i<5; i++){
		pts2[i] = new Point(i,i+1);
	}

	//print the arrays
	System.out.println("pts1    pts2");
	for (int i = 0; i<10; i++){
		if (i<5){
		System.out.println("(" + pts1[i].getX() +  ","  + pts1[i].getY()+")  " + "(" + pts2[i].getX() +  ","  + pts2[i].getY()+")");
		}
		else{
		System.out.println("(" + pts1[i].getX() +  ","  + pts1[i].getY()+")  ");
		}
	}
	
	System.out.println("--------------");
    // test 1: default constructor and display functions    
    // 1a. Create an empty stack: stackA, via the default constructor
	PtStack stackA = new PtStack();
	
    // 1b. push the points from pts1 to stackA, starting from (0,0)
	for (int i = 0; i < STACK_SIZE; i++){
	stackA.push(pts1[i]);
	}
    // to (9,9), following the order of the array pts1
    // 1c. Display the stack: stackA neatly to the screen
    // such as: 
	System.out.println("stackA");
	for (int i = 0; i<STACK_SIZE; i++){
		Point tp = stackA.pop();
		System.out.println("(" + tp.getX() +  ","  + tp.getY()+")  ");
	}
    //
    //     (9,9)
    //      ...
    //     (0,0)
    
    // Add your code for test 1 here
    
    // test 2: other constructors 
    // 2a. create an empty stack, stackB, of default size (ie. 10)
	PtStack stackB = new PtStack();
	
    // 2b. push the points from pts2 to stackB, starting from (0,1)
		for (int i = 0; i < 5; i++){
	stackB.push(pts2[i]);
	}
	
    //  (4,5), following the order of the array pts2
    // 2c. Display the stack: stackB, neatly (see example in 1c) to the screen
	System.out.println();
	System.out.println("stackB");
	for (int i = 0; i<5; i++){
		Point tp = stackB.pop();
		System.out.println("(" + tp.getX() +  ","  + tp.getY()+")  ");
	}
	
    // 2d. use the `copy' constructor to create a separate copy of stackB  
    // call it, stackC
	
	PtStack stackC = new PtStack(stackB);
	
    // 2e. push the points from pts1 to stackC, starting from (0,0)
    // (9,9), following the order of the array pts2
    // 2f. Display the stack: stackC, (see example in 1c)) neatly to the screen
    
    // Add your code for test 2 here
    
    // test 3: push and pop
    
    // 3a. Create an empty stack, stackD of default size
    // 3b. push the points pts2 (from pts2[0] to its last point) to the stackD
    // 3c. push the points pts1 (from pts1[0] to its last point) to the stackD
    // 3d  Display the stack: stackD, (see example in 1c)) neatly to the screen
    // 3e  pop stackD 15 times. Display the stack neatly each time after executing a pop
    
    
    // Add your code for test 3 here
    
    // test 4: reverse function
    
    // 4a. We will use the stackA and stackB after completing test 1 and test 2 in this test
    // 4b. execute the following code
    
    // stackA.reverse();
    // stackA.display();
    // stackB.reverse();
    // stackB.reverse();
    }

  }
