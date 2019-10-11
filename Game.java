import java.util.Scanner;
public class Game {
	
//INSTANCE VARIABLES 



public static void main (String[] args){
	boolean game = true;
	String player = "";
	Board b = new Board();
	int i =1;
	b.printBoard();
	while (game==true){
		if (i % 2 ==0)
		{player = "P2";}
		else 
		{player = "P1";}
	System.out.println(player + " please enter your move: ");
	Scanner keyboard=new Scanner(System.in);
	String move=keyboard.nextLine();
	i+=1;
	b.changeBoard(move);
	b.printBoard();
    }}

}
