import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {

         Scanner reader = new Scanner(System.in);
	    int sticks = (int)(Math.random()*10) + 21;
	    System.out.println("There are " + sticks + " sticks.");
	    System.out.println("Select 1 to go first, select 2 to go second.");
	    boolean turn; //true means player turn, false means computer turn
	    if(reader.nextInt() == 1)
	        turn = true;
	    else
	        turn = false;
	        
	    //game stops when we get to 0 sticks
	    //so the game must continue to run as logn as the number of sticks is > 0  
	    while(sticks > 0){
	        if(turn)
	           sticks = playerMove(sticks, reader);
	        else
	           sticks = computerMove(sticks);
	       System.out.println("There are " + sticks + " sticks left.");
	        if(sticks == 0 && turn)  //&& means "AND"
	            System.out.println("Player wins!");
	        if(sticks == 0 && !turn) //! means false
	            System.out.println("Computer wins.");
	        turn = !turn;
	    }
	}
        
        //in line 8, *10 is number of possibilities, 21 is the minimum value
    
        //Math.random() gives a random double from 0 to 1, exclusive (real numbers strictly between 0-1 not including 0 and 1)
        //because we are looking for a range of 10 integers, we multiply Math.random()*10
        //Math.random()*10 gives us a random doublle from 0 to 10, exclusive (we cannot include 10 directly)
        //Then we will cast an int, which will cut off the decimal part (9.809 becomes integer 9) (0.274 becomes 0)
        //Casting to an int will then give us a 0-9, INCLUSIVE (because we want random integer from 21-30)
        //Then simply add 21 (to give us random integer from 21-30)
        //we want a random integer 21-30, inclusive
	
	    //this method must return an integer value.  
	    //this method has two input parameters: sticks and reader
	public static int playerMove(int sticks, Scanner reader){
	    System.out.println("Select how many sticks to take.");
	    int take = reader.nextInt();
	    if(take < 1)
	        take = 1;
	    if(take > 3)
	        take = 3;
	    else if(take > sticks)
	        take = sticks;
	    System.out.println("You took " + take + " sticks.");
	    return sticks - take;
	}
	
	public static int computerMove(int sticks){
        int take;
        if(sticks % 4 != 0) //if number of sticks is not a multiple of 4
           take = sticks % 4; 
        else  //number of sticks is a multiple of 4
           take = (int)(Math.random()*3) + 1;   
        System.out.println("The computer took " + take + " sticks.");
        return sticks - take;
	}
}