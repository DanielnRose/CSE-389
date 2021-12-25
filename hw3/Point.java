/**
Rose Daniel       // Format: Lastname, Firstname 
 M001    // Enter either M001/M004 
 */
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import java.lang.Math;
public class Point {

// You may like to read  
// https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
// to check how enum types are being declared and used in Java
  
public enum Dir { // an enum class which represents the four directions
    UP, DOWN, LEFT, RIGHT 
  }
  
// data
  private int x;
  private int y;
  
  // constructors
  public Point() { 
    x = 0;
    y = 0;
  }
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }  

  // getters
  public int getX() { return x;}
  public int getY() { return y;}
  
  // setters 
  public void setX(int x){ this.x = x;}
  public void setY(int y){ this.y = y;} 
  
  // toString
  public String toString(){
    // Comment out the line below and add your code
    return null;
  }
  // move 
  public void move(Dir d){
    // Add your code here
	switch (d){
			case LEFT:  
				x =  x-1;
				break;
			case RIGHT:  
				x =  x+1;
				break;
			case UP:  
				y =  y+1;
				break;
			case DOWN:  
				y =  y-1;
				break;
		
	}
  }
    
  // sameValue 
  public static boolean sameValue(Point ptA, Point ptB){
    // Comment out the line below and add your code
    return false;
  }
  
  // generate random integers with [r.s] (inclusive)
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
    // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomIndex
  
  // test code for Point class
  public static void main(String[] args) {
    testp1();
    testp2();
  }   
  
  // testp1
  // test the move function
  public static void testp1(){
    // 1a. create an array of four points, say, Sample1
	
	Point[] Sample1 = new Point[4];
	
    // 1b. insert four points randomly generated, x and y of each point
	
	for (int i = 0; i < 4; i++){
		Sample1[i] = new Point(getRandomInt(0,1000), getRandomInt(0,1000));
		System.out.println("(" + Sample1[i].getX() +  " ,"  + Sample1[i].getY()+")");
	}
    // are within the range [0,1000]
    // 1c. display the array of points
    // 1d display the results each time the moves is applied:
    // ie. move all the point to the left
	System.out.println("------------------");
	for (int i = 0; i < 4; i++){
		Sample1[i].move(Dir.LEFT);
	System.out.println("(" + Sample1[i].getX() +  " ,"  + Sample1[i].getY()+")");
	}
	System.out.println("------------------");
    //     display the points
    //     move all the point to the up
	for (int i = 0; i < 4; i++){
		Sample1[i].move(Dir.UP);
	System.out.println("(" + Sample1[i].getX() +  " ,"  + Sample1[i].getY()+")");
		
	}
	System.out.println("------------------");
    //     display the points
    //     move all the point to the right
	for (int i = 0; i < 4; i++){
		Sample1[i].move(Dir.RIGHT);
	System.out.println("(" + Sample1[i].getX() +  " ,"  + Sample1[i].getY()+")");
	}
    //     display the points
    //     move all the point to the down
    //     display the points
	System.out.println("------------------");
	for (int i = 0; i < 4; i++){
		Sample1[i].move(Dir.DOWN);
	System.out.println("(" + Sample1[i].getX() +  " ,"  + Sample1[i].getY()+")");
	}
     // ADD your code here
  }
  public static void testp2(){ 
    // create a point: init = (0,0)
	Point point = new Point(0,0);

    // create an array of 1000 randomly generated directions, say, Dir1 
	Dir[] Dir1 = new Dir[1000];
	for(int i = 0; i <1000; i++){
		int d = getRandomInt(1,4);
		if (d ==1){
			Dir1[i] = Dir.UP;
		}
		if (d == 2){
			Dir1[i] = Dir.DOWN;
		}
		if (d == 3){
			Dir1[i] = Dir.LEFT;
		}
		if (d == 4){
			Dir1[i] = Dir.RIGHT;
		}	
	}
	
	for (int i = 0; i< 1000; i++){
		point.move(Dir1[i]);
	}
	System.out.println("------------------");
	//System.out.println("(" + point.getX() + "," + point.getY() + ")");
    // Compute the position of init after moving init according
	
	double distance =  Math.sqrt((point.getX() * point.getX()) + (point.getY()* point.getY()));
    // to the directions specified in Dir1
    // Present the intermediate results in the form of a table as shown:
    
    // init = (0,0)
    // Moves executed         Resulting positon  Distance from (0,0) 
	Point point2 = new Point(0,0);
	for (int i = 0; i< 100; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
    // Dir[0] to Dir[99]      
	System.out.println("Dir[0] to Dir[100] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
    // Dir[100] to Dir[199]
	for (int i = 100; i< 200; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[100] to Dir[200] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 200; i< 300; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[200] to Dir[300] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 300; i< 400; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[300] to Dir[400] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 400; i< 500; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[400] to Dir[500] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 500; i< 600; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[500] to Dir[600] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 600; i< 700; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[600] to Dir[700] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 700; i< 800; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[100] to Dir[800] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 800; i< 900; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[100] to Dir[900] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	for (int i = 900; i< 1000; i++){
		point2.move(Dir1[i]);
	}
	distance =  Math.sqrt((point2.getX() * point2.getX()) + (point2.getY()* point2.getY()));
	System.out.println("Dir[100] to Dir[1000] " + "(" + point2.getX() + "," + point2.getY() + ") Distance:" + distance);
	
    // ...                     ...                ...
    // ...                     ...                ...
    // ..............................................
    // Dir[900] to Dir[999]    ...                ...
  
    // Add your code here
	
	System.out.println("init = (0,0)");
	System.out.println(distance);
	System.out.println("Moves executed 1000, Resulting position " + "(" + point.getX() + "," + point.getY() + ") " + distance + " from (0.0)");
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
  }
  

    }
  