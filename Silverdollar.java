import java.util.*;

public class Silverdollar {

	boolean[] strip;
	int gameCoin;
	int nextSpace;
	double totalSize;
	final int PLAYER1 = 1;
	final int PLAYER2 = 2;
	
	
	public Silverdollar(){
		//post: creates the game
		//(Math.random() * .25) + 3;
	}
	
	public boolean[] strip(int stripSize){
		//post: creates a random strip
		totalSize = (double)stripSize;
		strip = new boolean[stripSize];
		return strip;
	}
	
	public int coins(){
		//post: creates a number of coins
		Random newCoin = new Random();
		double value = totalSize * .25;
		gameCoin = (newCoin.nextInt((int)value)) + 3;
		return gameCoin;
	}
	
//method for moving a coin: input a coin
//and position to move to, as represented by indices
//check to make sure coin chosen and board space are valid
//loop until valid input is given 

void moveCoin() { 

scanner scan = new scanner(System.in);
boolean success = false;
int coin;
int moveto;

while(success == false) {

System.out.println("Which coin do you want to move? Enter a number.");
coin = scan.nextInt();
System.out.println("Where do you want to move it? Enter a number.");
moveto = scan.nextInt();



//if there is a coin at the chosen index and the index is within the board
   if(strip[coin] == 1 && coin >= 0 && coin > moveto && coin <= stripSize) {
      //check if there are any coins between our chose coin
      //and the destination.
      for(int i = coin - 1; i >= moveto; i--) {
         if(strip[i] == true) {
         System.out.println("Not a valid move.");
         }
         else {
            strip[moveto] = true;
            strip[coin] = false;
            success = true;
          }
        }
}

}
	
	void printBoard() {
//prints the board
//along with a row of integers to display position info
char COIN = '0';
char SPACE = '-';


   for(int i = 0; i < strip.length; i++) {
      System.out.print(i);
      }
      //carriage return
      System.out.println("");
      //parse the array and represent each space with a 
      //SPACE or COIN
      for(int i = 0; i < strip.length; i++) {
         if(strip[i] == false) 
            System.out.print(SPACE);
         else if(strip[i] == true)
            System.out.print(COIN);
       }
     }
}

	
	
	public static void main(String[] args) {
		
		Silverdollar game = new Silverdollar();
		
		System.out.println("Welcome to the Silver Dollar game!");
		System.out.println("");
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter the length of your strip!");
		String useInpSize = console.next();
		System.out.println("");
		int gameSize = Integer.parseInt(useInpSize);
		game.strip(gameSize);
		
		// TODO Auto-generated method stub

	}

}
