//Matthew, David, Dino, Ryan
//02/25/15

import java.util.*;

public class Silverdollar {

//array representing the board
boolean[] strip;
int gameCoin;
//int nextSpace;*/
int gameSize = 11;


//whose turn is it?
String PLAYER1 = "Player 1";
String PLAYER2 = "Player 2";
String WhoseTurn = PLAYER2;


public Silverdollar(){
//post: creates the game
//(Math.random() * .25) + 3;
}

void createBoard(int numcoins) {
   int coins = numcoins;
   boolean success = false;
   int rand = 0;
   
   for(int i = 0; i < gameSize; i++) 
   {
   strip[i] = false; //initialize an empty board
   //System.out.println(strip[i]);
   }
   
   while(success == false && coins > 0) {
      while(coins > 0)
         for(int i = 0; i < gameSize; i++){
            rand = (int)(Math.random()*4 + 1); 
            if(rand == 4 && coins > 0) {//1 in 4 chance of generating a coin 
               strip[i] = true;
               coins--;
              

            }
          } 
            for(int i = 0; i < numcoins; i++) { //check to make sure we didnt generate a board with coins in the finish condition
            if(strip[i] == false) {
               success = true;
            }    
          }
          
     //System.out.println(success);

    }      
}// end createBoard()

public void coins(){
//post: creates a number of coins
Random newCoin = new Random();
double value = gameSize * .33; //a third of the board can be coins
gameCoin = (int)(Math.random()*value + 3);
}

boolean isDone() { //is the board in game end condition?
   boolean done = true;
   
   for(int i = 0; i < gameCoin; i++) { 
   //System.out.print(strip[i]);
            if(strip[i] == false)
               done = false;
          }
          
   return done;
}//end isDone()


//method for moving a coin: input a coin
//and position to move to, as represented by indices
//check to make sure coin chosen and board space are valid
//loop until valid input is given
void moveCoin() {
Scanner scan = new Scanner(System.in);
boolean success = false;
boolean obstructed = false;
boolean valid = false;
int coin = 0;
int moveto = 0;
   
      while(success == false) {
      obstructed = false;
      while(valid == false) {
      
         System.out.println("Which coin do you want to move? Enter a number.");
         coin = scan.nextInt();
         System.out.println("Where do you want to move it? Enter a number.");
         moveto = scan.nextInt();
      //if there is a coin at the chosen index and the index is within the board
      if(strip[coin] == true && coin >= 0 && coin > moveto && coin <= strip.length)
      valid = true;
      else {System.out.println("That isn't a valid move.");
      printBoard();
      }
      }
      
      
      //check if there are any coins between our chose coin
      //and the destination.
         for(int i = coin - 1; i >= moveto; i--) {
            if(strip[i] == true) {
               obstructed = true; //there's a coin in the way, this isn't a valid move
            }
         }
         if(obstructed == true){
         System.out.println("That isn't a valid move");
         valid = false;
          printBoard();
         }
         else {
            strip[moveto] = true;
            strip[coin] = false;
            success = true;
         }
         
      }
   
} //end moveCoin()

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
   System.out.println("");
} // end printBoard()

public static void main(String[] args) {
Silverdollar game = new Silverdollar();
System.out.println("Welcome to the Silver Dollar game!");
System.out.println("");
Scanner console = new Scanner(System.in);
String useInpSize;


while(game.gameSize > 10){
System.out.println("Please enter the length of your strip! Enter an integer 1-10");
useInpSize = console.next();

System.out.println("");
game.gameSize = Integer.parseInt(useInpSize);
}
game.strip = new boolean[game.gameSize];

game.coins();
//System.out.println(game.gameCoin);
game.createBoard(game.gameCoin);
//game.printBoard();

while(!game.isDone()) {
   if(game.WhoseTurn == game.PLAYER1)
      game.WhoseTurn = game.PLAYER2;
   else game.WhoseTurn = game.PLAYER1;
   
   System.out.println(game.WhoseTurn + "'s turn!");
   game.printBoard();
   game.moveCoin();
   }
   

System.out.println(game.WhoseTurn + " is the winner!");



} //end main()

}//end Silverdollar
