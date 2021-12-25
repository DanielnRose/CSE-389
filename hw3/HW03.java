/**
 * Name:   Rose, Daniel	     // Format: Lastname, Firstname 
 * Section:  M001   // Enter either M001/M004 
 */
 
import java.util.concurrent.ThreadLocalRandom;
public class HW03 {
  
public enum Dir { // an enum class which represents the four directions
    UP, DOWN, LEFT, RIGHT 
  }

  
 public static void main(String[] args){
    task1();
    task2();
    task3();
  }
    
  // generate random integers with [r.s] (inclusive)
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
    // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomIndex

// UNLESS OTHERWISE STATED, IN THIS HOMEWORK, you are expected to 
// use the displayExcept method appropriately when displaying your puzzle
// display all IntStack objects as a stack in the order where the top of 
// the stack should be printed first, and so on ...
 
  // Task 1:
  // 1.1 complete the function generatePuzzle

  
  public static void generatePuzzle(GridWorld init, GridWorld aPuzzle, int k, IntStack moves, IntStack sol, int blank) {
 // follow the homework description to implement this function  
 IntStack rev = new IntStack(100);
 IntStack rev2 = new IntStack(100);
 for (int i = 0; i<k; i++){
	moves.push(getRandomInt(0,3));
	int t = moves.peek();
	int[] pos = aPuzzle.find(16);
	if (t == 0){
		if (pos[0] != 3){
			aPuzzle.setVal(aPuzzle.getVal(pos[0]+1, pos[1]), pos[0],pos[1]);
			aPuzzle.setVal(16, pos[0]+1, pos[1]);
			sol.push(1);
		}
	}
	else if (t==1){
		if (pos[0] > 0){
			aPuzzle.setVal(aPuzzle.getVal(pos[0]-1, pos[1]), pos[0],pos[1]);
			aPuzzle.setVal(16, pos[0]-1, pos[1]);
			sol.push(0);
		}
	
	}
	else if(t==2){
		if (pos[1] != 3){
			aPuzzle.setVal(aPuzzle.getVal(pos[0], pos[1]+1), pos[0],pos[1]);
			aPuzzle.setVal(16, pos[0], pos[1]+1);
			sol.push(3);
		}
		
	}
	else if(t==3){
		if (pos[1] > 0){
			aPuzzle.setVal(aPuzzle.getVal(pos[0], pos[1]-1), pos[0],pos[1]);
			aPuzzle.setVal(16, pos[0], pos[1]-1);
			sol.push(2);
		}
		
	}
		
 }
	aPuzzle.displayExcept(16);
	System.out.println("Moves");
	for(int t = 0; t<k; t++){
		rev.push(moves.pop());
	}
	for(int t = 0; t<k; t++){
		if (t != k-1){
		System.out.print(rev.pop()+ " , ");
		}
		else{
			System.out.println(rev.pop());
		}
	}
	/*System.out.println("Solution");
	for(int i = 0; i<k; i++){
		int m = sol.pop();
		rev2.push(m);
		if (i != k-1){
		System.out.print(m+ " , ");
		}
		else{
			System.out.println(m);
		}
	}
	for(int t =0; t<k; t++){
		sol.push(rev2.pop());
	}*/
  }
  
  // 1.2 Verify and assess the function generatePuzzle
  
  public static void task1 () { 
    System.out.println(" ************ Task 1 ************ ");
    // t1.   Test generatePuzzle
 // t1a.  create a GridWorld grid1a, where it represents the puzzle grid init in Figure 1 from
 //       our homework description
 GridWorld grid1a = new GridWorld();
 GridWorld aPuzzle = new GridWorld();
 
 IntStack moves = new IntStack(100);
 IntStack sol = new IntStack(100);
 
 // t1b.   use generatePuzzle and grid1a as the initial grid1a with k=30, generate a puzzle puzzle1a
 //       display puzzle1a, the moves and the sol stacks obtained. 
generatePuzzle(grid1a, aPuzzle , 30, moves, sol, 16);
 
 // t2.    Conduct an computational experiment
 // t2a.    For k=51, 100
 System.out.println();
 GridWorld aPuzzle2 = new GridWorld();
 generatePuzzle(grid1a, aPuzzle2 , 51, moves, sol, 16);
 
  System.out.println();
 IntStack rev = new IntStack(100);
 IntStack rev2 = new IntStack(100);
GridWorld aPuzzle3 = new GridWorld();
 IntStack[] solList = new IntStack[50];
 int r = 0;
 GridWorld aPuzzle0 = new GridWorld();
 /*for (int t = 0; t>50; t++){
	  IntStack sol2 = new IntStack(100);
	  generatePuzzle(grid1a, aPuzzle0 , (t+51), moves, sol2, 16);
	  solList[t] = sol;	 
 }
 for (int t = 0; t>50; t++){
	 if (solList[r].size() <= solList[t].size()){
		 r = t;
	 }
 }
 System.out.println(r);
 */
 generatePuzzle(grid1a, aPuzzle3 , 100, moves, sol, 16);
 System.out.println("Solution");
	for(int i = 0; i<100; i++){
		int m = sol.pop();
		rev2.push(m);
		if (i != 100-1){
		System.out.print(m+ " , ");
		}
		else{
			System.out.println(m);
		}
	}
	for(int t =0; t<100; t++){
		sol.push(rev2.pop());
	}
	
 System.out.println("The solution is the greatest at k = 100");
 
 //       use grid1a and the function generatePuzzle to create puzzles
 // t2b.   Compute, among the 50 puzzles created, the one where the no of elements in the sol, as
 //       a stack, is the maximum among all 50 puzzles
 // t2c.   display the initial grid, the puzzle, the moves and the sol for that case.
  }
  
 // Task 2:
 // 2.1 complete the function  extractSol and visualizeSol

 public static void extractSol(Dir[] moveSequence , IntStack sol){
	int m = 0;
	  // First, use the same definition from the Point class for the enum type Dir
	  // define it in this homework file HW03.java
	  // This function will translate a solution of the puzzle, sol, to an array
	  // of directions, moveSequence, to describe the solution 
	for(int i = 0; i < 4; i++){
		m =  sol.pop();
		if (m==0){
			moveSequence[i] = Dir.UP;
		}
		if (m==1){
			moveSequence[i] = Dir.DOWN;
		}
		if (m==2){
			moveSequence[i] = Dir.LEFT;
		}
		if (m==3){
			moveSequence[i] = Dir.RIGHT;
		}
	}
	System.out.print("[");
	for(int i = 0; i < 4; i++){
		if(i != 3){
		System.out.print(moveSequence[i] +", ");
		}
		else{
			System.out.println(moveSequence[i] +"]");
		}
	}
}
 
  
    public static void visualizeSol(IntStack sol, GridWorld pz, int blank, int k){
     // assuming sol is a solution for the fifteen puzzle pz, where blank is the integer
  // that represents the `blank` to the puzzle
        // this function will display the solution to screen stepwise.
        // for each step, it will display the current grid, and the next direction (type Dir)
        // the blank will move, and wait for the user to continue (or quit)
  // after all the steps are executed, the user can quit.
  // An example is given separately to show how to interact with the user. 
	int l = sol.size();
  for (int i = 0; i<l; i++){
	int t = sol.pop();
	int[] pos = pz.find(16);
	pz.displayExcept(16);
	if (t == 0){
		System.out.println("UP");
		if (pos[0] != 3){
			pz.setVal(pz.getVal(pos[0]+1, pos[1]), pos[0],pos[1]);
			pz.setVal(16, pos[0]+1, pos[1]);
		}
	}
	else if (t==1){
		System.out.println("DOWN");
		if (pos[0] > 0){
			pz.setVal(pz.getVal(pos[0]-1, pos[1]), pos[0],pos[1]);
			pz.setVal(16, pos[0]-1, pos[1]);
		}
	}
	else if(t==2){
		System.out.println("LEFT");
		if (pos[1] != 3){
			pz.setVal(pz.getVal(pos[0], pos[1]+1), pos[0],pos[1]);
			pz.setVal(16, pos[0], pos[1]+1);
		}
	}
	else if(t==3){
		System.out.println("RIGHT");
		if (pos[1] > 0){
			pz.setVal(pz.getVal(pos[0], pos[1]-1), pos[0],pos[1]);
			pz.setVal(16, pos[0], pos[1]-1);
		}
	}
	
		
 }
 	pz.displayExcept(16);
  
  
 }
 
 
   // 2.2 Verify and assess the functions extractSol and visualizeSol
   
   public static void task2 () {
     System.out.println(" ************ Task 2 ************ ");
     // t2. 
  
     // t2a: 
	 IntStack s1 = new IntStack(3);
	 IntStack s2 = new IntStack(3);
	 IntStack s3 = new IntStack(3);
	 s1.push(3);
	 s1.push(2);
	 s1.push(1);
	 s1.push(0);
	 
	 s2.push(1);
	 s2.push(2);
	 s2.push(3);
	 s2.push(0);
	 
	 s3.push(2);
	 s3.push(1);
	 s3.push(1);
	 s3.push(3);
     // create three InStacks
     // s1 = 0 <- top  s2 = 0 <- top    s3 = 3 <-top 
     //      1              3                1
     //      2              2                1
     //      3              1                2         
     // write code to display the directions arrrays obtained from extractSol
     // for s1, the moveSequence should be [UP, DOWN, LEFT, RIGHT] and your
     // test should display them in this format
		Dir[] Dir1 = new Dir[4];
		extractSol(Dir1, s1);
		extractSol(Dir1, s2);
		extractSol(Dir1, s3);
  
     // t2b: 
     // generate a number k in the range [30, 50] randomly, using the getRandomInt function.
	 int k = (getRandomInt(0,20)+30);
	 
     // use generatePuzzle with the k given to create a puzzle pz from init (init ref. to 
     // Figure 1 in HW) with the blank specified correctly
     // 
	GridWorld grid1a = new GridWorld();
	GridWorld aPuzzle = new GridWorld();
	 
	 IntStack moves = new IntStack(100);
	 IntStack sol = new IntStack(100);
	 generatePuzzle(grid1a, aPuzzle , k, moves, sol, 16);
	 visualizeSol(sol,  aPuzzle, 16, k);
 
	 
     // t2c: 
     // use visualizeSol to display the solution obtained in steps.
  }

  
   // Task 3: 
   // 3.1 complete the following function:manhattanD according to the specification stated
   // in the homework description. You may assume that the init and aPuzzle is consistent.
   // That is, both grid uses the same collection of distinct integers and use the same number
   // to represent a blank
   
   public static int manhattanD (GridWorld init, GridWorld aPuzzle, int blank){
		int distance = 0;
		for (int i = 1; i<16; i++){
			int[] initpos = init.find(i); 
			int[] pos = aPuzzle.find(i);
			distance = distance + Math.abs(initpos[0]-pos[0]) + Math.abs(initpos[1]-pos[1]);
		}
	   
	   
     return distance;
     // comment out the above line and write your code 
   }
   
   // 3.2 Verify and assess the function manhattanD
   
  public static void task3 () {
   System.out.println(" ************ Task 3 ************ ");
   // t3
   
   // t3a: use the generatePuzzle function to obtain init and aPuzzle
   //      compute and display the manhattan distance between init and aPuzzle
   GridWorld init = new GridWorld();
	GridWorld aPuzzle = new GridWorld();
	 
	 IntStack moves = new IntStack(100);
	 IntStack sol = new IntStack(100);
	 generatePuzzle(init, aPuzzle , 30, moves, sol, 16);
	int md = manhattanD(init, aPuzzle, 16);
	 System.out.println("Manhattan distance: " + md);
	 
	 
	 
	 GridWorld grid3a = new GridWorld();
	 grid3a.setVal(2,0,0);
	 grid3a.setVal(8,0,1);
	 grid3a.setVal(3,0,2);
	 grid3a.setVal(4,0,3);
	 grid3a.setVal(1,1,0);
	 grid3a.setVal(6,1,1);
	 grid3a.setVal(10,1,2);
	 grid3a.setVal(15,1,3);
	 grid3a.setVal(5,2,0);
	 grid3a.setVal(11,2,1);
	 grid3a.setVal(7,2,2);
	 grid3a.setVal(14,2,3);
	 grid3a.setVal(9,3,0);
	 grid3a.setVal(13,3,1);
	 grid3a.setVal(16,3,2);
	 grid3a.setVal(12,3,3);
	 md = manhattanD(init, grid3a, 16);
	 System.out.println("Manhattan distance of grid3a: " + md);
	 
	 
	 GridWorld grid3b = new GridWorld();
	 grid3b.setVal(9,0,0);
	 grid3b.setVal(5,0,1);
	 grid3b.setVal(3,0,2);
	 grid3b.setVal(2,0,3);
	 grid3b.setVal(10,1,0);
	 grid3b.setVal(1,1,1);
	 grid3b.setVal(7,1,2);
	 grid3b.setVal(11,1,3);
	 grid3b.setVal(15,2,0);
	 grid3b.setVal(6,2,1);
	 grid3b.setVal(12,2,2);
	 grid3b.setVal(14,2,3);
	 grid3b.setVal(4,3,0);
	 grid3b.setVal(13,3,1);
	 grid3b.setVal(16,3,2);
	 grid3b.setVal(8,3,3);
	 md = manhattanD(init, grid3b, 16);
	 System.out.println("Manhattan distance of grid3b: " + md);
	 
	 GridWorld grid3c = new GridWorld();
	 grid3c.setVal(2,0,0);
	 grid3c.setVal(8,0,1);
	 grid3c.setVal(3,0,2);
	 grid3c.setVal(16,0,3);
	 grid3c.setVal(1,1,0);
	 grid3c.setVal(5,1,1);
	 grid3c.setVal(7,1,2);
	 grid3c.setVal(10,1,3);
	 grid3c.setVal(14,2,0);
	 grid3c.setVal(15,2,1);
	 grid3c.setVal(6,2,2);
	 grid3c.setVal(4,2,3);
	 grid3c.setVal(9,3,0);
	 grid3c.setVal(12,3,1);
	 grid3c.setVal(13,3,2);
	 grid3c.setVal(11,3,3);
	 md = manhattanD(init, grid3c, 16);
	 System.out.println("Manhattan distance of grid3c: " + md);
	 
	 GridWorld grid3d = new GridWorld();
	 grid3d.setVal(13,0,0);
	 grid3d.setVal(16,0,1);
	 grid3d.setVal(1,0,2);
	 grid3d.setVal(12,0,3);
	 grid3d.setVal(2,1,0);
	 grid3d.setVal(8,1,1);
	 grid3d.setVal(4,1,2);
	 grid3d.setVal(3,1,3);
	 grid3d.setVal(7,2,0);
	 grid3d.setVal(6,2,1);
	 grid3d.setVal(14,2,2);
	 grid3d.setVal(10,2,3);
	 grid3d.setVal(9,3,0);
	 grid3d.setVal(11,3,1);
	 grid3d.setVal(5,3,2);
	 grid3d.setVal(15,3,3);
	 md = manhattanD(init, grid3d, 16);
	 System.out.println("Manhattan distance of grid3d: " + md);
	 
	 GridWorld grid3e = new GridWorld();
	 grid3e.setVal(5,0,0);
	 grid3e.setVal(1,0,1);
	 grid3e.setVal(2,0,2);
	 grid3e.setVal(3,0,3);
	 grid3e.setVal(6,1,0);
	 grid3e.setVal(7,1,1);
	 grid3e.setVal(4,1,2);
	 grid3e.setVal(8,1,3);
	 grid3e.setVal(16,2,0);
	 grid3e.setVal(15,2,1);
	 grid3e.setVal(10,2,2);
	 grid3e.setVal(13,2,3);
	 grid3e.setVal(9,3,0);
	 grid3e.setVal(14,3,1);
	 grid3e.setVal(12,3,2);
	 grid3e.setVal(11,3,3);
	 md = manhattanD(init, grid3e, 16);
	 System.out.println("Manhattan distance of grid3e: " + md);
   // t3b. create five GridWorld objects: grid3a, grid3b, grid3c, grid3d and grid3e (shown
   //      in a separate document task3eg).
   //      compute and display the manhattan distance between init and each of these grids
    
  }
}
