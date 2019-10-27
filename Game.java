import java.util.Scanner;
public class Game {
	
//INSTANCE VARIABLES 
public static int turn;
public static boolean isW;

public static void main (String[] args){
	boolean game = true;
	boolean canMove;
	String player = "";
	turn =1;
	Board b = new Board();
	b.printBoard();
	while (game==true){
		if (turn % 2 ==0)
		{player = "P2";}
		else 
		{player = "P1";}
		
		if (player == "P1"){isW=true;}
		else {isW=false;}
	
	System.out.println(player + " please enter your move: ");
	Scanner keyboard=new Scanner(System.in);
	String move=keyboard.nextLine();
	canMove=b.scanBoard(move);
	//System.out.println(canMove);
	if (canMove==true){
	turn+=1;
	b.printBoard();
	}
	if (b.isCheck(Board.chessBoard)==true){
		//System.out.println("Youre in Check, Try again!");
		System.out.println("Youre in Check!");
		}
	else if(canMove==false) {System.out.println("Invalid move, Try again!");}
	
   }}
   

}
