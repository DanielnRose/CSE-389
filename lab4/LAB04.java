/**
 * Name:        // Format: Lastname, Firstname 
 * Section:     // Enter either M001/M004 
 */
 import java.util.concurrent.ThreadLocalRandom;
public class LAB04 {


  
  public static void main(String[] args){
    test1();
    test2();
    test3();
  
  
  }
    
  // generate random integers with [r.s] (inclusive)
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
    // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomIndex

  // Test 1: test the default constructor and the two display functions
  // test 1.1: create a 4 X 4 grid using the default constructor and 
  // use the display function to print it to the screen
  // test 1.2: create a 4 X 4 grid using the default constructor and
  // use the displayObj function to print only those entries that is 1 
  // and the grid to the screen
  public static void test1 () {
    GridWorld grid1 = new GridWorld();
	grid1.display();
	GridWorld grid2 = new GridWorld(4,4);
	 int f = 1;
	grid2.displayObj(f);
	
  }
  

  // Test 2: test the parematerized constructor and the two display
  // functions
  // test 2.1: create a 10 X 10 grid using the parameterized constructor
  // and use the display function to print it to the screen
  // test 2.2: create a 10 X 10 grid using the parameterized constructor 
  // and use the displayObj function to print only those entries that is 
  // not 0 and the grid to the screen first
  public static void test2 () {
	GridWorld grid3 = new GridWorld(10,10);
	grid3.display();
	
	//display object should only display where it is what you input
	GridWorld grid4 = new GridWorld(10,10);
	grid4.displayObj(0);
	}

  
  // Test 3: Perform an experiment: create a randomly generated path over 
  // a grid and move an object along that path.
  // test 3.1:
  // create a 10 X 10 Grid. Use the getRandomInt function, generate: 
  // a. a position at row i and col j in the grid  0 <= i,j <10.
  // b. mark the positon by putting a 1 at that position and consider 1 
  // an object that will make moves in the grid.
  // c. use the getRandomInt function, generate a sequence of 20 moves.
  // each move is either an horizontal move or a vertical move in either 
  // directions.  
  // d. Move the object represented by 1 according to the sequence of moves
  // generated. If the move is invalid (e.g. go outside the grid), do nothing.
  // Display all the intermediate steps.
  
  public static void test3 () {
    GridWorld gr = new GridWorld(10,10);
	int i = getRandomInt(0,9);
	int j = getRandomInt(0,9);
	//System.out.println(j +" " + i);
	gr.setVal(1, i, j);
	gr.displayObj(1);
 
 int[] rand = new int[20];
 for (int t = 0; t < 20; t++){
	rand[t] = getRandomInt(0,3);
 }
 gr.setVal(0, 0, 0);
 for (int t = 0; t < 20; t++){
		 if(rand[t] == 0){
			if (i>0){
				i = i -1;
				gr.setVal(1, i, j);
			}
		 }
		 if(rand[t] == 1){
			if (i<9){
				i = i + 1;
				gr.setVal(1, i, j);
			}
		 }
		 if(rand[t] == 2){
			if (j>0){
				j = j -1;
				gr.setVal(1, i, j);
			}
		 }
		 if(rand[t] == 3){
			if (j<9){
				j = j + 1;
				gr.setVal(1, i, j);
			}
		 }
		 
	
	 gr.displayObj(1);
	 //System.out.println(rand[t]);
	// System.out.println(j+ " "+ i);
 }
// gr.displayObj(1);

  }
}






