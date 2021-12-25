/**
 * Name:    Rose Daniel    // Format: Lastname, Firstname 
 * Section:  M001   // Enter either M001/M004 
 */

// Instructions: follow the comments stated, fill in your code
// for each of the functions declared

public class GridWorld {
  // data
  
  //int [][] grid; // a "r by c" grid will all entries of type int
  int r; // no. of rows 
  int c; // no. of cols
  int row = 4;
  int col = 4;
  final static int ROW = 4;  // Default row size 
  final static int COL = 4;  // Default col size
  public int[][] grid; //new int[ROW][COL];

  // constructors 
  // 1. default constructor: construct a 4x4 Grid of int
  //    the entry at row i and col j is  4*i+j+1 
  public GridWorld() { 
  
  grid = new int [ROW][COL];
	for (int i = 0; i < ROW; i++){
		for (int j = 0; j< COL; j++){
			grid[i][j] = (4*i + 1 + j);
		}
	}

	
  }
  
  // 2. parameterized constructor: construct a row x col
  //    Grid of int where all the entries are 0
  public GridWorld(int roww, int coll){
	  col = coll;
	  row = roww;
	  grid = new int[roww][coll];
	  for (int i = 0; i < roww; i++){
		for (int j = 0; j< coll; j++){
			grid[i][j] = (coll*i + 1 + j);
		}
	}
  }

    
  // getters
  // 1. return the value at grid[r1][c1]
  
  public int getVal(int r1, int c1){
	  int t = grid[r1][c1];
	  return t;
  }
  
  // setters
  // 1. set the value at grid[r2,c2] to val
  public void setVal(int val, int i, int j) {
	  grid[i][j] = val;
  }
  
  public int[] find(int f){
	int[] pos = new int[2]; 
	for(int i = 0; i < row; i++){
		for (int j = 0; j< col; j++){
			if (grid[i][j] == f){
				pos[0] = i;
				pos[1] = j;
			}
		}  
	}
	return pos;
  }
  // display functions
  // 1. display
  // display the grid neatly to the screen with all
  // the values stored in the 2D array shown.
  // eg. If you display the object after you have
  // created it via the default constructor, it will
  // look like
  
  /* 
   * -----------------------------
     |    1 |    2 |    3 |    4 |
     -----------------------------
     |    5 |    6 |    7 |    8 |
     -----------------------------
     |    9 |   10 |   11 |   12 |
     -----------------------------
     |   13 |   14 |   15 |   16 |
     -----------------------------
  */
 
  
  // 2. displayObj a
   
  // display the grid neatly to the screen with ONLY
  // the value i stored in the 2D array shown.The others
  // will become blank(s).
  // eg. If you apply displayObj(1) the object after you have
  // created it via the default constructor, it will
  // look like
  
  /* 
   * -----------------------------
     |      |      |      |      |
     -----------------------------
     |      |      |      |      |
     -----------------------------
     |      |      |      |      |
     -----------------------------
     |      |      |      |      |
     -----------------------------
  */
  public void display(){
	  for (int t = 0; t < (col * 7); t++){
		  System.out.print("-");
	  }
	  System.out.println("-");
	  for (int i = 0; i < row; i++){
		System.out.print("|");
		for (int j = 0; j< col; j++){
			if (grid[i][i] == 0){
				System.out.print("      " +  "|");
			}
			else if (grid[i][j] < 10){
				System.out.print("     " + grid[i][j] + "|");
				}
			else if (grid[i][j] >= 100){
				System.out.print("   " + grid[i][j] + "|");
			}
			else{
				System.out.print("    " + grid[i][j] + "|");
			}
		}
		System.out.println();
		for (int t = 0; t < (col * 7); t++){
		  System.out.print("-");
	  }
	  System.out.println("-");
	}
System.out.println();
  }
	  
	  
 
  
  
  public void displayObj(int f) {    
   
	for (int t = 0; t < (col * 7); t++){
		  System.out.print("-");
	  }
	  System.out.println("-");
	  for (int i = 0; i < row; i++){
		System.out.print("|");
		for (int j = 0; j< col; j++){
			if (grid[i][i] == 0 && grid[i][j] == f){
				System.out.print("      " +  "|");
			}
			else if (grid[i][j] < 10 && grid[i][j] == f){
				System.out.print("     " + grid[i][j] + "|");
				}
			else if (grid[i][j] >= 10 && grid[i][j] == f){
				System.out.print("    " + grid[i][j] + "|");
			}
			else if (grid[i][j] >= 100 && grid[i][j] == f){
				System.out.print("   " + grid[i][j] + "|");
			}
			else{
				System.out.print("      |");
			}
		}
		System.out.println();
		for (int t = 0; t < (col * 7); t++){
		  System.out.print("-");
	  }
	  System.out.println("-");
		
	}
	
	System.out.println();
  
	
  }
 public void displayExcept(int f){
  for (int t = 0; t < (col * 7); t++){
		  System.out.print("-");
	  }
	  System.out.println("-");
	  for (int i = 0; i < row; i++){
		System.out.print("|");
		for (int j = 0; j< col; j++){
			if (grid[i][i] == 0 && grid[i][j] != f){
				System.out.print("      " +  "|");
			}
			else if (grid[i][j] < 10 && grid[i][j] != f){
				System.out.print("     " + grid[i][j] + "|");
				}
			else if (grid[i][j] >= 10 && grid[i][j] != f){
				System.out.print("    " + grid[i][j] + "|");
			}
			else if (grid[i][j] >= 100 && grid[i][j] != f){
				System.out.print("   " + grid[i][j] + "|");
			}
			else{
				System.out.print("      |");
			}
		}
		System.out.println();
		for (int t = 0; t < (col * 7); t++){
		  System.out.print("-");
	  }
	  System.out.println("-");
		
	}
	
	System.out.println();
  
	
  }
  
  
}